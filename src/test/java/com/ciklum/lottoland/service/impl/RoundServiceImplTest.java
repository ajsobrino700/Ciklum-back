package com.ciklum.lottoland.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ciklum.lottoland.api.Round;
import com.ciklum.lottoland.service.SummaryService;

public class RoundServiceImplTest {

	@InjectMocks
	private RoundServiceImpl roundServiceImpl;
	
	@Mock
	private SummaryService summaryService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		Mockito.doNothing().when(this.summaryService).updateSummary(Mockito.any(), Mockito.any());
	}
	
	
	@Test
	void successTest() {
		Round round = roundServiceImpl.playRound();
	
		assertThat(round).isNotNull();
		assertThat(round.getPlayerOne()).isNotNull();
		assertThat(round.getPlayerTwo()).isNotNull();
		
		Mockito.verify(this.summaryService).updateSummary(Mockito.any(), Mockito.any());
	}
	
}
