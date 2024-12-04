package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/registerCandidate")
public class CandidateRegisterServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String candidateName = req.getParameter("candidateName");
		String party = req.getParameter("party");
		int votes = 0;
		
		Candidate c = new Candidate(0, candidateName, party, votes);
		try(CandidateDao canDao = new CandidateDaoImpl()){
			int cnt = canDao.save(c);
			
			if(cnt==1)
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Register Candidate</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Candidate Registration Successful</h2>");
				
				out.println("</body>");
				out.println("</html>");
				
				
				resp.sendRedirect("result");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	
	
}
