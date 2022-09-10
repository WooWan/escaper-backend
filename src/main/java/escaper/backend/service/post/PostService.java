package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostDto;
import escaper.backend.dto.post.PostUpdateRequest;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.post.PostResponse;
import escaper.backend.entity.theme.Theme;
import escaper.backend.error.exception.MemberException;
import escaper.backend.error.exception.PostException;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ThemeRepository themeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long savePost(CreatePostDto request) {
        Theme findTheme = themeRepository.findByName(request.getThemeName());
        String memberId = request.getMemberId();
        Member findMember = memberRepository.findMemberByUserId(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));
        Post newPost = PostConverter.toPost(request);
        newPost.registerPost(findMember);
        newPost.addTheme(findTheme);
        return postRepository.save(newPost).getId();
    }

    public Page<PostResponse> getPostsPaging(Pageable pageable) {
        Page<Post> posts = postRepository.findPagePost(pageable);
        return posts.map(PostResponse::new);
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public PostResponse fetchPost(Long id) {
        Post post = postRepository.fetchPost(id);
        return PostConverter.toPostResponse(post);
    }

    @Transactional
    public void updatePost(PostUpdateRequest postUpdateRequest, Long postId) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> PostException.notFoundPost(postId));
        Theme findTheme = themeRepository.findByName(postUpdateRequest.getThemeName());
        findPost.updatePost(postUpdateRequest, findTheme);
    }
}
