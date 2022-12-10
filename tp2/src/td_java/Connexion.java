package td_java;
import java.sql.*;

public class Connexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/td_java","root","");
			
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from test");
			
			
			while(rs.next()) 
			System.out.println(rs.getInt(1)+""+rs.getString(2));
			conn.close();
			
			
				
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
