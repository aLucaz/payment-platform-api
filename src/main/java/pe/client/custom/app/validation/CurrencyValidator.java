package pe.client.custom.app.validation;

import pe.client.custom.app.choice.Currency;
import pe.client.custom.app.validation.annotation.CurrencyValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CurrencyValidator implements ConstraintValidator<CurrencyValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            return Currency.get(value) != null;
        } else {
            return false;
        }
    }

}
