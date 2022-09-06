package escaper.backend.dto.comment;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateCommentRequest {

    private String content;
    private String memberId;

    @Builder
    public CreateCommentRequest(String content, String memberId){
        this.content = content;
        this.memberId = memberId;
    }
}
