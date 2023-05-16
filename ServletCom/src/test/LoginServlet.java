package test;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.230:1521:orcl", "training", "training");
			PreparedStatement ps = con.prepareStatement("select * from Login where uname = ? and pword = ?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pw.println("Login Successful");
				RequestDispatcher rd = request.getRequestDispatcher("display");
				rd.forward(request, response);
			} else {
				pw.println("InValid UserLogin");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}