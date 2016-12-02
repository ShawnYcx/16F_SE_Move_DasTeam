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

		//System.out.println("getClassInfo: " + columns+"\n");
		return columns;
	}

	public List<String> getProfName(String crn){ //get peofessor name and term code.
		deallocList();

        String setCRN = ("'" + crn + "'");

        String sqlCMD = ("SELECT Instructor_Name, Term_Code from cs374_anon WHERE CRN=" + crn + " group by CRN");
		
		columnsToGet.add("Instructor_Name"); // john homer
		columnsToGet.add("Term_Code");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet);
		//System.out.println("getProfName: " + columns+"\n");//checked
		return columns;
	}

	public List<String> getProfessorSchedule(String name, String termcode){
		deallocList();
		String setName = ("'" + name + "'"); 
        String setTermCode = ("'%" + termcode + "%'");
        //System.out.println(setName);
        //System.out.println(termcode);
        String sqlCMD = ("SELECT Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind,Begin_Time, Instructor_Name, CRN from cs374_anon WHERE Instructor_Name ="+ setName + 
           "AND Term_Code like"+ setTermCode + "GROUP BY CRN"); 

		columnsToGet.add("Monday_Ind");
		columnsToGet.add("Tuesday_Ind");
		columnsToGet.add("Wednesday_Ind");
		columnsToGet.add("Thursday_Ind");
		columnsToGet.add("Friday_Ind");
		columnsToGet.add("Begin_Time");
		columnsToGet.add("Instructor_Name");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 
		//System.out.println("getProfSchedule: " + columns+"\n");
		return columns;
	}	

	public List<String> getStudentClassesData(String days, String lastName, String firstName){
		deallocList();

		String setLastName = ("'" + lastName + "'"); 
        String setFirstName = ("'%" + firstName + "%'");

        String sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Last_Name ="+ setLastName + "AND First_Name like" + setFirstName);

		columnsToGet.add("Begin_Time");

		columns = access.getDataFromSQL(sqlCMD, columnsToGet); 

		return columns;
	}	

	
	
	public List<String> getClassDays(String daysToGet, String timeToget){
		deallocList();
		
		String sqlCMD;
		String setBeginTime = ("'%" + timeToget + "%'");
		//Cyclomatic Complexity = if + else if + else + 1 = 4
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








