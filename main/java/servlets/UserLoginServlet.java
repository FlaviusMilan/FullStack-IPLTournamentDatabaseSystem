package servlets;

import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IUserContants;

import java.io.*;
import java.sql.*;

@SuppressWarnings("serial")
public class UserLoginServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		String uName = req.getParameter(IUserContants.COLUMN_USERNAME);
		String pWord = req.getParameter(IUserContants.COLUMN_PASSWORD);
		System.out.println("trying to connect");
		try {
			Connection con = DBConnection.getCon();
			System.out.println("connected");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + IUserContants.TABLE_USERS + " WHERE "
					+ IUserContants.COLUMN_USERNAME + "=? AND " + IUserContants.COLUMN_PASSWORD + "=? AND " + IUserContants.COLUMN_USERTYPE + "=2");
			System.out.println("queried");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				pw.println("<div class=\"home hd white\">Welcome ! " + uName + "</div><br/>");
				pw.println("<div class=\"tab hd white\">User Login Successful !</div><br/>");
				pw.println("<div class=\"tab\"><a href=\"viewbook\">Stats</a></div>");
				pw.println("<div class='tab'><a href=\"buybook\">IPL Teams</a></div>");
				
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				//pw.println("<div class=\"tab\">Incorrect UserName or PassWord</div>");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}