package com.ciklum.lottoland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciklum.lottoland.api.ProblemApp;
import com.ciklum.lottoland.api.Round;
import com.ciklum.lottoland.api.Summary;
import com.ciklum.lottoland.service.impl.SummaryServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/summary")
public class SummaryController {

	
	@Autowired
	private SummaryServiceImpl summaryService;

	@Operation(summary = "Get the summary of game", description = "Get the data summary of all users are playing the game")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "The summary has been return successfully", content = @Content(schema = @Schema(implementation = Round.class))),
			@ApiResponse(responseCode = "500", description = "The was a unexpected error in the server", content = @Content(schema = @Schema(implementation = ProblemApp.class)))})
	@GetMapping
	public ResponseEntity<Summary> getSummary(){
		return ResponseEntity.ok(summaryService.getSummary());
	}
	
}
