import java.util.*;
import java.sql.*;
public class PreparedStatementInsert{
	public static void main(String[] args)throws Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student",Username,Password);
		String answer="y";
		while(answer.equalsIgnoreCase("y")){
		System.out.println("What do you want to do");
		System.out.println("1.insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Retrive all");
		System.out.println("5.Retrive a row");
		System.out.println("enter the corresponding number");
		int num=sc.nextInt();
		if(num==1 & num<6){
			System.out.println("inside Insert Mode");
			PreparedStatement pst=con.prepareStatement("insert into stu values(?,?,?);");
			System.out.println("enter the student name, id & age");
			String name=sc.next();
			int id=sc.nextInt();
			int age=sc.nextInt();
			pst.setString(1,name);
			pst.setInt(2,id);
			pst.setInt(3,age);
			int n=pst.executeUpdate();
			if(n>0){
				System.out.println("inserted");
			}
		}
		else if(num==2 & num<6){
			System.out.println("inside Update Mode");
			PreparedStatement pst=con.prepareStatement("update stu set sName=?,sAge=? where sNo=?;");
			System.out.println("enter the Student name, id & age for update");
			String name=sc.next();
			int no=sc.nextInt();
			int age=sc.nextInt();
			pst.setString(1,name);
			pst.setInt(2,age);
			pst.setInt(3,no);
			int n=pst.executeUpdate();
			if(n>0){
				System.out.println("Updated");
			}
		}
		else if(num==3 & num<6){
			System.out.println("inside Delete Mode");
			PreparedStatement pst=con.prepareStatement("delete from stu where sNo=?;");
			System.out.println("Enter the student record to be deleted");
			int no=sc.nextInt();
			pst.setInt(1,no);
			int n=pst.executeUpdate();
			if(n>0){
				System.out.println("deleted");
			}
		}
		else if(num==4 & num<6){
			System.out.println("inside Retrive all");
			PreparedStatement pst=con.prepareStatement("Select * from stu;");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				String name=rs.getString(1);
				int no=rs.getInt(2);
				int age=rs.getInt(3);
				System.out.println(name+"|"+no+"|"+age);
			}
		}
		else if(num==5 & num<6){
			System.out.println("inside Retrive a record");
			PreparedStatement pst=con.prepareStatement("select * from stu where sNo=?;");
			System.out.println("Eneter the record you want to retrive");
			int id=sc.nextInt();
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				String name=rs.getString(1);
				int no=rs.getInt(2);
				int age=rs.getInt(3);
				System.out.println(name+"|"+no+"|"+age);
			}
			else{
				System.out.println("There is no recored found");
			}
		}
		System.out.println("Do you want to continue? enter y/n");
		answer=sc.next();
		if(answer.equalsIgnoreCase("n")){
			System.out.println("Bye");
		}
		}
		con.close();
	}
}
