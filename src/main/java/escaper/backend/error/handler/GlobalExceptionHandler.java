package escaper.backend.error.handler;

import escaper.backend.error.dto.ErrorResult;
import escaper.backend.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ErrorResult illegalExHandler(BusinessException ex) {
        log.error("Business excpetion: ${}", ex.getMessage(), ex);
        return new ErrorResult(ex.getErrorCode());
    }
}
