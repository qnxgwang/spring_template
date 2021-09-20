package com.template.handler.aop;

import com.template.utils.JsonMapUtils;
import com.template.utils.Status;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切面类
 */
@Component
@Aspect
public class ResponseHandler {

    /**
     * 对业务方法添加返回值
     */
    @Around(value = "execution(* com.template.controller.PlayerController.*(..))")
    public Object AroundMethod(ProceedingJoinPoint point) throws Throwable {

        System.out.println("[INFO]--" + new Date() + "--[INFO]" + "execute AroundMethod");

        Object result = point.proceed();

        return JsonMapUtils.mapUtils(Status.Success.getCode(), Status.Success.getMessage(), result);
    }
}
