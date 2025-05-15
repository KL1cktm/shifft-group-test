package by.korona.sub.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionApiHandler {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({ChannelNotFoundException.class})
    public ChannelNotFoundException handleHttpClientErrorException(ChannelNotFoundException e) {
        log.warn("ChannelNotFoundException", e);
        return e;
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({UserNotFoundException.class})
    public UserNotFoundException handleRanOutOfAttemptsException(UserNotFoundException e) {
        log.warn("UserNotFoundException", e);
        return e;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public Exception handleException(Exception e) {
        log.error("INTERNAL_SERVER_ERROR", e);
        return e;
    }
}
