import java.sql.*;  									//1: Include necessary packages
public class ConSql
{  
	public static void main(String args[])
	{  
		String DBurl = "jdbc:mysql://localhost:3306/mydb";
		String DBusername = "root";
		String DBpwd = "";	
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  				//2: Driver registration
			Connection con = DriverManager.getConnection(DBurl, DBusername, DBpwd);  	//3: Create connection

			// Statement stmt = con.createStatement();  				//4: Use connection object & create Statement
            // String query1 = "select * from animals";
            // ResultSet rs = stmt.executeQuery(query1);  				//5: Use statement object & execute query, Store result in Result set
            // while(rs.next())  						//6: Result processing
            //     System.out.println(rs.getInt(1) + "--" + rs.getString(2));
            // rs.close();							//7: Close
            // stmt.close();
            // con.close();

            String query2 = "insert into animals values (?,?)";
            PreparedStatement stmt1 = con.prepareStatement(query2);			//4: Use connection object & create PreparedStatement object
            stmt1.setInt(1, 3);
            stmt1.setString(2, "Horse");
            stmt1.executeUpdate();						//5: Use statement object & execute query		
            System.out.println("Table is updated");
            stmt1.close();
            Statement stmt = con.createStatement();  				//4: Use connection object & create Statement object
            String query1 = "select * from animals";
            ResultSet rs = stmt.executeQuery(query1);  				//5: Use statement object & execute query, Store result in Result set
            while(rs.next())  						//6: Result processing
                System.out.println(rs.getInt(1) + "--" + rs.getString(2));
            rs.close();							//7: Close
            stmt.close();
            con.close();
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}  
}  