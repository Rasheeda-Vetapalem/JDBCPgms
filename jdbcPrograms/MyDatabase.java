package jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyDatabase {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("connected " + con);
			Scanner sc=new Scanner(System.in);
			Statement st=con.createStatement();
			
			
			
			//table cteation
			//st.executeUpdate("create table student(sno int,sname varchar(20),marks int)");
			//System.out.println("Table created succesfully");
			
			//insertion
			/*int res=st.executeUpdate("insert into student values(1,'rashi',2)");
			int res1=st.executeUpdate("insert into student values(2,'bhanu',22)");
			System.out.println(res1+"inserted succesfully");*/
			
			//retriving
			/* ResultSet rs=st.executeQuery("select * from student"); 
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			}*/
			
			//deleting
			/*
			st.executeUpdate("delete from student where sno=1");
			System.out.println("Record deleated successfully");
			*/
			
			//updating
			
			st.executeUpdate("update student set marks=98 where sno=2");
			System.out.println("Updated successfully");
			
			st.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
