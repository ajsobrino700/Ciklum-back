package com.ciklum.lottoland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ciklum.lottoland.api.ProblemApp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProblemApp> handleTicketGatewayException(Exception ex) {
		log.error("There was a generic error: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ProblemApp.builder().description(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.message("If the problem continue, then you must with system admin").build());
	}

}
