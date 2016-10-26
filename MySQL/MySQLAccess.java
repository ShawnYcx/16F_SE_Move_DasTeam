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
private String max_number;

public int readDatabase(String roomNumber){
         try {
            
            //This will load the MySQL driver, each DB has its own driver
            Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/new.db");
            statement = connect.createStatement();
            
            String sub = ("'" + roomNumber + "'");
            // String num = ("'%" + cNum + "%'");

            // System.out.println(sub);
            // System.out.println(num);
            //this function counts how many class a student is taking. 
            String setSQL = ("SELECT * from rooms where room_number =" + sub);

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
