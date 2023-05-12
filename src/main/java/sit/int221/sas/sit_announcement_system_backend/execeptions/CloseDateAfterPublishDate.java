package sit.int221.sas.sit_announcement_system_backend.execeptions;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CloseDateAfterPublishDateValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CloseDateAfterPublishDate {
    String message() default "Close date must be later than publish date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String errorCode() default "CloseDateAfterPublishDate";
}

