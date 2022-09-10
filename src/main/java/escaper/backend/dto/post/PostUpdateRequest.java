package escaper.backend.dto.post;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUpdateRequest {

    private String title;
    private String content;
    private Integer participation;
    private LocalDate appointmentDate;
    private String themeName;
}
