package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = "/updatepage")
public class UpdateEvent extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		Connection cc = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cc = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system", "root", "root");
			ps = cc.prepareStatement("select * from event where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				req.setAttribute("rs", rs);
				RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
				rd.forward(req, res);
			}
			rs.close();
			ps.close();
			cc.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cc != null) {
				try {
					cc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
