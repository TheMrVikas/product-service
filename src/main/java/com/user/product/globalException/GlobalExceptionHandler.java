package com.user.product.globalException;

import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.product.exception.ProductNotFoundException;

/**
 * Description: this class is responsible for handle exception
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = ProductNotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(ProductNotFoundException ex){
		return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
}
