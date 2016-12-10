package it.peruvianit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
 
/**
 * This class builds an Excel spreadsheet document using JExcelApi library.
 * @author www.codejava.net
 *
 */
public class XlsView extends AbstractXlsView  {
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
							          Workbook workbook,
							          HttpServletRequest request,
							          HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<String> listString = (List<String>)model.get("listString");
		
		//create a wordsheet
		Sheet sheet = workbook.createSheet("Test File Excel");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Lista Valori Test");

		int rowNum = 1;
		for (String element : listString) {
			//create the row data
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(element);
		}
	}
}
