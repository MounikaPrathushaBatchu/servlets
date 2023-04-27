package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TempServ")
public class TempServ extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<body> <h1>Today is" + new Date());
		pw.println("</h1><h2>Temperature Converter</h2>");
		pw.println("<table border = '1'><tr>");
		pw.println("<th>Fahrenheit</th><th>Celsius</th></tr>");
		double fah,cel;
		for(int i=10;i<=100;i=i+10) {
			fah = i;
			cel = (fah-32)*5.0/9.0;
			pw.println("<tr><td>" + fah + "</td><td>" + cel + "</td></tr>");
		}
		pw.println("</table></body>");
		pw.close();
	}

}
