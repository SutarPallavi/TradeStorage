package com.dbCodingTest.tradeStorage.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trades")
public class Trade {
	@Id
	private String tradeId; 
	private int version;
	private String counterParty;
	private String bookId;
	private LocalDate maturityDate; 
	private LocalDate createdDate; 
	private String expiredFlag;
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterParty() {
		return counterParty;
	}
	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpiredFlag() {
		return expiredFlag;
	}
	public void setExpiredFlag(String expiredFlag) {
		this.expiredFlag = expiredFlag;
	}
	
	/*//Constructor
	public Trade(String tradeId, int version, String counterParty, String bookId, LocalDate maturityDate,
			LocalDate createdDate, String expiredFlag) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterParty = counterParty;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expiredFlag = expiredFlag;
	}
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", version=" + version + ", counterParty=" + counterParty + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + ", expiredFlag="
				+ expiredFlag + "]";
	}
	
		
}
