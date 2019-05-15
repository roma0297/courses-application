package com.vitasoft.controllers.admin;

import com.vitasoft.model.CurrencyRate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyRateController {
	
	@GetMapping("/currency")
	public String handleForexRequest(Model model) {
		model.addAttribute("todayCurrencyRates", getTodayForexRates());
		return "forexView";
	}
	
	private List<CurrencyRate> getTodayForexRates() {
		List<CurrencyRate> currencyRates = new ArrayList<>();
		LocalDateTime today = LocalDateTime.now();
		List<Currency> currencies = new ArrayList<>(Currency.getAvailableCurrencies());
		
		for (int i = 0; i < currencies.size(); i += 2) {
			String currencyPair = currencies.get(i) + "/" + currencies.get(i + 1);
			CurrencyRate cr = new CurrencyRate();
			cr.setCurrencyPair(currencyPair);
			cr.setDateTime(today);
			BigDecimal bidPrice = new BigDecimal(Math.random() * 5 + 1);
			bidPrice = bidPrice.setScale(3, RoundingMode.CEILING);
			cr.setBidPrice(bidPrice);
			BigDecimal askPrice = new BigDecimal(bidPrice.doubleValue() + Math.random() * 2 + 0.5);
			askPrice = askPrice.setScale(3, RoundingMode.CEILING);
			cr.setAskPrice(askPrice);
			
			currencyRates.add(cr);
		}
		return currencyRates;
	}
}
