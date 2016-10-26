package implementation;
import MySQL.MySQLAccess;

public class MoveClass {
	MySQLAccess access;
	private int maxAllowed = 0;
	public void takeRoom (String roomNumber){
		access = new MySQLAccess();
		maxAllowed = access.readDatabase(roomNumber);
	}

	public int getMaxAllowed(){
		return maxAllowed;
	}
}