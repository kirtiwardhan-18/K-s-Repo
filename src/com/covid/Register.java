package com.covid;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");
				String current_location = request.getParameter("current_location");
				String aadhar_no = request.getParameter("aadhar_no");
				String address = request.getParameter("address");
				String contact = request.getParameter("contact");
				String Family_Members = request.getParameter("Family_Members");
				String Family_Member_Stranded= request.getParameter("Family_Member_Stranded");
				String Are_You_Getting_3_Meals_Daily = request.getParameter("Are_You_Getting_3_Meals_Daily?");
				
				
				
				String sql = " insert into stranded (First_Name, Last_Name, Current_Location,Aadhar_No,Address,Contact_No,Family_Members,Family_Members_Stranded,3Meals)values(First_Name=?, Last_Name=?, Current_Location=?,Aadhar_No=?,Address=?,Contact_No=?,Family_Members=?,Family_Members_Stranded=?,3Meals=?);";
				String url = "jdbc:mysql://localhost:3306/covid19";
				String username = "root";
				String password = "root";
			  
				
					try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url,username,password);
					PreparedStatement st = ((java.sql.Connection) con).prepareStatement(sql);
					st.setString(1, first_name);
					st.setString(2,last_name);
					st.setString(3,current_location);
					st.setString(4,aadhar_no);
					st.setString(5,address);
					st.setString(6,contact);
					st.setString(7,Family_Members);
					st.setString(8,Family_Member_Stranded);
					st.setString(9,Are_You_Getting_3_Meals_Daily);
					
					st.executeUpdate();
				
					
				}
					catch(Exception e) {
				}
					response.sendRedirect("Success.jsp");
			}

			}
		 
			
	