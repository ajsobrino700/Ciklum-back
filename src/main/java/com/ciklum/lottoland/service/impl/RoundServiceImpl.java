package com.ciklum.lottoland.service.impl;

import org.springframework.stereotype.Service;

import com.ciklum.lottoland.api.OptionGameEnum;
import com.ciklum.lottoland.api.Round;
import com.ciklum.lottoland.service.RoundService;

@Service
public class RoundServiceImpl implements RoundService {

	@Override
	public Round playRound() {
		return Round.builder().playerTwo(OptionGameEnum.ROCK).playerOne(generateOption()).build();
	}
	
	private OptionGameEnum generateOption() {
		Integer randomNumber = (int) (Math.random()*3);
		return OptionGameEnum.getByNumber(randomNumber);
	}

}
