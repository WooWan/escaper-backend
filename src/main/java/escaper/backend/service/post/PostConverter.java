package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.post.PostResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PostConverter {

    public static Post toPost(CreatePostRequest createPostRequest) {
        return Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .participation(createPostRequest.getParticipation())
                .appointmentDate(createPostRequest.getDate())
                .views(0)
                .build();
    }

    public static PostResponse toPostResponse(Post post) {
        return PostResponse.builder()
                .post(post)
                .build();
    }
}
