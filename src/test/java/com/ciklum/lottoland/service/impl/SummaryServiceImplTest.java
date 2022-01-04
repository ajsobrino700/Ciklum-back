package com.ciklum.lottoland.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.ciklum.lottoland.api.OptionGameEnum;
import com.ciklum.lottoland.api.Summary;

public class SummaryServiceImplTest {

	@InjectMocks
	private SummaryServiceImpl summaryServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getDataTest() {
		Summary summary = this.summaryServiceImpl.getSummary();
		
		assertThat(summary).isNotNull();
	}
	
	@Test
	void gameRoundEachOptionTest() {
		this.summaryServiceImpl.updateSummary(OptionGameEnum.PAPER, OptionGameEnum.PAPER);
		this.summaryServiceImpl.updateSummary(OptionGameEnum.PAPER, OptionGameEnum.ROCK);
		this.summaryServiceImpl.updateSummary(OptionGameEnum.SCISSORS, OptionGameEnum.ROCK);
		
		Summary summary = this.summaryServiceImpl.getSummary();
		
		assertThat(summary).isNotNull();
		assertThat(summary.getDraws()).isNotNull().isEqualTo(1);
		assertThat(summary.getWinsPlayerOne()).isNotNull().isEqualTo(1);
		assertThat(summary.getWinsPlayerTwo()).isNotNull().isEqualTo(1);
	}
	
}
