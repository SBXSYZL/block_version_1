package com.project.demo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description:
 * @author: YZL
 * @time: 2020/3/21 17:31
 */

public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = (requestAttributes).getRequest();
            Enumeration headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String headerName = (String) headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    requestTemplate.header(headerName, headerValue);
                }
            }
        } else {
            System.out.println("requestAttributes was empty-----------------------------------------------------------------");
        }


    }
}
