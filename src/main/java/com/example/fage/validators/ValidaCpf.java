package com.example.fage.validators;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = CPFValidator.class)
@Documented
public @interface ValidaCpf {
    String message() default "CPF inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

// package com.example.fage.validators;
// import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

// import jakarta.validation.Payload;

// import java.lang.annotation.*;

// @Target({ElementType.FIELD})
// @Retention(RetentionPolicy.RUNTIME)
// @jakarta.validation.Constraint(validatedBy = CPFValidator.class)
// @Documented
// public @interface ValidaCpf {
//     String message() default "CPF inválido";
//     Class<?>[] groups() default {};
//     Class<? extends Payload>[] payload() default {};
// }