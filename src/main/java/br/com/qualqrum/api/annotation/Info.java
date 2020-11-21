package br.com.qualqrum.api.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Info {

    String description() default "";

    String path() default "";

    String[] params() default {""};
}
