package com.example.spring.controller.error;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler{

	
	
	@ExceptionHandler(EstudianteNoEncontradoException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException{
		
		logger.info("----- Excepción de estudiante no encontrado()");		
		response.sendError(HttpStatus.NOT_FOUND.value());		
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException{
		
		logger.info("----- ConstrainViolationException() ");
		response.sendError(HttpStatus.NOT_FOUND.value());
		
	}

	

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		logger.info("------ handleHttpRequestMethodNotSupported()");
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append("El método no está soportado para esta solicitud. Los métodos permitidos son: ");
		ex.getSupportedHttpMethods().forEach(t-> builder.append(t + " "));
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		body.put("status", status.value());
		body.put("error", ex.getLocalizedMessage());
		body.put("message", builder.toString());
		return new ResponseEntity<Object> (body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
	
}
