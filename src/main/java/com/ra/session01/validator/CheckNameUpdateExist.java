package com.ra.session01.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleNameUpdateExisted.class)
@Target({ElementType.METHOD,ElementType.FIELD, ElementType.ANNOTATION_TYPE ,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNameUpdateExist {
    String message() default "Name already existed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> entityClass() ;
    String fieldName() ;
    String oldName();
}
