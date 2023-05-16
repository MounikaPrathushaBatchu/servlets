package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		pw.println("Welcome" + uname);
	}
}