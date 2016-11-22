//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package MySQL;

import MySQL.MySQLAccess;
import java.util.*;

public class QuerySQL {

	MySQLAccess access = new MySQLAccess();
	private List<String> columnsToGet = new ArrayList<String>();;
	
	public List<String> getClassInfo(String subCode, String cNumber){
		List<String> columns;
		String setSubjectCode = ("'" + subCode + "'");
        String setCodeNumber = ("'%" + cNumber + "%'");

		String sqlCMD = ("SELECT First_Name, Last_Name, Class_Desc from cs374_anon WHERE Subject_Code="
            + setSubjectCode + " AND Course_Number like"+ setCodeNumber);

		columnsToGet.add("lastName");
		columnsToGet.add("firstName");
		columnsToGet.add("Class_Desc");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 
		System.out.println(columns);
		return columns;
	}

	public List<String> getStudentClassesData(String lastName, String firstName, String termcode){
		List<String> columns;
		String setLastName = ("'" + lastName + "'"); 
        String setFirstName = ("'%" + firstName + "%'");
        String setTermCode = ("'%" + termcode + "%'");

        String sqlCMD = ("SELECT Subject_Code, Course_Number, Instructor_Id,Begin_Time,End_Time,Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind from cs374_anon WHERE Last_Name ="+ setLastName + 
            "AND First_Name like" + setFirstName +"AND Term_Code like"+ setTermCode);

		columnsToGet.add("Subject_Code");
		columnsToGet.add("Course_Number");
		columnsToGet.add("Instructor_Id");
		columnsToGet.add("Begin_Time");
		columnsToGet.add("End_Time");
		columnsToGet.add("Monday_Ind");
		columnsToGet.add("Tuesday_Ind");
		columnsToGet.add("Wednesday_Ind");
		columnsToGet.add("Thursday_Ind");
		columnsToGet.add("Friday_Ind");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 

		return columns;
	}	
	
}








