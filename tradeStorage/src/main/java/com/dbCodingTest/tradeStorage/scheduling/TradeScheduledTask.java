package com.dbCodingTest.tradeStorage.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dbCodingTest.tradeStorage.service.TradeService;

@Component
public class TradeScheduledTask {

	private static final Logger Log = LoggerFactory.getLogger(TradeScheduledTask.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	@Autowired
	TradeService tradeService;
	
	@Scheduled(cron = "${trade.expiry.schedule}") // added in application.properties for 30 Sec. 
	public void reportCurrentTime() {
		Log.info("the time id : ", dateFormat.format(new Date()));
		tradeService.updateExpiryFlagOfTrade();
	}
}
