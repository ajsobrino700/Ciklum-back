package com.ciklum.lottoland.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ciklum.lottoland.service.RoundService;

public class RoundControllerUnitTest {

	@InjectMocks
	private RoundController roundController;

	@Mock
	private RoundService roundService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		Mockito.when(roundService.playRound()).thenThrow(new NullPointerException("There was a big problem"));
	}

	@Test
	void errorTest() {

		NullPointerException error = assertThrows(NullPointerException.class, () -> roundController.playRound());
		
		assertThat(error).isNotNull();
		assertThat(error.getMessage()).isEqualTo("There was a big problem");
	}


}
