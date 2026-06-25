package com.placement.controller;
import com.placement.model.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TaskServlet1 {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		try {
			HttpSession session = req.getSession(false);
			int userid=(int) session.getAttribute("userId");
			int tid = Integer.parseInt(req.getParameter("tid"));
			DatabaseConnection.taskconnection(userid, tid);
			res.getWriter().println("score is updated");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			res.getWriter().println("error" + e.toString());
			
		}
		
		
	}

}
