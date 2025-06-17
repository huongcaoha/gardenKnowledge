package com.ra.session01.validator;

import com.ra.session01.validator.CheckNameUpdateExist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class HandleNameUpdateExisted implements ConstraintValidator<CheckNameUpdateExist, String> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> classEntity;
    private String fieldName;
    private String oldName;

    @Override
    public void initialize(CheckNameUpdateExist constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        oldName = constraintAnnotation.oldName();
        classEntity = constraintAnnotation.entityClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // Không kiểm tra nếu giá trị null
        }

        String query = "SELECT COUNT(*) FROM " + classEntity.getName() + " c WHERE c." + fieldName + " = :name AND c." + fieldName + " != :oldName";
        Long count = (Long) entityManager.createQuery(query)
                .setParameter("name", value)
                .setParameter("oldName", oldName)
                .getSingleResult();

        return count == 0;
    }
}