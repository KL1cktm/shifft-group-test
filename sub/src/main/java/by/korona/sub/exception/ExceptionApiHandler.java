package by.korona.sub.exception;

import by.korona.sub.exception.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionApiHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ChannelNotFoundException.class})
    public ErrorResponse handleChannelNotFoundException(ChannelNotFoundException e) {
        log.warn("ChannelNotFoundException", e);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now(), Arrays.toString(e.getStackTrace()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class})
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now(), Arrays.toString(e.getStackTrace()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({SubscriptionDetailsNotFoundException.class})
    public ErrorResponse handleSubscriptionDetailsNotFoundException(SubscriptionDetailsNotFoundException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now(), Arrays.toString(e.getStackTrace()));
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ExistSubscribeException.class})
    public ErrorResponse handleExistSubscribeException(ExistSubscribeException e) {
        log.warn(e.getMessage(), e);
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage(), LocalDateTime.now(), Arrays.toString(e.getStackTrace()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public Exception handleException(Exception e) {
        log.error("INTERNAL_SERVER_ERROR", e);
        return e;
    }
}
