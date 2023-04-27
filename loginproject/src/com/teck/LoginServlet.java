package com.teck;

import java.io.*;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.*; 
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.servlet.*;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl", "training", "training");
		} catch (Exception e){
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("txtuid");
		String pwd = request.getParameter("txtpswd");
		String str = "select userid from users where userid = ? and pwd = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, userid);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("shopping.html");
				rd.forward(request, response);
			} else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.println("<p style = 'color:red'>UserId or Password is wrong </p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
	
	public void destroy() {
		try {
			con.close();
		} catch(SQLException se) {
			System.out.println(se);
		}
	}
}
