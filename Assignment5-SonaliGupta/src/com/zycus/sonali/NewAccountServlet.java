package com.zycus.sonali;


import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/new-account.do")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String title = request.getParameter("title");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
		
		if(title == null || firstname == null || lastname == null || age == 0 || dob == null || title.equals("") || firstname.equals("") || lastname.equals("")) {
			response.sendRedirect("new-account.html");
			System.out.println("if block 12");

		}
		
		if(firstname.length() < 2 || lastname.length() < 2 || !(title.trim().equalsIgnoreCase("Mr") || title.trim().equalsIgnoreCase("Mrs") || title.trim().equalsIgnoreCase("Ms") || title.trim().equalsIgnoreCase("Dr"))) {
			
				response.sendRedirect("new-account.html");
				System.out.println("if block 22");
		}
		PrintWriter out = response.getWriter();
		out.println("<h2>Hi "+title+" "+firstname+ ", your acccount creation request is under processing.</h2>");
		CustomerDAO customerdao = new CustomerDAO();
		customerdao.create(new Customer(title, firstname, lastname, age, dob));
		//System.out.println("if block 2");
		
		out.flush();
		//System.out.println("if block 3");
		out.close();
				
	}

}
