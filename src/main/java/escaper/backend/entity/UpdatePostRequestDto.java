package escaper.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePostRequestDto {

    private String title;
    private String content;
}
