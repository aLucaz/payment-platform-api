package pe.client.custom.app.validation.annotation;

import pe.client.custom.app.util.constant.Message;
import pe.client.custom.app.validation.PhoneTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneTypeValidator.class)
public @interface PhoneTypeValid {
    String message() default Message.MSG_PHONE_TYPE_WRONG_FORMAT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
