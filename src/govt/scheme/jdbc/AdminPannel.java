package govt.scheme.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AdminPannel")
public class AdminPannel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/govtschemedb")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hidden = request.getParameter("hidden");
		
		if(hidden.equals("add")) {
			
			int id = 1000;
			
			String name = request.getParameter("sname");
			String benifit = request.getParameter("sbenifit");
			String details = request.getParameter("sdetails");
			String apply = request.getParameter("sapply");
			
			Date date = new Date();
			String date_pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(date_pattern);
			String mysqldatestring = format.format(date);
			
			try {
				Connection con = datasource.getConnection();
				Statement stat = con.createStatement();
				String sql = "select max(scheme_id) from schemes";
				ResultSet res = stat.executeQuery(sql);
			
				while(res.next()) {
					if(res.getInt(1) == 0)
						id = id + 1;
					else
						id = res.getInt(1) + 1;
				}
				try { con.close(); }catch(Exception ex) {}
				try { stat.close(); }catch(Exception ex) {}
				try { res.close(); }catch(Exception ex) {}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			request.setAttribute("msg", "Scheme Not Added");
			
			try {
				Connection con = datasource.getConnection();
				String sql = "insert into schemes values (?, ?, ?, ?, ?, ?)";
				PreparedStatement stat = con.prepareStatement(sql);
				
				stat.setInt(1, id);
				stat.setString(2, name);
				stat.setString(3, benifit);
				stat.setString(4, details);
				stat.setString(5, apply);
				stat.setString(6, mysqldatestring);
				
				stat.execute();
				request.setAttribute("msg", "Scheme Added");
		
				try { con.close(); }catch(Exception ex) {}
				try { stat.close(); }catch(Exception ex) {}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/scheme-add.jsp");
			dispatcher.forward(request, response);
		}
		
		if(hidden.equals("updatesearch")) {
			String id = request.getParameter("id");
			
			List<String> lst = new ArrayList<String>();
			
			try {
				Connection con = datasource.getConnection();
				String sql = "select * from schemes where Scheme_ID=?";
				PreparedStatement stat = con.prepareStatement(sql);
				stat.setString(1, id);
			
				ResultSet res = stat.executeQuery();
				
				while(res.next()) {
						lst.add(res.getString(1));
						lst.add(res.getString(2));
						lst.add(res.getString(3));
						lst.add(res.getString(4));
						lst.add(res.getString(5));
						lst.add(res.getString(6));
					}

				try { con.close(); } catch(Exception ex) {}
				try { stat.close(); } catch(Exception ex) {}
				try { res.close(); } catch(Exception ex) {}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			if(lst.isEmpty()) {
				request.setAttribute("msg", "Invalid Id");
			} else {
				request.setAttribute("lst", lst);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/scheme-update.jsp");
			dispatcher.forward(request, response);
		}
		
		if(hidden.equals("update")) {
			
			String id = request.getParameter("id");
			String name = request.getParameter("sname");
			String benifits = request.getParameter("sbenifit");
			String details = request.getParameter("sdetails");
			String apply = request.getParameter("sapply");
			
			try {
				Connection con = datasource.getConnection();
				String sql = "update schemes set Scheme_NAME=?, Scheme_BENIFITS=?, Scheme_DETAILS=?, Scheme_APPLY=? where Scheme_ID=?";
				PreparedStatement stat = con.prepareStatement(sql);
			
				stat.setString(1, name);
				stat.setString(2, benifits);
				stat.setString(3, details);
				stat.setString(4, apply);
				stat.setString(5, id);
				
				int rows = stat.executeUpdate();
				
				if(rows == 1)
					request.setAttribute("msg1", "Update Complete");
				else
					request.setAttribute("msg1", "Update not Complete");
				
				try { con.close(); }catch(Exception ex) {}
				try { stat.close(); }catch(Exception ex) {}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/scheme-update.jsp");
			dispatcher.forward(request, response);
		}
		
		if(hidden.equals("delete")) {
			
			String id = request.getParameter("id");
			request.setAttribute("msg", "Scheme not found");
			
			try {
				Connection con = datasource.getConnection();
				String sql = "delete from schemes where Scheme_ID=?";
				PreparedStatement stat = con.prepareStatement(sql);
			
				stat.setString(1, id);
				
				int row = stat.executeUpdate();
				
				if(row == 1)
					request.setAttribute("msg", "Scheme Deleted");
				
				try { con.close(); }catch(Exception ex) {}
				try { stat.close(); }catch(Exception ex) {}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/scheme-delete.jsp");
			dispatcher.forward(request, response);
		}
	}

}
