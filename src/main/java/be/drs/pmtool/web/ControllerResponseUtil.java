package be.drs.pmtool.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;
import java.util.stream.Collectors;

public class ControllerResponseUtil {

    public static Optional<ResponseEntity<?>> createResponseForInvalidInput(BindingResult result){
        return result.hasErrors()
                ? Optional.of(ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(result.getFieldErrors().stream()
                        .collect(Collectors.toMap(
                                FieldError::getField,
                                FieldError::getDefaultMessage))))
                : Optional.empty();

    }

}
