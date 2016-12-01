//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package implementation;

import MySQL.QuerySQL;
import java.util.*;
import java.util.Scanner;

public class MoveClass {
	QuerySQL sql = new QuerySQL();

	private int sizeOfCurrentClass = 0;
	private int countSeniors = 0;
	private List<String> classes = new ArrayList<String>();
	private List<String> professorName = new ArrayList<String>();// this gets professor's name and term code
	private List<String> professorSchedule = new ArrayList<String>();
	private List<String> newProfessorSchedule = new ArrayList<String>();
	private List<String> listOfClassInfo = new ArrayList<String>();
	private List<String> listOfStudentClasses = new ArrayList<String>(); // this store all the classes a student has taken. 

	// Change to CRN soon
	public void getClassData(String crn){
		listOfClassInfo = sql.getClassInfo(crn);
		sizeOfCurrentClass = listOfClassInfo.size();
		professorName = sql.getProfName(crn);
		//System.out.println("professorname : "+ professorName.get(0)+ professorName.get(1));
		
		getProfessorSchedule();
	}

    public void setStudentClasses(String last_name,String first_name, String termcode)
    {
    	listOfStudentClasses = sql.getStudentClassesData(last_name, first_name, termcode);
    	//System.out.println("ClassData: "+ listOfStudentClasses);
		
    }

    public void getProfessorSchedule()
    {
    	professorSchedule = sql.getProfessorSchedule(professorName.get(0), professorName.get(1));
		// System.out.println("professorname : "+ professorSchedule);
		// System.out.println("\n");
		for (int i = 0; i< professorSchedule.size(); i+=7)
		{
			StringBuilder temp= new StringBuilder();
			for(int count = i; count<i + 5; count++)
			{
				temp.append(professorSchedule.get(count));
			}
			//System.out.println("temp : "+ temp +"\n");
			
			newProfessorSchedule.add(temp.toString());
			newProfessorSchedule.add(professorSchedule.get(i+5));
			newProfessorSchedule.add(professorSchedule.get(i+6));
		}
		System.out.println("professorSchedule : "+ newProfessorSchedule);
		System.out.println("\n");
    }

    public String checkProfCollision( String daysToGet, String timeToget)
    {
    	for(int i = 0; i < newProfessorSchedule.size() ; i +=3)
    	{
    		if(daysToGet == newProfessorSchedule.get(i) && timeToget == newProfessorSchedule.get(i++))
    			return "True";
    	}
    	return "False";
    }

	public int getPriority (){// what about other grades? 
		int numberOfSeniors = 0;
		for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			if (listOfClassInfo.get(i+2).equals("Senior")){
				numberOfSeniors++;
			}
		}
		return numberOfSeniors;
	}
	
	
	
	public void showOpenRooms(String daysToGet, String timeToget) {
		List<String> tempArr = new ArrayList<String>();
		

		Map<String, Boolean> tempT = new HashMap<String, Boolean>();
		tempArr = sql.getRoomsThatFit(sizeOfCurrentClass);
		classes = sql.getClassDays(daysToGet, timeToget);
	
		for (int i = 0; i < tempArr.size(); i++) {
			String roomAtIndex = tempArr.get(i);
			if (classes.contains(roomAtIndex)){
				tempT.put(roomAtIndex, true);
			} else {
				tempT.put(roomAtIndex, false);
			}
		}
			findRoomsThatFit(tempT, daysToGet);
	}

	// This function loops though the Map and display the rooms that has false as value
	public void findRoomsThatFit(Map<String, Boolean> displayRooms, String daysToGet) {
		int counter = 0;

		for (Map.Entry<String, Boolean> entry : displayRooms.entrySet())
		{
			// output if true and room fits the number of students in the current class
			if ( (entry.getValue() == true) ){
				counter++;
			}
		}

		if (counter != displayRooms.size()){
			List<String> temp = new ArrayList<String>(); 
			temp = sql.getRoomsThatFit(sizeOfCurrentClass);
			System.out.println(sizeOfCurrentClass);
			// Start listing rooms
			System.out.println("Here are some empty days on the selected date.");
			System.out.println("Rooms listed below are the current available rooms.");
			
			int i = 1;
			for (Map.Entry<String, Boolean> entry : displayRooms.entrySet())
			{
				// output if true and room fits the number of students in the current class
				if ( (entry.getValue() == false) && (temp.contains(entry.getValue())) ){
					System.out.println( Integer.toString(i) + ": " + entry.getKey());
					i++;
				} else {}
			}

			Scanner options = new Scanner( System.in );
			String input = options.next();
		} else {
			System.out.println("Sorry! There are no rooms available for the selected time.");
			System.out.println("Please select another room");
			
			Scanner options = new Scanner( System.in );
			String input = options.next();
			showOpenRooms(input, daysToGet);
		}

	}

		public int showTimeSlots(String input) {
		System.out.println("Which time slot would you want to move the class to?");
		if ((input.equals("1")) || (input.equals("MWF"))){
				System.out.print("[");
				int time = 8;
				for (int i = 0; i < 8; i++) {
					if (time != 11 ){ // Don't show classes at 11am
						if (time >= 13)
							time -= 12; // Show times at HH:MM format instead of 24Hrs 

						System.out.print(time + ":" + "00");
						System.out.print(", ");
					}
					time++;
				}
				System.out.print(4 + ":" +"00");
				System.out.println("]");

				return 1;
		} else if ((input.equals("2")) || (input.equals("TR"))){
				int time = 8;
				System.out.print("[");
				System.out.print(time + ":00,");
				time++;
				System.out.print(time + ":30,");
				
				time = 12;
				for (int i = 2; i < 6; i++) {
					if (time >= 13)
						time -= 12; // Show times at HH:MM format instead of 24Hrs 
					if (time == 4){
						System.out.print(time + ":30");
						break;
					}
					if (i % 2 == 0) {
						System.out.print(time + ":00,");
						time++;
					} else {
						System.out.print(time + ":30,");
						time+=2;
					}
					
				}
				
				System.out.println("]");


				return 2;
		} else if ((input.equals("3")) || (input.equals("MW"))){
				System.out.print("[");
				int time = 8;
				for (int i = 0; i < 8; i++) {
					if (time != 11 ){ // Don't show classes at 11am
						if (time >= 13)
							time -= 12; // Show times at HH:MM format instead of 24Hrs 

						System.out.print(time + ":" + "00");
						System.out.print(", ");
					}
					time++;
				}
				System.out.print(4 + ":" +"00");
				System.out.println("]");
				return 3;

		} else if (input.toUpperCase().equals("QUIT")){
			return -2;
		} else {
			System.out.println("Unknown input. Please try again.");
			System.out.println("Example: type in \"1\" or \" MWF \"");
			return -1;
		}
	}

