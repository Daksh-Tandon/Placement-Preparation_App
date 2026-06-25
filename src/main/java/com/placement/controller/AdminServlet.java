package com.placement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import com.placement.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		String txt=req.getParameter("text");
		LocalDate today = LocalDate.now();
		String date = today.toString();
		DatabaseConnection.admindatabase(txt,date);
		PrintWriter out=res.getWriter();
		out.println("Message Notified");
		
		
		
	}

}
