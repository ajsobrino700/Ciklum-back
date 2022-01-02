package com.ciklum.lottoland.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.ciklum.lottoland.api.Round;

public class RoundServiceImplTest {

	@InjectMocks
	private RoundServiceImpl roundServiceImpl;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	void successTest() {
		Round round = roundServiceImpl.playRound();
	
		assertThat(round).isNotNull();
		assertThat(round.getPlayerOne()).isNotNull();
		assertThat(round.getPlayerTwo()).isNotNull();
		
	}
	
}
