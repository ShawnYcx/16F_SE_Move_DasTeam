//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package MySQL;

import MySQL.MySQLAccess;
import java.util.*;

public class QuerySQL {

	MySQLAccess access = new MySQLAccess();
	private List<String> columnsToGet = new ArrayList<String>();
	private int sizeOfCurrentClass = 0;
	private List<String> tMWF = new ArrayList<String>();
	private List<String> tTR = new ArrayList<String>();
	
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
		sizeOfCurrentClass = columns.size();//this is count student

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

	public List<String> getProfessorSchedule(String name, String termcode){

		List<String> columns;
		String setName = ("'" + name + "'"); 
        String setTermCode = ("'%" + termcode + "%'");

        String sqlCMD = ("SELECT Instructor_Name, Instructor_ID, Instructor_Id,Begin_Time,End_Time,Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind from cs374_anon WHERE Instructor_Name ="+ setName + 
           "AND Term_Code like"+ setTermCode);

		columnsToGet.add("Instructor_Name");
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
	
	public void getClassDays(String daysToGet, String timeToget){

		List<String> columns;
		String sqlCMD;
		String setBeginTime = ("'%" + timeToget + "%'");

		if (daysToGet.equals("MWF")){
			sqlCMD = ("SELECT Room_Code from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' AND Begin_Time like "+ setBeginTime + " group by Room_Code");
		}
		else if (daysToGet.equals("TR")){
			sqlCMD = ("SELECT Room_Code from cs374_anon WHERE Tuesday_Ind = 'T' AND Thursday_Ind like '%R%' AND Begin_Time like "+ setBeginTime + " group by Room_Code");
		}
		else {
			sqlCMD = ("SELECT Room_Code from cs374_anon WHERE Friday_Ind = '' AND Wednesday_Ind like '%W%' AND Monday_Ind like '%M%' AND Begin_Time like "+ setBeginTime + " group by Room_Code");
		}

		columnsToGet.add("Room_Number");
		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 

		// return columns;
	}

	public List<String> getRoomsThatFit(String numberOfStudents){

		String max = ("'" + numberOfStudents + "'");
        //this function counts how many class a student is taking. 
        String sqlCMD = ("SELECT * from rooms where max_number >= " + max);

		return access.readDatabase(sqlCMD, room); 
	}

	// Work in progress for this function
	private List<boolean> getMWF(List<String> columns) {
		List<boolean> availableRooms = new ArrayList<String>();
		for (int i = 0; i < tMWF.size(); i++) {
			String timeString = Integer.toString(tMWF.get(i));

			if (columns.contains(timeString)){
				availableRooms.add(true);
			}else {
				availableRooms.add(false);
			}
		}
	}

	private List<boolean> checkOpenRooms(List<String> columns) {

	}
}








