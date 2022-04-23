package escaper.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private String title;
    private String content;

    public PostResponseDto(Post post) {

    }
}
