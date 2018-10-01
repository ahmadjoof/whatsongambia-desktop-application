package Utils;

import com.sun.rowset.CachedRowSetImpl;
import models.NewsPagesSgc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDataAccessor {
    //Declare JDBC driver
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //Connection
    private static Connection conn = null;

    //Connect to DB
    public static void dbConnect() throws SQLException, ClassNotFoundException{
        //Setting Oracle JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("Where is your Oracle JDBC Driver");
            e.printStackTrace();
            throw e;
        }

        System.out.println("Oracle Jbbc driver register");

        //Establish the Oracle Connection using Connection String

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsongambia","root", "Ndeyfatou1@");
        }catch (SQLException e){
            System.out.println("Connection Failed! Checked output console");
            e.printStackTrace();
            throw e;
        }
    }

    public static void dbDisconnect() throws Exception {
        try {
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        }catch (Exception e){
            throw e;
        }
    }

    //DB Execute Query Operations
    public static ResultSet dbExecuteQuery(String queryStmt) throws Exception {
        //Declare statement, resultSet and CachedResultSet as null
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSet = null;

        try {
            //Connect to DB(Established oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");

            //create statement
            statement = conn.createStatement();

            //Execute select (Query) Operation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection"
            //We are using CachedRowSet
            resultSet = statement.executeQuery(queryStmt);
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        }catch (SQLException e){
            System.out.println("Problem occur at executeQuery operation: " + e);
            throw e;
        }finally {
            if (resultSet != null){
                //Close resultSet
                resultSet.close();
            }

            if (statement != null){
                //Close Statement
                statement.close();
            }

            dbDisconnect();
        }
        return cachedRowSet;
    }

    //DB Execute Update(For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws Exception {
        //Declare Statement
        Statement statement = null;

        try {
            //Connect to DB(Establish Oracle Connection)
            dbConnect();
            statement = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            statement.executeUpdate(sqlStmt);
        }catch (SQLException e){
            System.out.println("Problem occurred at executeUpdate operation: " + e);
            throw e;
        }finally {
            if (statement != null){
                //Close State
                statement.close();
            }
            //Close connection
            dbDisconnect();
        }
    }

}





