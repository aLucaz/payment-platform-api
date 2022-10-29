package pe.client.custom.app.validation;

import pe.client.custom.app.choice.PhoneType;
import pe.client.custom.app.validation.annotation.PhoneTypeValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneTypeValidator implements ConstraintValidator<PhoneTypeValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            return PhoneType.get(value) != null;
        }else {
            return false;
        }
    }

}
