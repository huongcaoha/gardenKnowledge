package com.ra.session01.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleCheckFileEmpty.class)
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckFileEmpty {
    String message() default "File can not be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
