package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Message
 */
@WebServlet({ "/Message", "/welcome" })
public class Message extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("t1");
		String pwd = request.getParameter("t2");
		response.setContentType("text/html");
		java.io.PrintWriter our = response.getWriter();
		StringBuilder sb = new StringBuilder(" ");
		sb.append("<html><head><title>");
		sb.append("Welcome</title></head>");
		sb.append("<body><h1>Hello " + fname);
		sb.append(" Welcome");
		sb.append("</h1></body></html>");
		our.println(sb.toString());
		our.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
