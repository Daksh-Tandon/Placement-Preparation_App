package com.placement.model;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class DatabaseConnection {
	public static  void admindatabase(String txt,String date) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement","root","daksh");
             String q="Insert into admin_notify(message,date) values(?,?)";
	         PreparedStatement ps=con.prepareStatement(q);
	         ps.setString(1, txt);
	         ps.setString(2, date);
	         int i=ps.executeUpdate();
	         if(i>0) System.out.print("success");
	         
		}
		catch(Exception e) {
			System.out.print("Exception occured");
			
		}
		
	}
	public static void registerConnection(String n,String e,String p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement","root","daksh");
			String query="Insert into Register(name,email,password) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, n);
			ps.setString(2, e);
			ps.setString(3,p);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.print("Success");
				
			}
			else {
				System.out.println("Fail");
			}
			con.close();
			
		}
		catch(Exception eV) {
			eV.printStackTrace();
		}
		
		
	}
	 public static int signinconnection(String n,String p) {
		 System.out.println("Name = " + n);
         System.out.println("Password = " + p);
	        if(n == null || n.isEmpty() || p == null || p.isEmpty()) return -1;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/placement","root","daksh");
	            

	            String query = "Select id from register where name=? and password=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, n);
	            ps.setString(2, p);

	            ResultSet res = ps.executeQuery();

	            if(res.next()) {
	                return res.getInt("id");
	            }
	            

	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        return -1;
	    }
	 public static  void taskconnection(int userid,int tid) {
			try {
//				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement","root","daksh");
				String query="Update usertask set score=score+10 where userid=? and tid=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, userid);
				ps.setInt(2, tid);
				int i=ps.executeUpdate();
				if(i>0) System.out.print("Success");
				//else res.getWriter().println("kya");
				//res.getWriter().println("score is updated");
				
			}
			catch(Exception e) {
				e.printStackTrace();
				//res.getWriter().println("error" + e.toString());
				
			}
			
			
		}
	 public static void profiledetailsConnection(String n, int s, String c, String l, String g, ArrayList<Double> cg) {
		    try {
		        System.out.println("DB connection");

		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/placement", "root", "daksh");

		        // Insert profile
		        String query = "INSERT INTO profiledetails(username,sem,college,leetcodeprofile,githubprofile) VALUES(?,?,?,?,?)";
		        PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

		        ps.setString(1, n);
		        ps.setInt(2, s);
		        ps.setString(3, c);
		        ps.setString(4, l);
		        ps.setString(5, g);

		        int i = ps.executeUpdate();

		        int userid = 0;

		        if (i > 0) {
		            ResultSet rs = ps.getGeneratedKeys();
		            if (rs.next()) {
		                userid = rs.getInt(1);
		            }

		        
		            String q = "INSERT INTO cgpa(sno, sem, gpa) VALUES(?,?,?)";
		            PreparedStatement ps1 = con.prepareStatement(q);
		            if(cg.size() == 0){
		                
		                ps1.setInt(1, userid);
		                ps1.setInt(2, 1);
		                ps1.setDouble(3, 0.0); 
		                ps1.executeUpdate();
		            } else {
		                for (int z = 1; z <= cg.size(); z++) {
		                    ps1.setInt(1, userid);
		                    ps1.setInt(2, z);
		                    ps1.setDouble(3, cg.get(z-1));
		                    ps1.executeUpdate();
		                }
		            }
		            System.out.println("Success");
		          
		            
		        } else {
		            System.out.println("Failure");
		        }
		        

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}


}

