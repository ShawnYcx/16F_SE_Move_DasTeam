//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package implementation;

import MySQL.*;
import java.util.*;
import java.util.Scanner;

public class MoveClass {
	QuerySQL sql = new QuerySQL();
	MySQLAccess access = new MySQLAccess();

	private int sizeOfCurrentClass = 0;
	private int countSeniors = 0;
	private List<String> tMWF = new ArrayList<String>();
	private List<String> tTR = new ArrayList<String>();
	private List<String> classes = new ArrayList<String>();
	private List<String> nameOfSeniors = new ArrayList<String>();
	private List<String> professorName = new ArrayList<String>();// this gets professor's name and term code
	private List<String> professorSchedule = new ArrayList<String>();
	private List<String> newProfessorSchedule = new ArrayList<String>();
	private List<String> newlistOfStudentClasses = new ArrayList<String>();
	private List<String> listOfClassInfo = new ArrayList<String>();
	private List<String> listOfStudentClasses = new ArrayList<String>(); // this store all the classes a student has taken.
	

	public void init () {
		for (int i = 800; i < 1700; i += 100){
			if (i != 1100){
				tMWF.add(Integer.toString(i));
				tMWF.add("0");
			}
		}
	}

	// Change to CRN soon
	public void getClassData(String crn){
		listOfClassInfo = sql.getClassInfo(crn);
		sizeOfCurrentClass = listOfClassInfo.size();
		professorName = sql.getProfName(crn);

		getSeniors();
		getProfessordata();
	}

    public void setStudentClasses(String days, String last_name,String first_name)
    {
    	// return sql.getStudentClassesData(days, last_name, first_name);
    	//System.out.println("ClassData: "+ listOfStudentClasses +"\n");
    	
  //   	//Cyclomatic Complexity = for loop + for loop + 1 = 3
  //   	for (int i = 3; i< listOfStudentClasses.size(); i+=9)
		// {
		// 	StringBuilder temp= new StringBuilder();
		// 	for(int count = i; count<i + 5; count++)
		// 	{
		// 		temp.append(listOfStudentClasses.get(count));
		// 	}
		// 	//System.out.println("temp : "+ temp +"\n");
			
		// 	newlistOfStudentClasses.add(temp.toString());
		// 	newlistOfStudentClasses.add(listOfStudentClasses.get(i+5));
		// }
		// System.out.println("StudentClassData: "+ newlistOfStudentClasses +"\n");//work
    }

    public void checkStudentCollision(String daysToGet,String timeToget)
    {
    	//Cyclomatic Complexity = for loop + for loop if + for loop && + 1 = 4
    	// for(int i = 0; i < newlistOfStudentClasses.size() ; i +=3)
    	// {
    	// 	if(daysToGet.equals(newlistOfStudentClasses.get(i)) && timeToget.equals(newlistOfStudentClasses.get(i+1)))
    	// 		return true;
    	// }
    	// return false;
    }

    public void getProfessordata()
    {
    	//professorSchedule = sql.getProfessorSchedule(name, termcode);
  //   	professorSchedule = sql.getProfessorSchedule(professorName.get(0), professorName.get(1));

		// for (int i = 0; i< professorSchedule.size(); i+=7)
		// {
		// 	StringBuilder temp= new StringBuilder();

		// 	//Cyclomatic Complexity = for loop + 1 = 2
		// 	for(int count = i; count<i + 5; count++)
		// 	{
		// 		temp.append(professorSchedule.get(count));
		// 	}
		// 	//System.out.println("temp : "+ temp +"\n");
			
		// 	newProfessorSchedule.add(temp.toString());
		// 	newProfessorSchedule.add(professorSchedule.get(i+5));
		// 	newProfessorSchedule.add(professorSchedule.get(i+6));
		// }
		// System.out.println("professorSchedule : "+ newProfessorSchedule);
		// System.out.println("\n");

		// System.out.println("\ngetProfessorSchedule: " + newProfessorSchedule);
    }

