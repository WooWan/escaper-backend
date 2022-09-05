package escaper.backend.error.exception;

import escaper.backend.error.dto.ErrorCode;

import java.text.MessageFormat;

public class MemberException extends BusinessException {

    public MemberException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MemberException notFoundMember(Long memberId) {
        return new MemberException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("존재하지 않는 회원입니다. (id:{0})", memberId));
    }
    public static MemberException notFoundMember(String memberId) {
        return new MemberException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("존재하지 않는 회원입니다. (id:{0})", memberId));
    }

    public static MemberException invalidSignup() {
        return new MemberException(ErrorCode.INVALID_SIGNUP,"회원가입 시간이 지났습니다");
    }
}
