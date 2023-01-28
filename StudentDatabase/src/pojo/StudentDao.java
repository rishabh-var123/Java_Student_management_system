package pojo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.*;

public class StudentDao {
		public static boolean insertStudentToDB(StudentConnection st)
		{
	//jdbc code
			boolean flag=false;
			try {
				//get connection
				Connection con=CP.createC();
				String q="insert into students(sname,sphoone,scity) values(?,?,?)";
				//PreparedStatement
				PreparedStatement pst=con.prepareStatement(q);
				//set the vlues of parameter
				pst.setString(1, st.getStudentName());
				pst.setString(2, st.getStudentPhone());
				pst.setString(3, st.getStudentCity());
				
				pst.executeUpdate();
				flag=true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
			
		}

		public static boolean deleteStudent(int userId) {
			// TODO Auto-generated method stub
			boolean flag=false;
			try {
				Connection con=CP.createC();
				String q="delete from students where sid=?";
				//PreparedStatement
				PreparedStatement pst=con.prepareStatement(q);
				//set the vlues of parameter
				pst.setInt(1, userId);

				
				pst.executeUpdate();
				flag=true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return flag;	
		}

		public static void showDisplay() {
			// TODO Auto-generated method stub
			
			try {
				Connection con=CP.createC();
				String q="select * from students;";
				//PreparedStatement
				Statement st=con.createStatement();
				ResultSet set=st.executeQuery(q);
				while(set.next())
				{
					int id=set.getInt(1);
					String name=set.getString(2);
					String phone=set.getString(3);
					String city=set.getString("scity");
					
					System.out.println("Id: "+id);
					System.out.println("Name: "+name);
					System.out.println("Phone: "+phone);
					System.out.println("City: "+city);
					System.out.println("***************");
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
				
		}
}
