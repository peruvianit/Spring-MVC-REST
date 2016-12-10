package it.peruvianit.view;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.web.servlet.view.AbstractView;

public class CsvView extends AbstractView{
	//Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final Character CHAR_DELIMITATOR = '|';

	private String fileName = "prova.csv";
	
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    protected void prepareResponse(HttpServletRequest request,
            					   HttpServletResponse response){
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",fileName);
        response.setContentType("text/csv");
        response.setHeader(headerKey, headerValue);
    }
 
    /*
     * Da implementare con un Utility per la creazione di file CSV
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            							  HttpServletRequest request, 
            							  HttpServletResponse response) throws Exception {
    	
    	final ByteArrayOutputStream outB = new ByteArrayOutputStream();
    	try(Writer out = new BufferedWriter(new OutputStreamWriter(outB));) { 
	    	CSVPrinter csvPrinter = null;
	    	CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR).withDelimiter(CHAR_DELIMITATOR);
	    	
	    	csvPrinter = new CSVPrinter(out,csvFormat);
	    	
	    	Iterable<?> csvHeaderIterable = (Iterable<?>)model.get("csvHeaderIterable");
	    	@SuppressWarnings("unchecked")
			Iterable<Iterable<?>> inputIterable = (Iterable<Iterable<?>>)model.get("inputIterable");

	    	csvPrinter.printRecord(csvHeaderIterable);
	    	for (Iterable<?> row : inputIterable) {
	    		csvPrinter.printRecord(row);
			}
	    	
	    	csvPrinter.flush();
	    	csvPrinter.close();
    	} catch (Exception e) { 
             outB.close(); 
             throw e; 
        } 
    	
    	ServletOutputStream out = response.getOutputStream();
		out.write(outB.toByteArray());
    	out.flush();
		out.close();
    }
}
