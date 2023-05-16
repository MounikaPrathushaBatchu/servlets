package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/pqr")		//annotation
public class ServlrtProgram1 extends HttpServlet {
	public void init() {}
	public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("Welcome to servlet");
	}
	public void destroy() {}
}
