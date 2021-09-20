package com.template.handler.exception;

import com.template.utils.JsonMapUtils;
import com.template.utils.Status;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理参数不合法异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        System.out.println("[INFO]--" + new Date() + "--[INFO]" + "execute handleMethodArgumentNotValidException");

        return JsonMapUtils.mapUtils(Status.ArgumentNotValid.getCode(),
                Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(), null);
    }

    /**
     * 处理未知异常
     */
    @ExceptionHandler
    public Map<String, Object> handleOtherError(Exception e) {

        System.out.println("[INFO]--" + new Date() + "--[INFO]" + "execute handleOtherError");

        return JsonMapUtils.mapUtils(Status.UnknownError.getCode(),
                Status.UnknownError.getMessage(), null);
    }
}
