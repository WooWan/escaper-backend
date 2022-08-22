package escaper.backend.error.exception;

import escaper.backend.error.dto.ErrorCode;

import java.text.MessageFormat;

public class ThemeException extends BusinessException{

    public ThemeException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static ThemeException notFoundTheme(Long themeId) {
        return new ThemeException(ErrorCode.NOT_FOUND_MEMBER, MessageFormat.format("존재하지 않는 테마입니다. (id:{0})", themeId));
    }
}
