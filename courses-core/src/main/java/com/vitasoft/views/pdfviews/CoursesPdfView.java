package com.vitasoft.views.pdfviews;

import com.lowagie.text.Document;
import com.lowagie.text.Header;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

public class CoursesPdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
									Document document,
									PdfWriter writer,
									HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		
		Map<String, String> revenueData = (Map<String, String>) model.get("revenueData");
		
		Table table = new Table(2);
		table.addCell("Month");
		table.addCell("Revenue");
		
		Header header = new Header("Header", "Header");
		
		document.add(header);
		document.add(table);
	}
}
