package pe.client.custom.app.validation;

import pe.client.custom.app.choice.PaymentMethodType;
import pe.client.custom.app.validation.annotation.PaymentMethodTypeValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PaymentMethodTypeValidator implements ConstraintValidator<PaymentMethodTypeValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            return PaymentMethodType.get(value) != null;
        } else {
            return false;
        }
    }

}
