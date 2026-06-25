package com.placement.controller;

import java.io.IOException;
import com.placement.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		DatabaseConnection.registerConnection(name,email,password);
		System.out.println("Context Path = " + req.getContextPath());
		System.out.println("Redirecting...");
		res.sendRedirect(req.getContextPath() + "/ProfileForm.html");
		
		
		
	}
}
