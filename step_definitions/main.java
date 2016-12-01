package step_definitions;
import MySQL.MySQLAccess;
import java.util.Scanner;
import implementation.MoveClass;
// import implementation.GetClass;

public class main{

	public static void main(String[] args) throws Exception{
		// GetClass getClasses = new GetClass();
		MoveClass moveClass = new MoveClass();
		Scanner options = new Scanner( System.in );
		String input, input2;
		//getClasses.readDatabase();

		System.out.println("Select an option to continue.");
		
		System.out.println("Enter the CRN of the class you would like to move: ");

		input = options.next();
		//input2 = options.next();
		
		moveClass.getClassData(input);
		// Current class time [ACCT120] is on [MWF] at[3:00pm] in room 111
		
//////////////////////////////////////////// testing, this function return empty set
		// String test1 = "Payne";
		// String test2 = "Gretchen";
		// String test3 = "201710";
		// moveClass.setStudentClasses(test1,test2,test3);
/////////////////////////////////////////////

		System.out.println("Which day would you want to move the class to?");
		System.out.println("Example: type in \"1\" or \" MWF \"");
		System.out.println("1: MWF");
		System.out.println("2: TR");
		System.out.println("3: MW");
		System.out.println("4: Quit");

		input = options.next();

		int chosen = 0;
		if (input.equals("4") || input.toUpperCase().equals("QUIT") ){
			System.out.println("The application has been terminated.");
		}
		else {
			while ( true ) {
				chosen = moveClass.showTimeSlots(input);
				if (chosen == 1){
					input = options.next();
					moveClass.showOpenRooms("MWF", input);
					break;
				} else if (chosen == 2){
		
					input = options.next();
					moveClass.showOpenRooms("TR", input);
					break;
					
				} else if (chosen == 3){
		
					input = options.next();
					moveClass.showOpenRooms("MW", input);
					break;
				} else if (chosen == -1){
					input = options.next();
				} else {
					break;
				}
			}
		}

		


		// //Cyclomatic Complexity = if + if + 1 = 3
		// if (i.equals("1")){
		// 	Scanner user_input = new Scanner( System.in );			
		// 	System.out.println("Enter Business building classroom number: ");
		// 	System.out.println("Try typing classroom number 301 or 316.");
		// 	String roomNumber = user_input.next();
			
		// 	moveClass.takeRoom(roomNumber);
		// 	System.out.println("Maximum students allowed in room ["+ roomNumber +"]: " + moveClass.getMaxAllowed());
		// }
		// if (i.equals("2")) {

		// 	Scanner user_input = new Scanner( System.in );
		// 	String subCode, cNumber;

		// 	System.out.println("Input subject code: ");
		// 	subCode = user_input.next();

		// 	System.out.println("Input course number: ");
		// 	cNumber = user_input.next();

		// 	moveClass.getClassData(subCode, cNumber);

		// 	System.out.println("\nList of students taking [" + subCode + "" + cNumber + "] are: " );
		// 	moveClass.printStudentInClass();
		// 	// if (moveClass.checkClassExist()){
				
		// 	// }else{
		// 		// System.out.println("The class [" + subCode + "" + cNumber + "] does not exist in the database.");
		// 	// }
		// }
	}
}