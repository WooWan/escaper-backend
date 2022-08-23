package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PostConverter {

    public static Post toPost(CreatePostRequest createPostRequest) {
        return Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .participation(createPostRequest.getParticipation())
                .appointmentDate(createPostRequest.getAppointmentDate())
                .views(0)
                .build();
    }
}
