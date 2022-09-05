package escaper.backend.dto.member;

import lombok.Data;

@Data
public class MemberSaveRequest {

    private String email;
    private String nickname;
}
