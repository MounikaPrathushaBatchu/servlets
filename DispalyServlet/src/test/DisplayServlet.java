package test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		pw.println("name : " + name);
	}
}
