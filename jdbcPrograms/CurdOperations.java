package jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CurdOperations {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("connected " + con);
			Scanner sc=new Scanner(System.in);
			Statement st=con.createStatement();
			System.out.println("Enter the no,name,marks");
			int no=sc.nextInt();
			String name=sc.next();
			int marks=sc.nextInt();
			int res=st.executeUpdate("insert into student values("+no+",'"+name+"',"+marks+")");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