;


  //   public void saveClassTime()
  //   {
  //   	/*
		// 	Use the following index to find the following days

  //   		M,T,W,R,F
  //   		5,6,7,8,9
  //   	*/
    	
	 //  	for (int i = 0; i < listOfStudentClasses.size(); i+=10) {

	 //  		// This section gets the days of classes
		// 	// if((listOfStudentClasses.get(i+5).equals("M")) && (listOfStudentClasses.get(i+7).equals("W")) && (listOfStudentClasses.get(i+9).equals("F")) )
		// 	// {
		// 	//  	for(int k = 0; k < 10; k++){
		// 	//  		tMWF.add(listOfStudentClasses.get(k));
		// 	//  	}
		// 	// }
		// 	// else if((listOfStudentClasses.get(i+6).equals("T")) && (listOfStudentClasses.get(i+8).equals("R")))
		// 	// {
		// 	//  	for(int k = 0; k < 10; k++){
		// 	//  		tTR.add(listOfStudentClasses.get(k));
		// 	//  	}
		// 	// }
		// 	// else if((listOfStudentClasses.get(i+5).equals("M")) && (listOfStudentClasses.get(i+7).equals("W")) && (listOfStudentClasses.get(i+9).equals("")))
		// 	// {
		// 	// 	for(int k = 0; k < 10; k++){
		// 	//  		tMW.add(listOfStudentClasses.get(k));
		// 	//  	}
		// 	// }

		// 	// This section gets the times of classes
		// 	// if((listOfStudentClasses.get(i+5))
		// 	// {
		// 	//  	// Save time of class
		// 	// }
		// }
		
  //   }

    /*
		Methods not needed

		public void printStudentInClass(){
    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			 System.out.println(listOfClassInfo.get(i+1) + ", " + listOfClassInfo.get(i) + ", " + listOfClassInfo.get(i+2));
		}

		public String getStudentInfo(String fn, String ln, String classification)
	    {
	    	//Cyclomatic Complexity = for loop with if + & + & + 1 = 4
	    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
				 if((listOfClassInfo.get(i).equals(fn)) && (listOfClassInfo.get(i+1).equals(ln)) && (listOfClassInfo.get(i+2).equals(classification)))
				 	return "T";
			}
			return "F";
	    }
	    }


	    public String getStudentClasses(String subject_Code, String course_Number, String instructor)
	    {
	    	//Cyclomatic Complexity = for loop with if + & + & + 1 = 4
		  	for (int i = 0; i < listOfStudentClasses.size(); i+=10) {
				 if((listOfStudentClasses.get(i).equals(subject_Code)) && (listOfStudentClasses.get(i+1).equals(course_Number)) && (listOfStudentClasses.get(i+2).equals(instructor)) )
				 	return "T";
			}
			return "F";
	    }


	    // public int getMaxAllowed(){
	// 	return maxAllowed;
	// }
    */

    

}