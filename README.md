# FullStack-IPLTournamentDatabaseSystem
User Interface:

Front-End Design is an emerging term for the coalescence between the ever-glamorous world of design and the logic-based world of Front-end development. Front end development is crucial in conveying this branding to customers. It needs to feature the same or similar colors, language, and graphics to help customers easily associate a business's website with their products elsewhere

To make you feel more comfortable, we have developed a user interface for our project using Java Servlets, HTML, CSS and MySQL for Database connectivity. 
Database connection: Created a Database named “IPL” in MySQL and inserted few values for performing operations. To attain the Database connectivity with our code, we have used MySQL jdbc driver. 

Code:
public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/ipl";

I will call the Connection class to get the DB connection.
con = DriverManager.getConnection(IDatabase.CONNECTION_STRING, IDatabase.USER_NAME, IDatabase.PASSWORD);

UI Pages: 
Registration Page: I have created a UI that allows the new users to register for the first time and the values gets automatically inserted into our table in MySQL. 

Login Page: Once the registration is successful, the user can login through the login page. LoginServlet validates in the backend by checking whether the username is already present in the table. 

Stats Page: If the user details are present in the table, Login gets successful and the User can view the Stats available. As of now, we have displayed few stats such as TrophyBearers of the Tournament from 2008 to 2021 , PlayerOfTheSeries for each Season, Each Match data from 2008 to 2021 and Players who played in IPL from 2008 to 2021
