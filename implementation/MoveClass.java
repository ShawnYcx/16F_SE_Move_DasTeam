//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package implementation;

import MySQL.MySQLAccess;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveClass {
	MySQLAccess access = new MySQLAccess();;
	private int maxAllowed = 0;
	private int countSeniors = 0;
	private List<String> listOfClassInfo = new ArrayList<String>();
	
	public void takeRoom (String roomNumber){

		maxAllowed = access.readDatabase(roomNumber);
	}

	public int getMaxAllowed(){
		return maxAllowed;
	}

	public void getClassData(String subCode, String cNumber){
		listOfClassInfo = access.getClassInfo(subCode, cNumber);
		
	}

	public void printStudentInClass(){
    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			 System.out.println(listOfClassInfo.get(i+1) + ", " + listOfClassInfo.get(i) + ", " + listOfClassInfo.get(i+2)); 
		}
    }

    public String getStudentInfo(String fn, String ln, String classification)
    {
    	for (int i = 0; i < listOfClassInfo.size(); i+=3) {
			 if(listOfClassInfo.get(i).equals(fn) && listOfClassInfo.get(i+1).equals(ln) && listOfClassInfo.get(i+2).equals(classification) )
			 	return "T";
		}
		return "F";
    }
    

}