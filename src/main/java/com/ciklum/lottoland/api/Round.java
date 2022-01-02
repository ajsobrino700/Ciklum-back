package com.ciklum.lottoland.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "It the option choose by each players",subTypes = {OptionGameEnum.class})
public class Round {

	@Schema(description = "The option for playerOne")
	private OptionGameEnum playerOne;
	
	@Schema(description = "The option for playerTwo")
	private OptionGameEnum playerTwo;
	
}
