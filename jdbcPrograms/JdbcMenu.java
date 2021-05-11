package jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	int sno;
	String sanme;
	int marks;

	public Student() {
		System.out.println("default constructure");
	}

	public Student(int sno, String sanme, int marks) {
		super();
		this.sno = sno;
		this.sanme = sanme;
		this.marks = marks;
	}

}

class Operations {
	Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
			System.out.println("Connected" + con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	void menu() {
		String m = "menu Driven Application \n";
		m += "1.Add Student\n";
		m += "2.Delete Student";
		m += "3.Update Student";
		m += "4.List Student";
		m += "5.exit";
	}

	boolean addStudent(Student stud) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into Student values(?,?,?)");
			pst.setInt(1, stud.sno);
			pst.setString(2, stud.sanme);
			pst.setInt(3, stud.marks);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	public boolean deleteStudent(int sno) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update student set sname = ? , marks = ? where sno =?");
			pst.setInt(1, sno);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
		return b;
	}

	boolean updatestudent(int sno, String sname, int marks) {
		boolean b = false;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update student set sname = ? , marks = ? where sno =?");
			pst.setString(1, sname);
			pst.setInt(2, marks);
			pst.setInt(3, sno);
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	List<Student> listStudent() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from student");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Student s = new Student(0, rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3), 0);
				list.add(s);
				rs.close();
				pst.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public class JdbcMenu {
		public static void main(String[] args) {
			int sno, marks;
			String sname;
			boolean res;
			Scanner sc = new Scanner(System.in);
			Operations op = new Operations();
			while (true) {
				op.menu();
				System.out.println("enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("enter student Details");
					sno = sc.nextInt();
					sname = sc.next();
					marks = sc.nextInt();
					Student stud = new Student(sno, sname, marks);
					res = op.addStudent(stud);
					if (res == true) {
						System.out.println("inserted successfully \n");
					} else {
						System.out.println("not inserted");
					}
					break;
				case 2:
					System.out.println("enter student to delete");
					sno = sc.nextInt();
					res = op.deleteStudent(sno);
					if (res == true) {
						System.out.println("deleted successfully \n\n");
					} else {
						System.out.println("Not deleted");
					}
					break;
				case 3:
					System.out.println("enter student details to update");
					sno = sc.nextInt();
					sname = sc.next();
					marks = sc.nextInt();
					res = op.updatestudent(sno, sname, marks);
					if (res == true) {
						System.out.println("updated successfully \n\n");
					} else {
						System.out.println("Not updated");
					}
					break;
				case 4:
					System.out.println("Students list");
					op.listStudent();
					System.out.println();
					System.out.println();
					break;
				case 5:
					System.exit(0);
				}
			}

		}
	}
}
