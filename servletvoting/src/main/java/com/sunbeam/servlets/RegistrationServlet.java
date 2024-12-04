package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//get user details from register page
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String dobString =req.getParameter("dob");
		Date birth = Date.valueOf(dobString);
		int status = 0;
		String role = "voter";
		
		User u = new User(0,firstName,lastName,email,password,birth,status,role);
		try(UserDao userDao = new UserDaoImpl()){
			int cnt = userDao.save(u);
			if(cnt == 1)
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Register User</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>User Registration Successful</h2>");
				out.println("<p>Go to Login Page </p>");
				out.println("<p><a href='index.html'>Login</a></p>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
			
//			else 
//			{
//				resp.setContentType("text/html");
//				PrintWriter out = resp.getWriter();
//				out.println("<html>");
//				out.println("<head>");
//				out.println("<title>Register</title>");
//				out.println("</head>");
//				out.println("<body>");
//				out.println("<h2>Registration Failed</h2>");
//				out.println("<p>Sorry, Fill all Details </p>");
//				out.println("<p><a href='newuser.html'>Register Again</a></p>");
//				out.println("</body>");
//				out.println("</html>");
//			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
	}

}
