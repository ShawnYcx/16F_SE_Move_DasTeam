package step_definitions;
import MySQL.MySQLAccess;
import java.util.Scanner;
import implementation.MoveClass;
// import implementation.GetClass;

public class main{
	// Some inputs may be '9:30' and some may be '930'
	// This function will generalize the input

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
		moveClass.setStudentClasses("Payne","Gretchen", "201710");

//0-----------------------example
		// String result = moveClass.checkProfCollision("M","1500");
		// System.out.println(result);
//------------------------end


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
				// System.out.println("Class priority based on number of seniors: " + moveClass.getPriority);
				if (chosen == 1){
					input = options.next();
					input = moveClass.splitAndMergeTimeString(input);
					if (moveClass.checkProfCollision("MWF", input)){
						System.out.println("The professor of the class you're trying to move is teaching a class at this time and day.");
						System.out.println("Please select another.");
					}
					if (moveClass.checkStudentCollision("MWF", input)){
						System.out.println("Student Collided");
						// System.out.println(moveClass.getPriority);
					}
					// moveClass.showOpenRooms("MWF", input);
					break;
				} else if (chosen == 2){
					input = options.next();
					input = moveClass.splitAndMergeTimeString(input);
					// moveClass.showOpenRooms("TR", input);
					break;
					
				} else if (chosen == 3){
					input = options.next();
					input = moveClass.splitAndMergeTimeString(input);
					// moveClass.showOpenRooms("MW", input);
					break;
				} else if (chosen == -1){
					input = options.next();
				} else {
					break;
				}
			}
		}		
	}
}