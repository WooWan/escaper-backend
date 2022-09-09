package escaper.backend.error.exception;

import escaper.backend.error.dto.ErrorCode;

import java.text.MessageFormat;

public class PostException extends BusinessException{
    public PostException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static ReviewException notFoundPost(Long postId) {
        return new ReviewException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("해당하는 리뷰가 존재하지 않습니다.. (postId:{0}), (themeId:{1})", postId));
    }
}
