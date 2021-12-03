package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import sql.IBookConstants;

@SuppressWarnings("serial")
public class PlayeroftheSeries extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK3);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
			rd.include(req, res);
			pw.println("<div class=\"tab hd brown \">Player Of the Series</div>");
			pw.println("<div class=\"tab\"><form action=\"buys\" method=\"post\">");
			pw.println("<table>\r\n" + 
					"			<tr>\r\n" + 
					"				<th>Teams</th>\r\n" +"		</tr>");
			//RequestDispatcher rd = req.getRequestDispatcher("ViewBooks.html");
			//rd.include(req, res);
			
			
			//pw.println("<div class=\"tab\">\r\n" + 
				//	"		<table>\r\n" + 
					//"			<tr>\r\n" + 
					//"				\r\n" + 
					//"				<th>Book Code</th>\r\n" + 
					//"				<th>Book Name</th>\r\n" + 
					//"				<th>Book Author</th>\r\n" + 
					//"				<th>Book Price</th>\r\n" + 
					//"				<th>Quantity</th><br/>\r\n" + 
					//"			</tr>");
			int i=0;
			while(rs.next())
			{
				String Seasonnr = rs.getString(1);
				String Player = rs.getString(3);
				i=i+1;
				String n = "checked"+ Integer.toString(i);
				pw.println("<tr>\r\n" + "<td>\r\n"+Seasonnr+"</td>");
				pw.println("<tr>\r\n" + "<td>\r\n"+Player+"</td>");
				//String bAuthor = rs.getString(3);
				//int bPrice = rs.getInt(4);
			//int bQty = rs.getInt(5);
			//pw.println("<tr><td>\n"+trophybearer+"\n</td>");
			//pw.println("<td>\n"+Seasonnr+"\n</td>");
			//pw.println("<td>"+bAuthor+"</td>");
			//pw.println("<td>"+bPrice+"</td>");
			//pw.println("<td>"+bQty+"</td></tr>");
			}
			
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}