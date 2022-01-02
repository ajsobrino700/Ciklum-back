package com.ciklum.lottoland.api;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The options are rock, paper or scissors")
public enum OptionGameEnum {
	
	ROCK(0),
	PAPER(1),
	SCISSORS(2);
	
	private Integer option;
	
	private static final Map<Integer, OptionGameEnum> NUMBER_TO_ENUM = Arrays.stream(values())
			.collect(Collectors.toMap(OptionGameEnum::getOption, Function.identity()));
	
	OptionGameEnum(Integer option) {
		this.option = option;
	}

	public Integer getOption() {
		return option;
	}

	public static OptionGameEnum getByNumber(Integer number) {
		return NUMBER_TO_ENUM.get(number);
	}
}
