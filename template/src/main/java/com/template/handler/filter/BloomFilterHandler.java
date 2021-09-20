package com.template.handler.filter;

import com.template.utils.BloomFilterUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import java.util.Date;

/**
 * 过滤器
 */
@Component
public class BloomFilterHandler implements Filter {

    @Resource
    public BloomFilterUtils bloomFilterUtils;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        System.out.println("[INFO]--" + new Date() + "--[INFO]" + "execute BloomFilterHandler");

        boolean pass = bloomFilterUtils.get(servletRequest);
    }

    @Override
    public void destroy() {

    }
}