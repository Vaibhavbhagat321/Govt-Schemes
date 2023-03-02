package govt.scheme.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ViewScheme")
public class ViewScheme extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/govtschemedb")
	private DataSource datasource; 
	
	Connection con;
	Statement stat;
	ResultSet res;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		List<String> record = new ArrayList<String>();
		try {
			con = datasource.getConnection();
			String sql = "select * from schemes where Scheme_ID="+id;
			stat = con.createStatement();
			
			res = stat.executeQuery(sql);
			
			while(res.next()) {
			
				record.add(res.getString(1));
				record.add(res.getString(2));
				record.add(res.getString(3));
				record.add(res.getString(4));
				record.add(res.getString(5));
				record.add(res.getString(6));
			}
			
			try {con.close();}catch(Exception ex){}
			try {stat.close();}catch(Exception ex){}
			try {res.close();}catch(Exception ex){}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	request.setAttribute("lst", record);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/view-scheme.jsp");
	dispatcher.forward(request, response);
		
}

}