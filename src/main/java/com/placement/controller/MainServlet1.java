package com.placement.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/main")
public class MainServlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

   
        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("userId") == null){
            resp.sendRedirect("SignIn.html");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/placement","root","daksh");

            
            String query = "SELECT * FROM register r JOIN profiledetails p ON r.id = p.sno WHERE r.id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            String name = "", email = "", college = "" ,link="",glink="";
            int sem = 0;

            if(rs.next()){
                name = rs.getString("name");
                email = rs.getString("email");
                college = rs.getString("college");
                sem = rs.getInt("sem");
                link=rs.getString("leetcodeprofile");
                glink=rs.getString("githubprofile");
            }
             String query2="SELECT username, SUM(score) FROM usertask u JOIN profiledetails p ON u.userid = p.sno GROUP BY username ORDER BY sum(score) desc" ;
             PreparedStatement ps5=con.prepareStatement(query2);
             ResultSet rs1=ps5.executeQuery();
             String u="";int s=0;
             List<String> names=new ArrayList<>();
             List<Integer> n=new ArrayList<>();
             while(rs1.next()) {
            	   u=rs1.getString("username");
            	   s=rs1.getInt("Sum(score)");
            	   names.add(u);
            	   n.add(s);
               
            	  
            	   
            	 
             }
             
             
            		 

          
            String q="Insert ignore  into usertask(userid,tid) values(?,?)";
            PreparedStatement ps3=con.prepareStatement(q);
            for(int i=1;i<=3;i++) {
            	ps3.setInt(1, userId);
            	ps3.setInt(2, i);
            int j=	ps3.executeUpdate();
            	
            	   
            }
            
            String cgQuery = "SELECT gpa FROM cgpa WHERE sno=?";
            PreparedStatement ps2 = con.prepareStatement(cgQuery);
            ps2.setInt(1, userId);

            ResultSet rs2 = ps2.executeQuery();

            double total = 0;
            int count = 0;

            while(rs2.next()){
                total += rs2.getDouble("gpa");
                count++;
            }

            double cgpa = (count == 0) ? 0 : total / (count);
          
  
            String suggestion;
            if(cgpa < 7){
                suggestion = "Focus on academics 📚";
            } else if(cgpa < 8.5){
                suggestion = "Start solving more DSA 💻";
            } else {
                suggestion = "You are on track 🚀";
            }
            String q5="Select message from admin_notify order by date asc ";
            PreparedStatement ps7=con.prepareStatement(q5);
            ResultSet res=ps7.executeQuery();
            String msg="";
            while(res.next()) {
            	   msg=res.getString("message");
            }

       
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("college", college);
            req.setAttribute("sem", sem);
            req.setAttribute("cgpa", cgpa);
            req.setAttribute("suggestion", suggestion);
            req.setAttribute("glink", glink);
            req.setAttribute("link", link);
            req.setAttribute("list",names);
            req.setAttribute("scores", n);
            req.setAttribute("msg", msg);
            System.out.println("Name = " + name);
            System.out.println("Email = " + email);
            System.out.println("College = " + college);
            System.out.println("CGPA = " + cgpa);
            


            RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
            rd.forward(req, resp);

            con.close();

        } catch(Exception e){
            e.printStackTrace();
            resp.getWriter().println("ERROR: " + e.getMessage());
        }
    }


}
