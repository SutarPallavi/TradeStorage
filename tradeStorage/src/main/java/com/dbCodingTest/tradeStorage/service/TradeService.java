package com.dbCodingTest.tradeStorage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dbCodingTest.tradeStorage.dao.TradeDao;
import com.dbCodingTest.tradeStorage.dao.TradeRepository;
import com.dbCodingTest.tradeStorage.model.Trade;

@Service
public class TradeService {

	private static final Logger log= LoggerFactory.getLogger(TradeService.class);
	
	@Autowired
	TradeDao tradeDao;
	
	@Autowired
	TradeRepository tradeRepository; 
	
	
	public boolean isValid (Trade trade) {
		
		if(validateMaturityDate(trade)) {
		Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
		if(exsitingTrade.isPresent()) {
			return validateVersion(trade, exsitingTrade.get());
			
			
		}else return true; 
				
		}
		return false; 
	}

	private boolean validateVersion(Trade trade, Trade oldTrade) {
		if(trade.getVersion() >= oldTrade.getVersion()) {
			return true;
		}

		return false;
	}

	private boolean validateMaturityDate(Trade trade) {
		
		if (trade.getMaturityDate().isBefore(LocalDate.now()))
			return false;
		else
			return true;
	}
	
	// need to add all the fields 
	public void persist(Trade trade) {
		
		trade.setCreatedDate(LocalDate.now());
		tradeRepository.save(trade);
		
	}
	
	public List<Trade> findAll(){
		return tradeRepository.findAll();
	}
	
	
	public void updateExpiryFlagOfTrade() {
		
		tradeRepository.findAll().stream().forEach(t-> {
			if(!validateMaturityDate(t)) {
				
				t.setExpiredFlag("Y");
				//log.info("Trade which needs to updated {}", t);
				tradeDao.save(t);
			}
			
		});
	}
	
	
}
