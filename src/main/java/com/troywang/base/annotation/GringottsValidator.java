package com.troywang.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotation-based validator
 * Created by troywang on 2018/5/14.
 */
@Target(value = {ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface GringottsValidator {

    boolean blankable() default false;

    String regex() default "";

    String desc() default "";
}
