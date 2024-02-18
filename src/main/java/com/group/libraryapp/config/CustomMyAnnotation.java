package com.group.libraryapp.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
@RestController
@RequestMapping("/new")
public @interface CustomMyAnnotation {

    String name() default "MemberController";
    String value();
}
