package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostDto;
import escaper.backend.dto.post.PostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.post.PostResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PostConverter {

    public static Post toPost(CreatePostDto postRequest) {
        return Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .participation(postRequest.getParticipation())
                .appointmentDate(postRequest.getDate())
                .views(0)
                .build();
    }

    public static PostResponse toPostResponse(Post post) {
        return PostResponse.builder()
                .post(post)
                .build();
    }

    public static CreatePostDto toPostCreateDto(String memberId, PostRequest postRequest) {
        return CreatePostDto.builder()
                .memberId(memberId)
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .themeName(postRequest.getThemeName())
                .date(postRequest.getDate())
                .participation(postRequest.getParticipation())
                .views(postRequest.getViews())
                .build();
    }
}
