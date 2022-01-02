package com.ciklum.lottoland.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ciklum.lottoland.api.Round;

@SpringBootTest
public class RoundControllerTest {

	@Autowired

	private RoundController roundController;

	@Test
	void sucessTest() {

		ResponseEntity<Round> round = roundController.playRound();

		assertThat(round).isNotNull();
		assertThat(round.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
		assertThat(round.getBody()).isNotNull();
		assertThat(round.getBody().getPlayerOne()).isNotNull();
		assertThat(round.getBody().getPlayerTwo()).isNotNull();
	}

}
