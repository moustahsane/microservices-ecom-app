package me.moustahsane.orderservice.openfieng.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class OpenFeignInterceptor implements RequestInterceptor {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Override
    public void apply(RequestTemplate requestTemplate) {

        //Best to obtain JWT Token from SecurityContextHolder

        requestTemplate.header("Authorization", httpServletRequest.getHeader("Authorization"));

    }
}
