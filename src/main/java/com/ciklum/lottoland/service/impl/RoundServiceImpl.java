package com.ciklum.lottoland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciklum.lottoland.api.OptionGameEnum;
import com.ciklum.lottoland.api.Round;
import com.ciklum.lottoland.service.RoundService;
import com.ciklum.lottoland.service.SummaryService;

@Service
public class RoundServiceImpl implements RoundService {

	@Autowired
	private SummaryService summaryService;

	@Override
	public Round playRound() {
		Round round = Round.builder().playerTwo(OptionGameEnum.ROCK).playerOne(generateOption()).build();
		summaryService.updateSummary(round.getPlayerOne(), round.getPlayerTwo());
		return round;
	}

	private OptionGameEnum generateOption() {
		Integer randomNumber = (int) (Math.random() * 3);
		return OptionGameEnum.getByNumber(randomNumber);
	}

}
