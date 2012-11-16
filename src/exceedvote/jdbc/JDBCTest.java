package exceedvote.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static boolean verify(String id,String password) throws SQLException{
		Connection con;
		Statement sta;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/exceedvote?"
              + "user=root&password=Whiterabbit");
			sta = con.createStatement();
			rs = sta.executeQuery("select * from user where user_id = \'"+id+"\' and user_password =\'"+password+"\'");
			if(rs.next())
				return true;
			return false;
//			while(rs.next()){
//				return true;
//				String instruction = rs.getString("question");
//				String type = rs.getString("type");
//				System.out.println(instruction+" "+type);
//			}
		} catch (ClassNotFoundException e) {
			System.err.print("ClassNoteFoundException");
			e.printStackTrace();
			return false;
		}		
	}
}
