package com.codingShuttle.LinkedIn.posts_service.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Long userid = UserContextHolder.getCurrentUserId();
        if(userid!=null){
            requestTemplate.header("X-User-Id" , userid.toString());
        }
    }
}
