package com.poniies;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logic")
public class Logic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TableCreation String = null;

    public Logic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = ("/homepage.jsp");
		
		if ("Add".equals(request.getParameter("pressed"))){
			url = "/add.jsp";
		}
		
		if ((request.getParameter("fname") != null)) {
			String new_fname = request.getParameter("fname");
			String new_lname = request.getParameter("lname");
			String new_phone = request.getParameter("number");
			String new_sex = request.getParameter("sex");
			System.out.println(new_sex);
			
			if (new_sex.equals("other")) {
				new_sex=request.getParameter("other");
			}
			
			File dB = new File ("C:\\Users\\m_aa\\eclipse-workspace\\myLittleDiary.com\\out.csv");
			FileWriter writer = new FileWriter (dB, true);
			BufferedWriter buffer = new BufferedWriter (writer);
			PrintWriter printer = new PrintWriter (buffer);
			
			String fName = "C:\\Users\\m_aa\\eclipse-workspace\\myLittleDiary.com\\out.csv";
			String thisLine; 
			int count=0; 
			FileInputStream fis = new FileInputStream(fName);
			DataInputStream myInput = new DataInputStream(fis);
			int exists = 0;
			
			String add_line = new_fname+","+new_lname+","+new_phone+","+new_sex;
			
			while ((thisLine = myInput.readLine()) != null)
			{
				if (add_line.equals(thisLine)) {
					exists=1;
				}
			}
			if (exists==0) {
				printer.println(add_line);
				printer.close();
				request.setAttribute("fname", request.getParameter("fname"));
			}	
		}
		
		TableCreation table = new TableCreation();
		String x=table.createTable();
		request.setAttribute("table", x);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
