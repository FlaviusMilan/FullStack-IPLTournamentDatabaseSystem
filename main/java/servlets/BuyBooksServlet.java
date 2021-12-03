package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;
import sql.IUserContants;
@SuppressWarnings("serial")
public class BuyBooksServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		try {
			Connection con = DBConnection.getCon();
			//ArrayList<Books> al = new ArrayList<Books>();
			PreparedStatement ps = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK1);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
			rd.include(req, res);
			pw.println("<div class=\"tab hd brown \">Teams that are Playing</div>");
			pw.println("<div class=\"tab\"><form action=\"buys\" method=\"post\">");
			pw.println("<table>\r\n" + 
					"			<tr>\r\n" + 
					"				<th>Teams</th>\r\n" +"		</tr>");
			int i=0;
			while(rs.next())
			{
				String tname = rs.getString(1);
				
				i=i+1;
				String n = "checked"+ Integer.toString(i);
				
				
				pw.println("<tr>\r\n" + "<td>\r\n"+tname+"</td>");
				
				
				
			}
			pw.println("</table>\r\n" + "<input type=\"submit\" value=\" See Stats\">"+"<br/>"+
					"	</form>\r\n" + 
					"	</div>");
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}