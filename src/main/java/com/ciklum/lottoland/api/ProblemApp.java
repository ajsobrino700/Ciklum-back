package com.ciklum.lottoland.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "It is information of the error")
public class ProblemApp {

	@Schema(description = "Status code of request")
	private String status;
	
	@Schema(description = "Description about the error")
	private String description;
	
	@Schema(description = "Message of error")
	private String message;
	
}
