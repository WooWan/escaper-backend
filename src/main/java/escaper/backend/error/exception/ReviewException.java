package escaper.backend.error.exception;

import escaper.backend.error.dto.ErrorCode;

import java.text.MessageFormat;

public class ReviewException extends BusinessException{

    public ReviewException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MemberException notFoundReview(Long memberId, Long themeId) {
        return new MemberException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("해당하는 리뷰가 존재하지 않습니다.. (memberId:{0}), (themeId:{1})", memberId, themeId));
    }
}
