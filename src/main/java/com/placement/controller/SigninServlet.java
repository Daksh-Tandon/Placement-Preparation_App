package com.placement.controller;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.placement.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.placement.model.*;
@WebServlet("/signin")
public class SigninServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest req,HttpServletResponse resp)
	            throws ServletException, IOException {

	        String name = req.getParameter("name");
	        String password = req.getParameter("password");
	        if(name.equals("admin") && password.equals("admin123")) {
	        	   resp.sendRedirect("main.html");
	        	   return;
	        }
	    

	        int userId = DatabaseConnection.signinconnection(name, password);

	        if(userId != -1) {
	        	    System.out.print("Enter in this area");

	            HttpSession session = req.getSession();
	            session.setAttribute("userId", userId); 
                System.out.print(userId);
                resp.sendRedirect(req.getContextPath() + "/main");
	            return;

	        } else {
	        	   
	            resp.setContentType("text/html");
	            PrintWriter out = resp.getWriter();
	            out.println("<h3>Invalid Credentials</h3>");
	            out.println("<a href='SignIn.html'>Try Again</a>");
	            return;
	        }
	    }

}
