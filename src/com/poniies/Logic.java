package com.poniies;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/Logic")
public class Logic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ContactDAO String = null;
	private String FNAME = "C:\\Users\\m_aa\\eclipse-workspace\\myLittleDiary.com\\out.csv";
	private ContactDAO table;
	
    public Logic() throws IOException{

    	this.table = new ContactDAO(FNAME);
    }

	public synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = ("/homepage.jsp");
		
		if (StringUtils.equals("Add", request.getParameter("pressed"))){
			url = "/add.jsp";
		}
		
		if (StringUtils.equals("Delete", request.getParameter("pressed"))){
			this.table.removeEntry(request);
			this.table.updateCsv(FNAME);		
		}
		
		if (!StringUtils.isEmpty((request.getParameter("fname")))) {
			
			BeanEntry new_line = new BeanEntry(request);
			this.table.addToTable(new_line);
			this.table.updateCsv(FNAME);
		}	
		
		request.setAttribute("table", table);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
