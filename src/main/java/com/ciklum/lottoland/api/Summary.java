package com.ciklum.lottoland.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "It is the summary of game",subTypes = {OptionGameEnum.class})
public class Summary {

	@Schema(description = "The wins for playerOne")
	@Builder.Default
	private Long winsPlayerOne = 0L;
	
	@Builder.Default
	@Schema(description = "The wins for playerTwo")
	private Long winsPlayerTwo=0L ;
	
	@Builder.Default
	@Schema(description = "The draws")
	private Long draws=0L;
	
}
