//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
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
// private String shawnConnection = "jdbc:mysql://localhost:3306/CS374?user=root&useSSL=false";
// private String ivanConnection = "jdbc:mysql://localhost/ent?useSSL=false&"+"user=root&password=Narutokurama12";

private Connection connect = null;
private Statement statement = null;
private PreparedStatement preparedStatement = null;
private ResultSet resultSet = null;

private List<List<String>> listOfLists = new ArrayList<List<String>>();
private List<String> internal;

public void readDatabase() throws Exception {
         try {
            //This will load the MySQL driver, each DB has its own driver
            Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/new.db");
            statement = connect.createStatement();
            
            // String sub = ("'" + subCode + "'");
            // String num = ("'%" + cNum + "%'");

            // System.out.println(sub);
            // System.out.println(num);
            //this function counts how many class a student is taking. 
            String setSQL = ("SELECT * from rooms");

            resultSet = statement.executeQuery(setSQL);
            
            while (resultSet.next()) {
                internal = new ArrayList<String>();
                String room_number = resultSet.getString("room_number");
                
                internal.add(room_number);
                System.out.println(room_number);
            }        
             

         } catch (Exception e) {
                 // throw e;
            e.printStackTrace();
         } finally {
                 close();
         }
 }

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
