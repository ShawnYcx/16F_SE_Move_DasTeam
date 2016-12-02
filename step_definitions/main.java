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
		String input, crn, time;
		moveClass.init();
		//getClasses.readDatabase();

		System.out.println("Select an option to continue.");
		
		System.out.println("Enter the CRN of the class you would like to move: ");
		System.out.println("Example inputs: [10602, 10902]");

		crn = options.next();
		while (true){
			moveClass.getClassData(crn);
			if (moveClass.getStopper() == 0)
				break;
			else{
				System.out.println("[" + crn + "] does not exist. Please try again.");
				System.out.println("Enter the CRN of the class you would like to move: ");
				System.out.println("Example inputs: [10602, 10902]");
			}
			crn = options.next();
		}
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
					time = options.next();
					time = moveClass.splitAndMergeTimeString(input);
				
					moveClass.showOpenRooms("MWF", input);
					input = options.next();
					System.out.println("Are you sure you want to move [CRN: " + crn + "] to Days: [MWF] and Time: "+ "["+ time + "]? (Y/N)");
					input = options.next();
					if (input.toUpperCase().equals("Y") || input.toUpperCase().equals("YES")){
						System.out.println("Class moved!");
					} else if(input.toUpperCase().equals("N") || input.toUpperCase().equals("NO")){
						System.out.println("The application has been terminated.");
					} else {
						System.out.println("I don't understand that input. Therefore, application terminated. Thank you for your time.");
					}
					break;
				} else if (chosen == 2){
					time = options.next();
					time = moveClass.splitAndMergeTimeString(input);
				
					moveClass.showOpenRooms("TR", input);
					input = options.next();
					System.out.println("Are you sure you want to move [CRN: " + crn + "] to Days: [MWF] and Time: "+ "["+ time + "]? (Y/N)");
					input = options.next();
					if (input.toUpperCase().equals("Y") || input.toUpperCase().equals("YES")){
						System.out.println("Class moved!");
					} else if(input.toUpperCase().equals("N") || input.toUpperCase().equals("NO")){
						System.out.println("The application has been terminated.");
					} else {
						System.out.println("I don't understand that input. Therefore, application terminated. Thank you for your time.");
					}

					moveClass.showOpenRooms("TR", input);
					break;
					
				} else if (chosen == 3){
					time = options.next();
					time = moveClass.splitAndMergeTimeString(input);
				
					moveClass.showOpenRooms("MW", input);
					input = options.next();
					System.out.println("Are you sure you want to move [CRN: " + crn + "] to Days: [MWF] and Time: "+ "["+ time + "]? (Y/N)");
					input = options.next();
					if (input.toUpperCase().equals("Y") || input.toUpperCase().equals("YES")){
						System.out.println("Class moved!");
					} else if(input.toUpperCase().equals("N") || input.toUpperCase().equals("NO")){
						System.out.println("The application has been terminated.");
					} else {
						System.out.println("I don't understand that input. Therefore, application terminated. Thank you for your time.");
					}
					moveClass.showOpenRooms("MW", input);
					break;
				} else if (chosen == -1){
					time = options.next();
				} else {
					break;
				}
			}
		}		
	}
}