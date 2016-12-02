//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
package MySQL;

import MySQL.MySQLAccess;
import java.util.*;

public class QuerySQL {
	MySQLAccess access = new MySQLAccess();
	List<String> columnsToGet = new ArrayList<String>();
	
	
	public List<String> getClassInfo(String crn){
        String setCRN = ("'" + crn + "'");
		String sqlCMD = ("SELECT First_Name, Last_Name, Class_Desc from cs374_anon WHERE CRN=" + crn);

		columnsToGet.add("First_Name");
		columnsToGet.add("Last_Name");
		columnsToGet.add("Class_Desc");

		return access.getDataFromSQL(sqlCMD, columnsToGet);
	}	
	
	public List<String> getClassDays(String daysToGet, String timeToget){
		
		
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

		columnsToGet.add("Room_Code");
		return access.getDataFromSQL(sqlCMD, columnsToGet);

	}

	public List<String> getRoomsThatFit(int numberOfStudents){
        //this function counts how many class a student is taking. 
        String sqlCMD = ("SELECT * from rooms where max_number >= " + numberOfStudents);
		return access.readDatabase(sqlCMD);
	}
}








