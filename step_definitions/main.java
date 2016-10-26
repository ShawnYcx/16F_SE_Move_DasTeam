package step_definitions;
import MySQL.MySQLAccess;
import java.util.Scanner;

public class main{
	public static void main(String[] args) throws Exception{
		MySQLAccess access = new MySQLAccess();
		access.readDatabase();
	}
}