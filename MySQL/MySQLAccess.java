//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
//notes:SQ: get time from db for each class.
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.*;
import org.sqlite.*;

public class MySQLAccess {

private Connection connect = null;
private Statement statement = null;
private PreparedStatement preparedStatement = null;
private ResultSet resultSet = null;

private List<List<String>> listOfLists = new ArrayList<List<String>>();

private List<String> internal;
private List<String> internal2;
private String max_number;

public int readDatabase(String roomNumber){
     try {
        
        //This will load the MySQL driver, each DB has its own driver
        Class.forName("org.sqlite.JDBC");
        // Setup the connection with the DB
        connect = DriverManager
                     .getConnection("jdbc:sqlite:Database/SQLite/new.db");
       
        String sub = ("'" + roomNumber + "'");
        // String num = ("'%" + cNum + "%'");
        // System.out.println(sub);
        // System.out.println(num);
        //this function counts how many class a student is taking. 
        String setSQL = ("SELECT * from rooms where room_number =" + sub);
        
        statement = connect.createStatement();
        resultSet = statement.executeQuery(setSQL);
       
        while (resultSet.next()) {
            max_number = resultSet.getString("max_number");
            //System.out.println(max_number);
        }        
         

         } catch (Exception e) {
                 // throw e;
            e.printStackTrace();
         } finally {
                 close();
         }
         return Integer.parseInt(max_number);
 }

public List<String> getClassInfo(String subCode, String cNumber) {
    try {
        // This will load the MySQL driver, each DB has its own driver
              Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            

        String setSubjectCode = ("'" + subCode + "'");
        String setCodeNumber = ("'%" + cNumber + "%'");
        //this function counts how many class a student is taking. 
        String setSQL = ("SELECT First_Name, Last_Name, Class_Desc from cs374_anon WHERE Subject_Code="
            + setSubjectCode + " AND Course_Number like"+ setCodeNumber);
         //System.out.println(setSQL);//test
        
        statement = connect.createStatement();
        resultSet = statement.executeQuery(setSQL);
        
        internal = new ArrayList<String>();
        while (resultSet.next()) {
            String First_Name = resultSet.getString("First_Name");
            String Last_Name = resultSet.getString("Last_Name");
            String Class_Desc = resultSet.getString("Class_Desc");

            internal.add(Last_Name);
            internal.add(First_Name);
            internal.add(Class_Desc);

            //System.out.println(internal);
        }
                             
     } catch (Exception e) {
             // throw e;
     } finally {
             close();
     }
     return internal;
     
}

//this will get student's classes
public List<String> getStudentClassesData(String lastName, String firstName, String termcode) {
    try {
        // This will load the MySQL driver, each DB has its own driver
              Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
           
        String setLastName = ("'" + lastName + "'"); 
        String setFirstName = ("'%" + firstName + "%'");
        String setTermCode = ("'%" + termcode + "%'");
        //this function counts how many class a student is taking. 
        String setSQL = ("SELECT Subject_Code, Course_Number, Instructor_Id,Begin_Time,End_Time,Monday_Ind,Tuesday_Ind,Wednesday_Ind,Thursday_Ind,Friday_Ind from cs374_anon WHERE Last_Name ="+ setLastName + 
            "AND First_Name like" + setFirstName +"AND Term_Code like"+ setTermCode);
       // System.out.println("1");
        //System.out.println(setSQL);//test
        
        statement = connect.createStatement();
        resultSet = statement.executeQuery(setSQL);
        //System.out.println("2");

        internal2 = new ArrayList<String>();
        while (resultSet.next()) {
            //System.out.println("2");
            String Subject_Code = resultSet.getString("Subject_Code");
            String Course_Number = resultSet.getString("Course_Number");
            String Instructor_Id = resultSet.getString("Instructor_Id");
            String Begin_Time = resultSet.getString("Begin_Time");
            String End_Time = resultSet.getString("End_Time");
            String Monday_Ind = resultSet.getString("Monday_Ind");
            String Tuesday_Ind = resultSet.getString("Tuesday_Ind");
            String Wednesday_Ind = resultSet.getString("Wednesday_Ind");
            String Thursday_Ind = resultSet.getString("Thursday_Ind");
            String Friday_Ind = resultSet.getString("Friday_Ind");

            internal2.add(Subject_Code);
            internal2.add(Course_Number);
            internal2.add(Instructor_Id);
            internal2.add(Begin_Time);
            internal2.add(End_Time);
            internal2.add(Monday_Ind);
            internal2.add(Tuesday_Ind);
            internal2.add(Wednesday_Ind);
            internal2.add(Thursday_Ind);
            internal2.add(Friday_Ind);
            


            //System.out.println(internal2);
        }                             
     } catch (Exception e) {
             // throw e;
     } finally {
             close();
     }
     return internal2;
     
}//end

/*public List<String> getStudentInfo(String firstName, String lastName) {
    try {
        // This will load the MySQL driver, each DB has its own driver
              Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            statement = connect.createStatement();

        String setFirstName = ("'" + firstName + "'");
        String setLastName = ("'%" + lastName + "%'");
        //this function counts how many class a student is taking. 
        String setSQL = ("SELECT First_Name, Last_Name, Subject_Code, Course_Number from cs374_anon WHERE First_Name="+ setFirstName + " AND Last_Name like "+ setLastName);

        resultSet = statement.executeQuery(setSQL);
        internal = new ArrayList<String>();
        while (resultSet.next()) {
            String Subject_Code = resultSet.getString("Subject_Code");
            String Course_Number = resultSet.getString("Course_Number");

            internal.add(Subject_Code);
            internal.add(Course_Number);
        }
                             
     } catch (Exception e) {
             // throw e;
     } finally {
             close();
     }
     return internal;
     
}*/

// You need to close the resultSet
private void close() {
     try {
             if (resultSet != null) {
                     resultSet.close();
             }

             if (statement != null) {
                     statement.close();
             }

             if (connect != null) {
                     connect.close();
             }
     } catch (Exception e) {

     }
}
}
