package com.virtusa.libraryManagement.Advice;

import java.util.HashMap;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.virtusa.libraryManagement.exception.BookNotFoundException;
import com.virtusa.libraryManagement.exception.FileNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errorMap.put(error.getField(), error.getDefaultMessage());
	        });
	        return errorMap;
	    }

//	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	    @ExceptionHandler(FileNotFoundException.class)
//	    public Map<String, String> handleBusinessException(FileNotFoundException ex) {
//	        Map<String, String> errorMap = new HashMap<>();
//	        errorMap.put("errorMessage", ex.getMessage());
//	        return errorMap;
//	    }
	    
	    @ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String>handleSuchException(NoSuchElementException elemetException){
			return new ResponseEntity<String>("no value id present in DB ,Please change your Request",HttpStatus.NOT_FOUND);
		}
	    
	    @ExceptionHandler(EmptyResultDataAccessException.class)
		public ResponseEntity<String>handleException(EmptyResultDataAccessException elemException){
			return new ResponseEntity<String>("no value id present in DB ,Please change your Request",HttpStatus.NOT_FOUND);
		}

	}


