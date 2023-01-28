package pojo;

import java.io.*;

public class Students {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("----:Welcome to Student DataBase Management System:----");
		InputStreamReader is =new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(is);
		
		
		while(true)
		{
			System.out.println("Press1 to Add Student:- ");
			System.out.println("Press2 to Delete Student:- ");
			System.out.println("Press3 to Display Student");
			System.out.println("Press4 to exit");
			int c=Integer.parseInt(br.readLine());
			switch(c) {
			case 1://For Add Student
				System.out.println("Enter UserName:");
				String name=br.readLine();
				System.out.println("Enter User Phone number:");
				String phone=br.readLine();
				System.out.println("Enter city name:");
				String city=br.readLine();
				
				//create student object to store student
				StudentConnection st=new StudentConnection(name,phone,city);
				System.out.println(st);
				boolean ans=StudentDao.insertStudentToDB(st);
				if (ans)
					System.out.println("Sudent is added Successfully....");
				else
					System.out.println("Something went wrong....");
				
				
				break;
			case 2:// For Delete Student 
				System.out.println("Enter student id to be deleted...");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
					System.out.println("Deleted...");
				else
					System.out.println("Something went Wrong...");
				break;
			case 3:// For Display Student
				System.out.println("The Students details is :");
				System.out.println("***************************************************");
				StudentDao.showDisplay();
				break;
			case 4: //For exit
				System.out.println("Exit....");
				System.out.println("ThankYou for using my Application:- ");
				System.exit(4);
				break;
			}
			
			
		}
	}

}
