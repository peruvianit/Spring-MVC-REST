package it.peruvianit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
 
/**
 * This class builds an Excel spreadsheet document using JExcelApi library.
 * @author www.codejava.net
 *
 */
public class ExcelView extends AbstractExcelView  {
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
									  HSSFWorkbook workbook, 
									  HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<String> listString = (List<String>)model.get("listString");
		
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Test file Excel");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Lista Valori Test");

		int rowNum = 1;
		for (String element : listString) {
			//create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(element);
		}
	}
}
