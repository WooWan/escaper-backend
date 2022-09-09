package escaper.backend.dto.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostUpdateRequest {

    private String title;
    private String content;
    private Integer participation;
    private LocalDate appointmentDate;
    private String themeName;

    @Builder
    public PostUpdateRequest(){

    }

}
