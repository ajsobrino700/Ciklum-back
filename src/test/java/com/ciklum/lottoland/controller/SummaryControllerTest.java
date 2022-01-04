package com.ciklum.lottoland.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ciklum.lottoland.api.Summary;
import com.ciklum.lottoland.service.impl.SummaryServiceImpl;

public class SummaryControllerTest {

	@InjectMocks
	private SummaryController summaryController;
	
	@Mock
	private SummaryServiceImpl summaryService;
	
	@BeforeEach
	void setUp(){
		MockitoAnnotations.openMocks(this);
		
		Mockito.when(this.summaryService.getSummary()).thenReturn(Summary.builder().draws(1L).winsPlayerOne(2L).winsPlayerTwo(0L).build());
	}
	
	
	@Test
	void getSummaryTest() {
		ResponseEntity<Summary> summaryResponse = this.summaryController.getSummary();
		
		assertThat(summaryResponse).isNotNull();
		assertThat(summaryResponse.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
		assertThat(summaryResponse.getBody()).isNotNull();
		assertThat(summaryResponse.getBody().getDraws()).isNotNull().isEqualTo(1);
		assertThat(summaryResponse.getBody().getWinsPlayerOne()).isNotNull().isEqualTo(2);
		assertThat(summaryResponse.getBody().getWinsPlayerTwo()).isNotNull().isEqualTo(0);
		
		Mockito.verify(this.summaryService).getSummary();
	}
	
	
	
}
