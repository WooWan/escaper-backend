package escaper.backend.error.exception;

import escaper.backend.error.dto.ErrorCode;

import java.text.MessageFormat;

public class CommentException extends BusinessException{

    public CommentException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static CommentException notFoundComment(Long id) {
        return new CommentException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("해당하는 리뷰가 존재하지 않습니다.. (comment id:{0}), ", id));
    }
}
