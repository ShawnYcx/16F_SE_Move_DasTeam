//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package implementation;

import MySQL.MySQLAccess;
import MySQL.QuerySQL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveClass {
	MySQLAccess access = new MySQLAccess();
	QuerySQL sql = new QuerySQL();

	private int maxAllowed = 0;
	private int countSeniors = 0;
	private List<String> listOfClassInfo = new ArrayList<String>();
	private List<String> listOfStudentClasses = new ArrayList<String>();// this store all the classes a student has taken. 

	public void takeRoom (String roomNumber){

		maxAllowed = access.readDatabase(roomNumber);
	}

	public int getMaxAllowed(){
		return maxAllowed;
	}

	public void getClassData(String subCode, String cNumber){
		listOfClassInfo = sql.getClassInfo(subCode, cNumber);
		System.out.println(listOfClassInfo);
	}
			
	public void printStudentInClass(){
    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			 System.out.println(listOfClassInfo.get(i+1) + ", " + listOfClassInfo.get(i) + ", " + listOfClassInfo.get(i+2)); 
		}
    }

    public String getStudentInfo(String fn, String ln, String classification)
    {
    	//Cyclomatic Complexity = for loop with if + & + & + 1 = 4
    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			 if(listOfClassInfo.get(i).equals(fn) && listOfClassInfo.get(i+1).equals(ln) && listOfClassInfo.get(i+2).equals(classification) )
			 	return "T";
		}
		return "F";
    }

    public void setStudentClasses(String last_name,String first_name, String termcode)
    {
    	listOfStudentClasses = sql.getStudentClassesData(last_name,first_name,termcode);
    	System.out.println(listOfStudentClasses);

    }
     public String getStudentClasses(String subject_Code, String course_Number, String instructor)
    {
    	//Cyclomatic Complexity = for loop with if + & + & + 1 = 4
	  	for (int i = 0; i < listOfStudentClasses.size(); i+=10) {
			 if(listOfStudentClasses.get(i).equals(subject_Code) && listOfStudentClasses.get(i+1).equals(course_Number) && listOfStudentClasses.get(i+2).equals(instructor) )
			 	return "T";
		}
		return "F";
    }

    

    

}