package step_definitions;
import MySQL.MySQLAccess;
import java.util.Scanner;
//import implementation.MoveClass;
import implementation.GetClass;

public class main{
	public static void main(String[] args) throws Exception{
		GetClass getClasses = new GetClass();
		//MoveClass moveclass = new MoveClass();
		//getClasses.readDatabase();

		System.out.println("Select an option to continue.");
		
		System.out.println("1: Show the maximum number of students allowed in a classroom.");
		System.out.println("2: Show the current students description in a class.");

		System.out.println("This program will list all the students in a specific class.\n");

		Scanner options = new Scanner( System.in );
		String i = options.next();
		
		// if (i.equals("1")){
		// 	Scanner user_input = new Scanner( System.in );			
		// 	System.out.println("Enter Business building classroom number: ");
		// 	System.out.println("Try typing classroom number 301 or 316.");
		// 	String roomNumber = user_input.next();
			
		// 	moveclass.takeRoom(roomNumber);
		// 	System.out.println(moveclass.getMaxAllowed());
		// }
		if (i.equals("2")) {

			Scanner user_input = new Scanner( System.in );
			String subCode, cNumber;

			System.out.println("Input subject code: ");
			subCode = user_input.next();

			System.out.println("Input course number: ");
			cNumber = user_input.next();

			getClasses.getClassData(subCode, cNumber);
			if (getClasses.checkClassExist()){
				System.out.println("\nList of students taking [" + subCode + "" + cNumber + "] are: " );
				getClasses.printStudentInClass();
			}else{
				System.out.println("The class [" + subCode + "" + cNumber + "] does not exist in the database.");
			}
		}
	}
}