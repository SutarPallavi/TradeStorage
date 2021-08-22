package com.dbCodingTest.tradeStorage.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dbCodingTest.tradeStorage.model.Trade;

@Repository
public class TradeDaoImplementation implements TradeDao{

	
	@Override
	public void save(Trade trade) {
		trade.setCreatedDate(LocalDate.now());
		tradeMap.put(trade.getBookId(), trade);
	}

	@Override
	public List<Trade> findAll() {
		
		return tradeMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Trade findTrade(String tradeId) {
		
		return tradeMap.get(tradeId);
	}

	
}
