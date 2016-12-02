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

    public List<String> getDataFromSQLStudent(String days, String lastName, String firstName) {
        List<String> internal1 = new ArrayList<String>();
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            
            String sqlCMD;
            String setLastName = ("'%" + lastName + "%'"); 
            String setFirstName = ("'%" + firstName + "%'");
            if (days.equals("MWF")){
            // sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' AND Last_Name like"+ setLastName + " AND First_Name like" + setFirstName);
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' and Last_Name like "+ setLastName);
            } else if (days.equals("TR")){
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Tuesday_Ind = 'T' AND Thursday_Ind like '%R%' AND Last_Name like "+ setLastName + " AND First_Name like" + setFirstName);
            } else {
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Friday_Ind = '' AND Wednesday_Ind like '%W%' AND Monday_Ind like '%M%' AND Last_Name like"+ setLastName + " AND First_Name like" + setFirstName);
            }

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString("Begin_Time");
                    //System.out.println("1: " +internal);
                    internal1.add(columnData);
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        return internal1;
    }

    public List<String> getDataFromSQLProfessor(String days, String name) {
        List<String> internal4 = new ArrayList<String>();
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            
            String sqlCMD;
            String setName = ("'%" + name + "%'");

            if (days.equals("MWF")){
            // sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' AND Last_Name like"+ setLastName + " AND First_Name like" + setFirstName);
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Monday_Ind = 'M' AND Wednesday_Ind like '%W%' AND Friday_Ind like '%F%' and Instructor_Name like "+ setName + " GROUP BY CRN");
            } else if (days.equals("TR")){
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Tuesday_Ind = 'T' AND Thursday_Ind like '%R%' AND Instructor_Name like "+ setName + " GROUP BY CRN");
            } else {
                sqlCMD = ("SELECT Begin_Time from cs374_anon WHERE Friday_Ind = '' AND Wednesday_Ind like '%W%' AND Monday_Ind like '%M%' AND Instructor_Name like "+ setName + " GROUP BY CRN");
            }

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString("Begin_Time");
                    //System.out.println("1: " +internal);
                    internal4.add(columnData);
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        return internal4;
    }

    public List<String> getTime(String crn) {
        List<String> internal3 = new ArrayList<String>();
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            
            String setCRN = ("'" + crn + "'");
            String sqlCMD = ("SELECT Instructor_Name, Term_Code from cs374_anon WHERE CRN=" + crn + " group by CRN");

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString("Instructor_Name");
                    String columnData1 = resultSet.getString("Term_Code");
                    //System.out.println("1: " +internal);
                    internal3.add(columnData);
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        return internal3;
    }

    public List<String> getRoomCode(String daysToGet, String timeToget) {
        List<String> internal4 = new ArrayList<String>();
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");
            
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

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                    // Getting column names from the List and save to Column Data                
                    String columnData = resultSet.getString("Room_Code");
                    internal4.add(columnData);
            }
                                 
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        return internal4;
    }

    public String[] getClassInfo(String crn) {
        String[] columns = new String[4];    
        try {
            // This will load the MySQL driver, each DB has its own driver
                  Class.forName("org.sqlite.JDBC");
                // Setup the connection with the DB
                connect = DriverManager
                             .getConnection("jdbc:sqlite:Database/SQLite/CS374.db");

            String setCRN = ("'" + crn + "'");
            String sqlCMD = ("select * from cs374_anon where CRN=" + setCRN);

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlCMD);
            
            
            //Cyclomatic Complexity = while loop + for loop + 1 = 3
            while (resultSet.next()) {
                columns[0] = resultSet.getString("Subject_Code");
                columns[1] = resultSet.getString("Course_Number");
                columns[2] = resultSet.getString("Begin_Time");
                columns[3] = resultSet.getString("End_Time");                
            }
            } catch (Exception e) {
                 // throw e;
            } finally {
                 close();
            }
        return columns;
    }

}
