package it.peruvianit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
 
/**
 * This class builds an Excel spreadsheet document using JExcelApi library.
 * @author www.codejava.net
 *
 */
public class PdfView extends AbstractPdfView  {
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
									Document document,
									PdfWriter pdfWriter,
							        HttpServletRequest request,
							        HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<String> listString = (List<String>)model.get("listString");
		
		Table table = new Table(1);
		table.addCell("Lista elementi");
		for (String element : listString) {
			//create the row data
			table.addCell(element);
		}
		
		document.add(table);
	}
}
