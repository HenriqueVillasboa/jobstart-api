package br.com.unifil.jobstartapi.controller;

import br.com.unifil.jobstartapi.exception.ValidacaoException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ResponseBody
    @ExceptionHandler(ValidacaoException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<Message> validacaoError(ValidacaoException ex) {
        return Collections.singletonList(new Message(ex.getMessage()));
    }

    @Data
    private class Message {

        private String message;

        public Message(String message) {
            this.message = message;
        }
    }
}
