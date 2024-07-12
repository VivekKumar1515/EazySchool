package org.eazybyte.com.eazybyteschool.RestController;

import lombok.extern.slf4j.Slf4j;
import org.eazybyte.com.eazybyteschool.Model.Response;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {




    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> exception(Exception e) {
        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Response response = new Response(status.toString(), ex.getBindingResult().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
