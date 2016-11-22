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

public List<String> getDataFromSQL(String sqlCMD, List<String> columnsToGet) {
    try {
        // This will load the MySQL driver, each DB has its own driver
              Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
        
        statement = connect.createStatement();
        resultSet = statement.executeQuery(sqlCMD);
        
        internal = new ArrayList<String>();
        while (resultSet.next()) {
            for (int i = 0; i < columnsToGet.size(); i++) {
                // Getting column names from the List and save to Column Data                
                String columnData = resultSet.getString(columnsToGet.get(i));
                internal.add(columnData);
            }
        }
                             
     } catch (Exception e) {
             // throw e;
     } finally {
             close();
     }
     return internal;
     
}

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
