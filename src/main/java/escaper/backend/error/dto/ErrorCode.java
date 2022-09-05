package escaper.backend.error.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //member
    NOT_FOUND_MEMBER("M001", "Not found member", HttpStatus.BAD_REQUEST),
    INVALID_SIGNUP("M005", "Signup time is over", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
