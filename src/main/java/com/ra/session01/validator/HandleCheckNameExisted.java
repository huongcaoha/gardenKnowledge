package com.ra.session01.validator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class HandleCheckNameExisted implements ConstraintValidator<CheckNameExisted, String> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> classEntity ;
    private String fieldName ;
    @Override
    public void initialize(CheckNameExisted checkNameExisted) {
        classEntity = checkNameExisted.entityClass();
        fieldName = checkNameExisted.fieldName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // Không kiểm tra nếu giá trị null
        }

        String query = "SELECT COUNT(*) FROM " + classEntity.getName() + " c WHERE c." + fieldName + " = :name ";
        Long count = (Long) entityManager.createQuery(query)
                .setParameter("name", value)
                .getSingleResult();

        return count == 0;
    }
}
