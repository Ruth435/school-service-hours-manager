/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;
//Code adapted from Petri Mostert, previous teacher
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Establishes a connection to the database
 * @author ruth2
 */
public class DBService {
    private String url = "jdbc:ucanaccess://2022PAT.accdb";
    private Connection conn = null;
    
    /**
     * Establishes a connection to the database or throws an error
     */
    public DBService()
    {
        try
        {
            conn = DriverManager.getConnection(url); // Tries to establish a connection using the connection string
        }
        catch(SQLException e) // Throws SQLException if connection cannot be established.
        {
            
        }
    }
    
    /**
     * Sends and receives SELECT queries between DB and Java
     * @param sql the SQL query as a String
     * @return the result of the SQL query
     * @throws SQLException
     */
    public ResultSet queryDatabase(String sql) throws SQLException    {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet set = stmt.executeQuery(); // Executes the query received from paramater
        return set;
    }
    
    /**
     *Updates the DB using queries in Java
     * @param sql the SQl query as a String
     * @throws SQLException
     */
    public void updateQuery(String sql) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement(sql); 
        stmt.execute(); // Executes the query received from paramater
    }
}
