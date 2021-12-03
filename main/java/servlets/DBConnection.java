package servlets;
import java.sql.*;
import constants.IDatabase;

public class DBConnection {
	private static Connection con;
	
	private DBConnection(){};
	
//	static {
//		
//		try {
//			
//			Class.forName(IDatabase.DRIVER_NAME);
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		try {
//			
//			con = DriverManager.getConnection(IDatabase.CONNECTION_STRING, IDatabase.USER_NAME, IDatabase.PASSWORD);
//			DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
//			System.out.println("Driver name: " + dm.getDriverName());
//            System.out.println("Driver version: " + dm.getDriverVersion());
//            System.out.println("Product name: " + dm.getDatabaseProductName());
//            System.out.println("Product version: " + dm.getDatabaseProductVersion());
//		
//		}
//		catch (SQLException e) {
//
//			e.printStackTrace();
//		
//		}
//		
//		
//	}//End of static block
	
	public static Connection getCon()
	{
		
		try {
					
					Class.forName(IDatabase.DRIVER_NAME);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		
	try {
			
			con = DriverManager.getConnection(IDatabase.CONNECTION_STRING, IDatabase.USER_NAME, IDatabase.PASSWORD);
			DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
		
		}
		catch (SQLException e) {

			e.printStackTrace();
		
		}
        return con;
	}
}