package com.ciklum.lottoland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciklum.lottoland.api.ProblemApp;
import com.ciklum.lottoland.api.Round;
import com.ciklum.lottoland.service.RoundService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/round")
public class RoundController {
	
	@Autowired
	private RoundService roundService;

	@Operation(summary = "Game a new round", description = "Request for game a new round between two players")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "The round has been play successfully", content = @Content(schema = @Schema(implementation = Round.class))),
			@ApiResponse(responseCode = "500", description = "The was a unexpected error in the server", content = @Content(schema = @Schema(implementation = ProblemApp.class)))})
	@GetMapping
	public ResponseEntity<Round> playRound(){
		return ResponseEntity.ok(roundService.playRound());
	}
	
}
