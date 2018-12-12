package com.lms.frame.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 书属性
 */

@Component
@ConfigurationProperties("demo.book")
@Validated
public class BookComponent {

    @NotNull
    private String name;

    @NotNull
    private String writer;
}
