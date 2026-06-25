package com.placement.controller;

import java.io.IOException;

import java.util.ArrayList;
import com.placement.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/profile")
public class ProfileFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		String name=req.getParameter("UserName");
		int semester= Integer.parseInt(req.getParameter("sem"));
		String college=req.getParameter("college");
		String leetcode=req.getParameter("leetcode");
		String github=req.getParameter("github");
		ArrayList<Double> gpalist=new ArrayList<>();
		double total=0.0;
		String gpaStr=null;
		for(int i = 1; i <= semester - 1; i++) {
		     gpaStr = req.getParameter("Sem" + i);

		    try {
		        if(gpaStr != null && !gpaStr.trim().isEmpty()){
		            double gpa = Double.parseDouble(gpaStr);
		            gpalist.add(gpa);
		            total += gpa;
		        }
		    } catch(NumberFormatException e){
		        System.out.println("Invalid GPA at Sem " + i);
		    }
		}
		DatabaseConnection.profiledetailsConnection(name,semester,college,leetcode,github,gpalist);

		double cgpa = 0.0;
		if(semester > 1){
		    cgpa = total / (semester - 1);
		}
		
		//jdbcConnection(name,semester,college,leetcode,github,gpalist);
		
        resp.sendRedirect(req.getContextPath()+"/Signin.html");

		
		
		
		
		
	
		
		
	}


}
