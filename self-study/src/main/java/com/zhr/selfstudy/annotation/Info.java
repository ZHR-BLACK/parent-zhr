package com.zhr.selfstudy.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {

    String value() default "tracy";

    boolean isDelete();
}
