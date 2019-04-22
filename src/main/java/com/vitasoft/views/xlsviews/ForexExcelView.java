package com.vitasoft.views.xlsviews;

import com.vitasoft.model.CurrencyRate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

@Component("forexView")
public class ForexExcelView extends AbstractXlsView {
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
										Workbook workbook,
										HttpServletRequest request,
										HttpServletResponse response) throws Exception {
		
		List<CurrencyRate> currencyRates = (List<CurrencyRate>) model.get("todayCurrencyRates");
		Sheet sheet = workbook.createSheet("Today Currency Rates");
		sheet.setFitToPage(true);
		
		int rowCount = 0;
		Row header = sheet.createRow(rowCount++);
		header.createCell(0).setCellValue("Currency Pair");
		header.createCell(1).setCellValue("Bid Price");
		header.createCell(2).setCellValue("Ask Price");
		header.createCell(3).setCellValue("Date");
		
		for (CurrencyRate currencyRate : currencyRates) {
			Row currencyRow = sheet.createRow(rowCount++);
			currencyRow.createCell(0).setCellValue(currencyRate.getCurrencyPair());
			currencyRow.createCell(1).setCellValue(currencyRate.getBidPrice().doubleValue());
			currencyRow.createCell(2).setCellValue(currencyRate.getAskPrice().doubleValue());
			currencyRow.createCell(3).setCellValue(
				currencyRate.getDateTime().format(
					DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		}
		response.setHeader("Content-Disposition", "attachment; filename=forex-rates.xls");
	}
}
