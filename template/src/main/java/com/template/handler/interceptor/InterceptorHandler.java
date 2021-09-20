package com.template.handler.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器
 */
@Component
public class InterceptorHandler implements AsyncHandlerInterceptor {

    /**
     * 在控制器方法前面执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("[INFO]--" + new Date() + "--[INFO]" + "execute InterceptorHandler:");

        return true;
    }
}
