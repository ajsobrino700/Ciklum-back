package com.ciklum.lottoland.service;

import com.ciklum.lottoland.api.OptionGameEnum;
import com.ciklum.lottoland.api.Summary;

public interface SummaryService {

	Summary getSummary();
	
	void updateSummary(OptionGameEnum playerOne,OptionGameEnum playerTwo);
	
	
}
