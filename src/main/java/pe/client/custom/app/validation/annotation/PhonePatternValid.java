package pe.client.custom.app.validation.annotation;

import pe.client.custom.app.util.constant.Message;
import pe.client.custom.app.util.constant.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;


@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = Validation.PHONE_PATTERN, message = Message.MSG_PHONE_WRONG_FORMAT)
public @interface PhonePatternValid {
    String message() default Message.MSG_PHONE_WRONG_FORMAT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
