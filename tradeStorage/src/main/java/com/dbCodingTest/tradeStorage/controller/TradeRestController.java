package com.dbCodingTest.tradeStorage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbCodingTest.tradeStorage.dao.TradeRepository;
import com.dbCodingTest.tradeStorage.model.Trade;
import com.dbCodingTest.tradeStorage.service.TradeService;

@RestController 
public class TradeRestController {

	@Autowired
	TradeService tradeService; 
	@Autowired
	TradeRepository tradeRepository; 
	
	@PostMapping ("/trades/post/trade")
	public ResponseEntity <String> tradeValidateStore (@RequestBody Trade trade){
		
		if(tradeService.isValid(trade)) {
			tradeService.persist(trade);
		}else {
			
			
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
		
	}
	
	
	@GetMapping("/trades/getAllTrades")
	public List<Trade> findAllTrades(){
		
		return tradeService.findAll(); 
	}
}
