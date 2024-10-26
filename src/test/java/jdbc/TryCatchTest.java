package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TryCatchTest {

	public static void main(String[] args) throws Throwable {
		Connection connection=null;
		try {
		// creating driver object
		Driver driver = new Driver();
		
		// registering driver
		 DriverManager.registerDriver(driver);
		 
		 // establish the connection
		 
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		 
		 // create statement object
		  Statement statement = connection.createStatement();
		  
		  // insert the data
		  int result = statement.executeUpdate("insert into student_info values(2,'Kirans','ME','First');");
		  if(result==1) {
			  System.out.println("data is inserted");
		  }
		  else {
			  System.out.println("data is not inserted");
		  }
		  
		  ResultSet res = statement.executeQuery("select * from student_info;");
 
		  // print the data after delete
		  while(res.next()) {
			  System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4));
		  }
		  
		  // delete the data
		  result = statement.executeUpdate("delete from student_info where Roll='2';");
		  if(result==1) {
			  System.out.println("data is deleted");
		  }
		  else {
			  System.out.println("data is not deleted");
		  }
		  
		  res = statement.executeQuery("select * from student_info;");
		  
		  // print the data after delete
		  while(res.next()) {
			  System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4));
		  }
			  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			connection.close();
		}
	}

}
