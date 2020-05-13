package com.commons;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user="hbstudent";
		String password="hbstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String driver="com.mysql.cj.jdbc.Driver";
		//get connection to db
		try {
			PrintWriter printWriter=response.getWriter();
			Class.forName(driver);//load driver
			Connection connection=DriverManager.getConnection(jdbcUrl,user,password);
			printWriter.print("Success");
			System.out.println("Connection to db is successfull");
			connection.close();
			
		}catch(Exception exception) {
			System.out.println("Connection to db is unsuccessfull");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
