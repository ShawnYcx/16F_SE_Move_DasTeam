//CS374 DasTeam: Shawn scy12a, Steven sxq13a, Ivan ioa13a.
//notes:SQ: get time from db for each class.
package MySQL;

import java.util.*;
import java.sql.*;
import org.sqlite.*;

public class MySQLAccess {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private List<String> internal;
    private String max_number;
    public List<String> readDatabase(String sqlCMD){
         try {
            
            //This will load the MySQL driver, each DB has its own driver
            Class.forName("org.sqlite.JDBC");
            // Setup the connection with the DB
            connect = DriverManager
                         .getConnection("jdbc:sqlite:Database/SQLite/new.db");

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            internal = new ArrayList<String>();
            //Cyclomatic Complexity = while loop + 1 = 2
            while (resultSet.next()) {
                String room_number = resultSet.getString("room_number");
                internal.add(room_number);
            }        
            
            } catch (Exception e) {
                    // throw e;
                e.printStackTrace();
            } finally {
                close();
            }
            // System.out.println(internal);
        
        return internal;
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
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                for (int i = 0; i < columnsToGet.size(); i++) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString(columnsToGet.get(i));
                    internal.add(columnData);

                    //System.out.println("1: " +internal);
                }
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        System.out.println(internal);
        return internal;
    }

    // You need to close the resultSet
    private void close() {
         try {
            //Cyclomatic Complexity = if + if + if + 1 = 4
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

    public List<String> getDataFromSQL2(String sqlCMD, List<String> columnsToGet) {
        List<String> internal1 = new ArrayList<String>();
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                for (int i = 0; i < columnsToGet.size(); i++) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString(columnsToGet.get(i));
                    internal1.add(columnData);

                    //System.out.println("1: " +internal);
                }
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        System.out.println(internal);
        return internal1;
    }

}
