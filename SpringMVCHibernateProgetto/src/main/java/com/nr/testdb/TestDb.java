package com.nr.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setup conn variables
		String user = "root";
		String pass = "root";
		String jdbcUrl ="jdbc:mysql://localhost:3306/dbfifa?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		// get conn to db
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to db: "+jdbcUrl);
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Success");
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
