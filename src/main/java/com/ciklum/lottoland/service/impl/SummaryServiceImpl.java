package com.ciklum.lottoland.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ciklum.lottoland.api.OptionGameEnum;
import com.ciklum.lottoland.api.Summary;
import com.ciklum.lottoland.service.SummaryService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SummaryServiceImpl implements SummaryService {

	private Summary summary;

	public SummaryServiceImpl() {
		this.summary = new Summary();
	}

	@Override
	public Summary getSummary() {
		return summary;
	}

	@Override
	public void updateSummary(OptionGameEnum playerOne,OptionGameEnum playerTwo) {
		if(playerOne.equals(playerTwo)) {
			summary.setDraws(summary.getDraws()+1L);
		}else if(winPlayerOne(playerOne, playerTwo)) {
			summary.setWinsPlayerOne(summary.getWinsPlayerOne()+1L);
		}else {
			summary.setWinsPlayerTwo(summary.getWinsPlayerTwo()+1L);
		}
		
	}

	private boolean winPlayerOne(OptionGameEnum playerOne, OptionGameEnum playerTwo) {
		return (playerOne.equals(OptionGameEnum.PAPER) && playerTwo.equals(OptionGameEnum.ROCK)) || (playerOne.equals(OptionGameEnum.SCISSORS) && playerTwo.equals(OptionGameEnum.PAPER)) || (playerOne.equals(OptionGameEnum.ROCK) && playerTwo.equals(OptionGameEnum.SCISSORS));
	}

}
