package com.zycus.sonali;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayBillServlet
 */
@WebServlet("/pay-bills.do")
public class PayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("bill-pay.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Pay bnill.dopost");
		String billType = null;
		billType = request.getParameter("billType");
		String eleprovider = null;
		eleprovider = request.getParameter("eleprovider");
		String phoneprovider = null;
		phoneprovider = request.getParameter("phoneprovider");
		float amount = (request.getParameter("amount").equals("") || request.getParameter("amount") == null)?0:Float.parseFloat(request.getParameter("amount"));
		//float amount = Float.parseFloat(request.getParameter("amount"));
		if(billType.equals("") || billType == null || (eleprovider.equals("") && phoneprovider.equals("")) || amount == 0  || (eleprovider == null && phoneprovider == null)) {
			response.sendRedirect("bill-pay.html");
			return ;
		}
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Payment is processed successfuly</h2>");
		
	}

}

