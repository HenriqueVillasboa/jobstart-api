package br.com.unifil.jobstartapi.controller;

import br.com.unifil.jobstartapi.exception.ValidacaoException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ResponseBody
    @ExceptionHandler(ValidacaoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Message> validationError(ValidacaoException ex) {
        return Collections.singletonList(new Message(ex.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Message> argumentValidationError(MethodArgumentNotValidException ex) {
        var result = ex.getBindingResult();

        return result.getFieldErrors().stream()
                .map(e -> e.getDefaultMessage().toLowerCase().contains("campo")
                        ? new Message(e.getDefaultMessage())
                        : new Message(e.getField(), "O campo " + e.getField() + " " + e.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @Data
    private class Message {

        private String message;
        private String field;

        public Message(String message) {
            this.message = message;
        }

        public Message(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
