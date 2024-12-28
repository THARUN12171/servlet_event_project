package eventapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/all")

public class FetchAllEvents extends HttpServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root", "root");
			PreparedStatement ps=cc.prepareStatement("select * from event");
			
			ResultSet rs = ps.executeQuery();
			req.setAttribute("rs", rs);
			
			RequestDispatcher rd=req.getRequestDispatcher("allevents.jsp");			
			rd.forward(req, res);
			
	    	rs.close();
			ps.close();
			cc.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
}
