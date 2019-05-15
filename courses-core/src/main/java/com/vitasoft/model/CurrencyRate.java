package com.vitasoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrencyRate {
	
	private String currencyPair;
	private LocalDateTime dateTime;
	private BigDecimal askPrice;
	private BigDecimal bidPrice;
	
	public String getCurrencyPair() {
		return currencyPair;
	}
	
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public BigDecimal getAskPrice() {
		return askPrice;
	}
	
	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}
	
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
}
