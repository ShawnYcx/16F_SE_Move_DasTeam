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
	private int stopper = 0;
	private String daySaved;
	private List<String> professorTime = new ArrayList<String>();
	private List<String> tMWF = new ArrayList<String>();
	private List<String> tTR = new ArrayList<String>();
	private List<String> tMW = new ArrayList<String>();
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

		for (int i = 800; i < 1600; i += 130){
			if(i == 1230){
				i -= 30;
			}

			if(i%100 == 60){
				i += 40;
			}

			if (i != 1100){
				tTR.add(Integer.toString(i));
				tTR.add("0");
			}

		}		

		for (int i = 800; i < 1600; i += 130){
			if(i == 1230){
				i -= 30;
			}

			if(i%100 == 60){
				i-=30;
			}

			if (i != 1100){
				tMW.add(Integer.toString(i));
				tMW.add("0");
			}

		}
	}
	public int getStopper(){
		return stopper;
	}
	// Change to CRN soon
	public void getClassData(String crn){
		listOfClassInfo = sql.getClassInfo(crn);
		if (listOfClassInfo.isEmpty()){
			stopper = 1;
		}else {
			stopper = 0;
			sizeOfCurrentClass = listOfClassInfo.size();
			professorName = access.getTime(crn);
			getSeniors();
		}

		
		// getProfessordata();
	}
	
	public void showOpenRooms(String daysToGet, String timeToget) {
		List<String> tempArr = new ArrayList<String>();
		Map<String, Boolean> tempT = new HashMap<String, Boolean>();

		tempArr = sql.getRoomsThatFit(sizeOfCurrentClass);
		classes = access.getRoomCode(daysToGet, timeToget);

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
		} else {
			System.out.println("Sorry! There are no rooms available for the selected time.");
			System.out.println("Please select another time");
			
			showTimeSlots(daySaved);
		}

	}

	public int showTimeSlots(String input) {
		System.out.println("Which time slot would you want to move the class to?\n");
		daySaved = input;
		//Cyclomatic Complexity = if + || + for loop + for loop if + for loop if + else if + || 
		//+ else if + || + for loop + for loop if + for loop if + for loop if + for loop else 
		//+ else if + || + for loop + for loop if + for loop if + else if + else + 1 = 22 (Moderate application Cyclomatic Complexity)
		if ((input.equals("1")) || (input.equals("MWF"))){
			professorTime = access.getDataFromSQLProfessor("MWF", professorName.get(0));
			for (int i = 0; i < nameOfSeniors.size(); i+=2){
				newlistOfStudentClasses = access.getDataFromSQLStudent("MWF", nameOfSeniors.get(i+1), nameOfSeniors.get(i));

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

				for (int i = 0; i < tMWF.size(); i+=2) {
					if (professorTime.get(0).equals(tMWF.get(i)))
						System.out.println("The professor is having another class a this time: [" + tMWF.get(i) +"]");   
					else{
						if (tMWF.get(i+1).equals("0")){
							System.out.println("[Time: " + tMWF.get(i) + ", Number of seniors: " + tMWF.get(i+1) + "] - Recommended");   
						}
						else{
							System.out.println("[Time: " + tMWF.get(i) + ", Number of seniors: " + tMWF.get(i+1) + "]");   
						}
					}
				}

				return 1;
		} else if ((input.equals("2")) || (input.equals("TR"))){
			for (int i = 0; i < nameOfSeniors.size(); i+=2){
				newlistOfStudentClasses = access.getDataFromSQLStudent("TR", nameOfSeniors.get(i+1), nameOfSeniors.get(i));
					for (int j = 0; j < tTR.size(); j+=2) {
						for (int k = 0; k < newlistOfStudentClasses.size(); k++) {
							int x;
							if (tTR.get(j).equals(newlistOfStudentClasses.get(k))){
								x = Integer.parseInt(tTR.get(j+1)) + 1;
								tTR.set(j+1, Integer.toString(x));
							}
						}
					}
				}

				int time = 8;
				for (int i = 0; i < tTR.size(); i+=2) {
					
					if (tTR.get(i+1).equals("0")){
						System.out.println("[Time: " + tTR.get(i) + ", Number of seniors: " + tTR.get(i+1) + "] - Recommended");   
					}
					else{
						System.out.println("[Time: " + tTR.get(i) + ", Number of seniors: " + tTR.get(i+1) + "]");   
					}
				}
				return 2;

		} else if ((input.equals("3")) || (input.equals("MW"))){
			for (int i = 0; i < nameOfSeniors.size(); i+=2){
				newlistOfStudentClasses = access.getDataFromSQLStudent("MW", nameOfSeniors.get(i+1), nameOfSeniors.get(i));
					for (int j = 0; j < tMW.size(); j+=2) {
						for (int k = 0; k < newlistOfStudentClasses.size(); k++) {
							int x;
							if (tMW.get(j).equals(newlistOfStudentClasses.get(k))){
								x = Integer.parseInt(tMW.get(j+1)) + 1;
								tMW.set(j+1, Integer.toString(x));
							}
						}
					}
				}

				int time = 8;
				for (int i = 0; i < tTR.size(); i+=2) {

					if (tMW.get(i+1).equals("0")){
						System.out.println("[Time: " + tMW.get(i) + ", Number of seniors: " + tMW.get(i+1) + "] - Recommended");   
					}
					else{
						System.out.println("[Time: " + tMW.get(i) + ", Number of seniors: " + tMW.get(i+1) + "]"); 
					}
					  
				}
				return 3;

		} else if (input.toUpperCase().equals("QUIT")){

			return -2;

		} else {
			System.out.println("Unknown input. Please try again.");
			System.out.println("Example: type in \"1\" or \" MWF \"");
			return -1;
		}
	}

	public void getSeniors(){
			//Cyclomatic Complexity = for loop + for loop if + 1 = 3
			for (int i = 0; i < listOfClassInfo.size(); i+=3) {
				if (listOfClassInfo.get(i+2).equals("Senior")){
					nameOfSeniors.add(listOfClassInfo.get(i));
					nameOfSeniors.add(listOfClassInfo.get(i+1));
				}
			}
	}

	public String[] getClassDetails(String crn){
        return access.getClassInfo(crn);
	}
	
	public void clearScreen(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

