package step_definitions;
import MySQL.MySQLAccess;
import java.util.Scanner;
import implementation.MoveClass;
// import implementation.GetClass;

public class main{
	public static void main(String[] args) throws Exception{
		// GetClass getClasses = new GetClass();
		MoveClass moveclass = new MoveClass();
		Scanner options, input;
		//getClasses.readDatabase();

		System.out.println("Select an option to continue.");
		
		System.out.println("Enter the CRN of the class you would like to move: ");

		options = new Scanner( System.in );
		input = options.next();
		
		moveclass.getClassData(i);
		// Current class time [ACCT120] is on [MWF] at[3:00pm] in room 111

		System.out.println("Which day would you want to move the class to?");
		System.out.println("1: MWF");
		System.out.println("2: TR");
		System.out.println("3: MW");

		options = new Scanner( System.in );
		input = options.next();

		

		// //Cyclomatic Complexity = if + if + 1 = 3
		// if (i.equals("1")){
		// 	Scanner user_input = new Scanner( System.in );			
		// 	System.out.println("Enter Business building classroom number: ");
		// 	System.out.println("Try typing classroom number 301 or 316.");
		// 	String roomNumber = user_input.next();
			
		// 	moveclass.takeRoom(roomNumber);
		// 	System.out.println("Maximum students allowed in room ["+ roomNumber +"]: " + moveclass.getMaxAllowed());
		// }
		// if (i.equals("2")) {

		// 	Scanner user_input = new Scanner( System.in );
		// 	String subCode, cNumber;

		// 	System.out.println("Input subject code: ");
		// 	subCode = user_input.next();

		// 	System.out.println("Input course number: ");
		// 	cNumber = user_input.next();

		// 	moveclass.getClassData(subCode, cNumber);

		// 	System.out.println("\nList of students taking [" + subCode + "" + cNumber + "] are: " );
		// 	moveclass.printStudentInClass();
		// 	// if (moveclass.checkClassExist()){
				
		// 	// }else{
		// 		// System.out.println("The class [" + subCode + "" + cNumber + "] does not exist in the database.");
		// 	// }
		// }
	}
}