package jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Prearedstmtconn {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","root");
		System.out.println(" successfully completed" +con);
		Statement  stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter enum ,ename,age");
		int num = sc.nextInt();
		String name = sc.next();
		int age = sc.nextInt();
	    PreparedStatement pstmt = con.prepareStatement("insert into ojasemployee values(?,?,?)");
	    pstmt.setInt(1, num);
	    pstmt.setString(2, name);
	    pstmt.setInt(3, age);
	    System.out.println(" inserted succesfullyy");
	    int res = pstmt.executeUpdate();
		stmt.close();
		con.close();
			
}

catch (Exception e) {
	System.out.println(e);
}
}
}