    public boolean checkProfCollision( String daysToGet, String timeToget )
    {
    	//Cyclomatic Complexity = for loop + for loop if + for loop && + 1 = 4
    	// System.out.println(newProfessorSchedule);
    	for(int i = 0; i < newProfessorSchedule.size() ; i +=3)
    	{
    		if(daysToGet.equals(newProfessorSchedule.get(i)) && timeToget.equals(newProfessorSchedule.get(i+1)))
    			return true;
    	}
    	return false;
    }
	
	public void showOpenRooms(String daysToGet, String timeToget) {
		List<String> tempArr = new ArrayList<String>();
		Map<String, Boolean> tempT = new HashMap<String, Boolean>();

		tempArr = sql.getRoomsThatFit(sizeOfCurrentClass);
		classes = sql.getClassDays(daysToGet, timeToget);

		//Cyclomatic Complexity = for loop + for loop if + for loop else + 1 = 4
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
		//Cyclomatic Complexity = for + if + 1 = 3
		for (Map.Entry<String, Boolean> entry : displayRooms.entrySet())
		{
			// output if true and room fits the number of students in the current class
			if ( (entry.getValue() == true) ){
				counter++;
			}
		}

		//Cyclomatic Complexity = if + for loop + for loop if + for loop && + for loop else + else + 1 = 7
		if (counter != displayRooms.size()){
			List<String> temp = new ArrayList<String>(); 
			// temp = sql.getRoomsThatFit(sizeOfCurrentClass);
			// System.out.println(sizeOfCurrentClass);
			// Start listing rooms
			System.out.println("Here are some empty days on the selected date.");
			System.out.println("Rooms listed below are the current available rooms.");
			
			int i = 1;
			for (Map.Entry<String, Boolean> entry : displayRooms.entrySet())
			{
				// output if true and room fits the number of students in the current class
				if ( (entry.getValue() == false)){
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
		
		//Cyclomatic Complexity = if + || + for loop + for loop if + for loop if + else if + || 
		//+ else if + || + for loop + for loop if + for loop if + for loop if + for loop else 
		//+ else if + || + for loop + for loop if + for loop if + else if + else + 1 = 22 (Moderate application Cyclomatic Complexity)
		if ((input.equals("1")) || (input.equals("MWF"))){
			
			for (int i = 0; i < nameOfSeniors.size(); i+=2){
				newlistOfStudentClasses = access.getDataFromSQL2("MWF", nameOfSeniors.get(i+1), nameOfSeniors.get(i));
					for (int j = 0; j < tMWF.size(); j+=2) {
						for (int k = 0; k < newlistOfStudentClasses.size(); k++) {
							int x;
							if (tMWF.get(j).equals(newlistOfStudentClasses.get(k))){
								x = Integer.parseInt(tMWF.get(j+1)) + 1;
								tMWF.set(j+1, Integer.toString(x));
							}
						}
					}
				}

				int time = 8;
				for (int i = 0; i < tMWF.size(); i+=2) {
					System.out.println("[Time: " + tMWF.get(i) + ", Number of seniors: " + tMWF.get(i+1) + "]");   
				}

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

	public String splitAndMergeTimeString(String stringToSplit) {
		if (stringToSplit.contains(":")){
			// This is when stringToSplit contains a colon (9:00)
			String[] splitter = stringToSplit.split(":");
			if (Integer.parseInt(splitter[0]) < 8){
				splitter[0] += 12;
				stringToSplit = splitter[0]+splitter[1];
			}else
				stringToSplit = splitter[0]+splitter[1];

			return stringToSplit;
		} else { 

			// This is when stringToSplit does not have a colon (900)
			int temp = Integer.parseInt(stringToSplit);
			if (temp < 800){
				temp += 1200;
				stringToSplit = Integer.toString(temp);
			}
			return stringToSplit;	
		}
	}


public void getSeniors(){// what about other grades? 
		//Cyclomatic Complexity = for loop + for loop if + 1 = 3


		for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			if (listOfClassInfo.get(i+2).equals("Senior")){
				nameOfSeniors.add(listOfClassInfo.get(i));
				nameOfSeniors.add(listOfClassInfo.get(i+1));
			}
		}

	}
















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