//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package implementation;

import MySQL.MySQLAccess;
import MySQL.QuerySQL;
import java.util.*;

public class MoveClass {
	MySQLAccess access = new MySQLAccess();
	QuerySQL sql = new QuerySQL();

	private int maxAllowed = 0;
	private int countSeniors = 0;
	private List<String> tMWF = new ArrayList<String>();
	private List<String> tTR = new ArrayList<String>();
	private List<String> tMW = new ArrayList<String>();
	private List<String> listOfClassInfo = new ArrayList<String>();
	private List<String> listOfStudentClasses = new ArrayList<String>(); // this store all the classes a student has taken. 

	// Change to CRN soon
	public void getClassData(String subCode, String cNumber){
		listOfClassInfo = sql.getClassInfo(subCode, cNumber);
	}

    public void setStudentClasses(String last_name,String first_name, String termcode)
    {
    	listOfStudentClasses = sql.getStudentClassesData(last_name, first_name, termcode);
    }

	public List<String> findRoomsThatFit (String numberOfStudents){
		 return sql.getMaxStudentInRoom(numberOfStudents);
	}

	public int getPriority (){
		int numberOfSeniors = 0;
		for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			if (listOfClassInfo.get(i+2).equals("Senior")){
				numberOfSeniors++;
			}
		}
		return numberOfSeniors;
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