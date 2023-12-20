package umc.spring.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.ValidPageNumber;

@Component
public class ValidPageNumberValidator implements ConstraintValidator<ValidPageNumber, Integer> {

    @Override
    public void initialize(ValidPageNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean isValid = value >= 0;

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_BELOW_ZERO.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
