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

@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/govtschemedb")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> category_list = new ArrayList<String>();

		try {
			Connection con = datasource.getConnection();
			Statement stat = con.createStatement();
			
			String sql = "select distinct Scheme_BENIFITS from schemes";
			
			ResultSet res = stat.executeQuery(sql);
			
			while(res.next()) {
				category_list.add(res.getString("Scheme_BENIFITS"));
			}
		
			try {con.close();}catch(Exception ex){}
			try {stat.close();}catch(Exception ex){}
			try {res.close();}catch(Exception ex){}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		//Form Submit code
		String category = request.getParameter("category");
		
		List<ArrayList<String>> Scheme_lst = new ArrayList<ArrayList<String>>();
		
		if(category != null) {
			
			String sql = null;
			try {		
				Connection con = datasource.getConnection();
				Statement stat = con.createStatement();
				
				sql = " select * from Schemes where Scheme_BENIFITS='"+category+"'";

				ResultSet res = stat.executeQuery(sql);
				
				while(res.next()) {
					
					List<String> temp_lst = new ArrayList<String>();
					
					temp_lst.add(res.getString(1));
					temp_lst.add(res.getString(2));
					temp_lst.add(res.getString(3));
					temp_lst.add(res.getString(4));
					temp_lst.add(res.getString(5));
					temp_lst.add(res.getString(6));
					
					Scheme_lst.add((ArrayList<String>) temp_lst);
				}
				try {con.close();}catch(Exception ex) {}
				try {stat.close();}catch(Exception ex) {}
				try {res.close();}catch(Exception ex) {}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		Collections.reverse(Scheme_lst);
		
		request.setAttribute("Scheme_lst", Scheme_lst);
		request.setAttribute("category_list", category_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);
		
	}

}
