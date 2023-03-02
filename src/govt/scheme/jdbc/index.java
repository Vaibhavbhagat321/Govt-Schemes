package govt.scheme.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/govtschemedb")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		
		try { 

			Connection con = datasource.getConnection();
			Statement stat = con.createStatement();
			
			String sql = "select * from schemes";
			
			ResultSet res = stat.executeQuery(sql);
			
			while(res.next()) {
			
				List<String> record = new ArrayList<String>();
				
				record.add(res.getString(1));
				record.add(res.getString(2));
				record.add(res.getString(3));
				record.add(res.getString(4));
				record.add(res.getString(5));
				record.add(res.getString(6));
				
				records.add((ArrayList<String>) record);
			}	
			try {con.close();}catch(Exception ex){}
			try {stat.close();}catch(Exception ex){}
			try {res.close();}catch(Exception ex){}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		

	Collections.reverse(records);
	
	request.setAttribute("schemes", records);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
}
}
