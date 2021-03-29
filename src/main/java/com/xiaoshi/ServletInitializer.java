package com.xiaoshi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName ServletInitializer
 * @Author xiaoshi
 * @Date 2021/3/29 16:37
 * @Description
 **/
@Slf4j
public class ServletInitializer extends SpringBootServletInitializer {
    public ServletInitializer() {
        log.info("初始化ServletInitializer");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
