package com.poniies;
import java.io.*;

import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;




public class TableCreation {
	
	private List<BeanEntry> table = new ArrayList<BeanEntry>();
	private String[] HEADERS = {"Name","Surname","Number","Sex"};
	

	public TableCreation(String file) throws IOException {
		readCsv(file);
	}

	
	private void readCsv(String file) throws IOException {
		
		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT
			.withHeader(HEADERS)
			.withFirstRecordAsHeader()
			.parse(in);
		for(CSVRecord record: records) {
			String name = record.get("Name");
			String surname = record.get("Surname");
			String number = record.get("Number");
			String sex = record.get("Sex");
			
			BeanEntry line = new BeanEntry(name, surname, number, sex);
			this.table.add(line);
		}
	}
	
	public void addToTable (BeanEntry new_line) {
		this.table.add(new_line);
	}
	
	public void updateCsv (String file) throws IOException {
		FileWriter out = new FileWriter(file);
		   try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
		     .withHeader(HEADERS))) {
		       for(BeanEntry l: this.table) {
		           printer.printRecord(l.getName(), l.getSurname(), l.getNumber(), l.getSex());
		       }
		   }
		
	}
	public List<BeanEntry> getTable(){
		return this.table;
	}	
}
