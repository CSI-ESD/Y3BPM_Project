package com.alexandru.esdbloodpressure.validators;

import com.alexandru.esdbloodpressure.annotations.FieldsValueMatch;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
public class FieldsValueMatchValidator
        implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;
    private String message;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
        this.message = constraintAnnotation.message();
    }

    public boolean isValid(Object value,
            ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);
        boolean result;
        if (fieldValue != null) {
            result = fieldValue.equals(fieldMatchValue);
        } else {
            result = fieldMatchValue == null;
        }

        if (!result) {
            context.disableDefaultConstraintViolation();
            //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
            context.buildConstraintViolationWithTemplate(message).addNode(fieldMatch).addConstraintViolation();
        }
        return result;
    }
}
