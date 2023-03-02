package govt.scheme.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AdminVerfication")
public class AdminVerfication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/govtschemedb")
	private DataSource datasource;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String get_pass = null;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-login.jsp");
		
		try {
			Connection con = datasource.getConnection();
			Statement stat = con.createStatement();
			
			String sql = "select Admin_PASSWARD from adminlogin where Admin_USERNAME='" + username + "'";
			
			ResultSet res = stat.executeQuery(sql);
			
			while(res.next()) {
				get_pass = res.getString(1);				
			}
			
			try {con.close();}catch(Exception ex) {}
			try {stat.close();}catch(Exception ex) {}
			try {res.close();}catch(Exception ex) {}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		if(get_pass != null) {
			if(get_pass.equals(password)) {
				dispatcher = request.getRequestDispatcher("/admin-pannel.jsp");
			} else {
				request.setAttribute("msg", "User not found");
			}
		} else {
			request.setAttribute("msg", "User not found");
		}
		
		dispatcher.forward(request, response);
	}

}
