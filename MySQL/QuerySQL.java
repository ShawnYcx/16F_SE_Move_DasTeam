//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package MySQL;

import MySQL.MySQLAccess;
import java.util.*;

public class QuerySQL {
	MySQLAccess access = new MySQLAccess();
	List<String> columns = new ArrayList<String>();
	List<String> columnsToGet = new ArrayList<String>();
	
	public List<String> getClassInfo(String crn){
		deallocList();

        String setCRN = ("'" + crn + "'");

		String sqlCMD = ("SELECT First_Name, Last_Name, Class_Desc from cs374_anon WHERE CRN=" + crn);

		columnsToGet.add("First_Name");
		columnsToGet.add("Last_Name");
		columnsToGet.add("Class_Desc");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet);

		System.out.println("getClassInfo: " + columns);
		System.out.println("\n");
		return columns;
	}

	public List<String> getProfName(String crn){ //get peofessor name and term code.
		deallocList();

        String setCRN = ("'" + crn + "'");
        String sqlCMD = ("SELECT Instructor_Name, Term_Code from cs374_anon WHERE CRN=" + crn + " group by CRN");
		
		columnsToGet.add("Instructor_Name"); // john homer
		columnsToGet.add("Term_Code");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet);
		System.out.println("getProfName: " + columns);
		System.out.println("\n");
		return columns;
	}

	public List<String> getProfessorSchedule(String name, String termcode){
		deallocList();

		String setName = ("'" + name + "'"); 
        String setTermCode = ("'%" + termcode + "%'");
        //System.out.println(name);
       // System.out.println(termcode);

        String sqlCMD = ("SELECT Instructor_Name, Instructor_ID, Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind,Begin_Time,End_Time, CRN from cs374_anon WHERE Instructor_Name ="+ setName + 
           "AND Term_Code like"+ setTermCode + "GROUP BY CRN");//use CRN to get rid of 

		columnsToGet.add("Instructor_Name");
		columnsToGet.add("Instructor_Id");
		columnsToGet.add("Monday_Ind");
		columnsToGet.add("Tuesday_Ind");
		columnsToGet.add("Wednesday_Ind");
		columnsToGet.add("Thursday_Ind");
		columnsToGet.add("Friday_Ind");
		columnsToGet.add("Begin_Time");
		columnsToGet.add("End_Time");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 

		return columns;
	}	

	// back up getProfessorSchedule
	
	// public List<String> getProfessorSchedule(String name, String termcode){

	// 	List<String> columns;
	// 	String setName = ("'" + name + "'"); 
 //        String setTermCode = ("'%" + termcode + "%'");

 //        String sqlCMD = ("SELECT Instructor_Name, Instructor_ID, Instructor_Id,Begin_Time,End_Time,Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind from cs374_anon WHERE Instructor_Name ="+ setName + 
 //           "AND Term_Code like"+ setTermCode);

	// 	columnsToGet.add("Instructor_Name");
	// 	columnsToGet.add("Instructor_Id");
	// 	columnsToGet.add("Begin_Time");
	// 	columnsToGet.add("End_Time");
	// 	columnsToGet.add("Monday_Ind");
	// 	columnsToGet.add("Tuesday_Ind");
	// 	columnsToGet.add("Wednesday_Ind");
	// 	columnsToGet.add("Thursday_Ind");
	// 	columnsToGet.add("Friday_Ind");

	// 	columns = access.getDataFromSQL(sqlCMD, columnsToGet); 

	// 	return columns;
	// }

	//end

	public List<String> getStudentClassesData(String lastName, String firstName, String termcode){
		deallocList();

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

	
	
	public List<String> getClassDays(String daysToGet, String timeToget){
		deallocList();

		String sqlCMD;
		String setBeginTime = ("'%" + timeToget + "%'");

		if (daysToGet.equals("MWF")){
			sqlCMD = ("SELECT Room_Code, Begin_Time from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' AND Begin_Time like "+ setBeginTime +  "and Bldg_Code like 'MBB' group by Room_Code");
		}
		else if (daysToGet.equals("TR")){
			sqlCMD = ("SELECT Room_Code, Begin_Time from cs374_anon WHERE Tuesday_Ind = 'T' AND Thursday_Ind like '%R%' AND Begin_Time like "+ setBeginTime + " and Bldg_Code like 'MBB' group by Room_Code");
		}
		else {
			sqlCMD = ("SELECT Room_Code, Begin_Time from cs374_anon WHERE Friday_Ind = '' AND Wednesday_Ind like '%W%' AND Monday_Ind like '%M%' AND Begin_Time like "+ setBeginTime + " and Bldg_Code like 'MBB' group by Room_Code");
		}

		columnsToGet.add("Room_Number");
		columns = access.getDataFromSQL(sqlCMD, columnsToGet);

		return columns;
	}

	public List<String> getRoomsThatFit(int numberOfStudents){

		// String max = ("'" + numberOfStudents + "'");
        //this function counts how many class a student is taking. 
        String sqlCMD = ("SELECT * from rooms where max_number >= " + numberOfStudents);

		return access.readDatabase(sqlCMD);
	}
	
	public List<String> getAllRooms() {
		String sqlCMD = ("SELECT * from rooms");
		return access.readDatabase(sqlCMD);
	}

	public void deallocList(){
		columns.clear();
		columnsToGet.clear();
	}
}








