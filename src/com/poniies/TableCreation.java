package com.poniies;
import java.io.*;


public class TableCreation {
	String table;


	public TableCreation() {
		super();
	}


	public String createTable() throws IOException{
		
		String fName = "C:\\Users\\m_aa\\eclipse-workspace\\myLittleDiary.com\\out.csv";
		String thisLine; 
		int count=0; 
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i=0;
		table="";
		
		while ((thisLine = myInput.readLine()) != null)
		{
		String strar[] = thisLine.split(",");
		for(int j=0;j<strar.length;j++)
		{

		if(i!=0)
		{
			table = table.concat("<td>" +strar[j]+ "</td>");	
		}
		else
		{
			table = table.concat("<td><b>" +strar[j]+ "</b></td>");
		}
		}
			table = table.concat("<tr>");
			table = table.concat("</tr>");
			i++;
		}
		return table;
	}


	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}
}