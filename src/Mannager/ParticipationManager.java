/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Objects.DBService;
import Objects.Event;
import Objects.Participation;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 * Manages an array of Participation objects
 * @author ruth2
 */
public class ParticipationManager {//Class Name
    //Components
    private int size = 0; //Stores the size of the array
    DBService d = new DBService(); //Creates a connection to the database
    private final Participation[] PartArr = new Participation[2000]; //Creates an array to store up to 2000 participation objects
    DefaultTableModel model = new DefaultTableModel(); //sets the table moddle to the default settings
    

    /**
     * adds a new participation object to the array and database
     * @param studentID Integer ID of the student
     * @param eventID Integer ID of the event
     * @throws SQLException
     */
    public void add(int studentID, int eventID) throws SQLException//Recives a Student ID and Event ID for a new participation record
    {
        PartArr[size] = new Participation(studentID, eventID);//Adds a new Participation to the array
        size++; //Adds 1 to size
        insertParticipation(eventID,studentID);//calls the insert participation mathod
    }
    
    /**
     * Creates an array of participation objects with all their relevant details from the database
     * @throws SQLException
     */
    public ParticipationManager() throws SQLException //Constructor Method
    {
        String sql = "SELECT * FROM tblParticipation;";   //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql); //Puts the results of the query into a result set
        while(s.next()) //checks through each element of the result set
        {
           int sn = s.getInt("StudentID"); //Assigns the current student ID to sn
           int n = s.getInt("EventID"); //Assigns the current Event ID to n
           PartArr[size] = new Participation(sn,n); //Assigns all the details of the current participation to the object array in the next position
           size++; //Adds 1 to size
        }
    }
    
    /**
     * Receives a position from which elements will be moved to the left within the array, can be used to remove an element from the array
     * @param pos the Integer position of the object in the array
     */
    public void shiftLeft(int pos) 
    {
        for (int i = pos; i < size -1; i++) //Loops from position to the end of the array
        {
           PartArr[i] = PartArr[i +1]; //moves each element one forward
        }
        size--; //Decreases size by 1 to accomidate for the removed element
    }
    
    /**
     * Receives an object and creates a query with all relevant details to enter it into the database
     * @param s Integer value of the student ID
     * @param e Integer value of the event ID
     * @throws SQLException
     */
    public void insertParticipation(int s,int e) throws SQLException
    {
        String sql = "INSERT INTO tblParticipation([EventID],[StudentID]) VALUES ('" 
            + e + "','" + s+ "');"; //SQL query to insert a participation record into the database
        try
        {
            d.updateQuery(sql); //Executes the query
        }
        catch(SQLException p)
        {
            System.out.println("Insert error: Could not create participation record");
        }      
    }
    
    /**
     * Receives a row number and deletes the corresponding entry in the database and the object array
     * @param event Integer value of the Event ID
     * @param student Integer value of the Student ID
     * @return a string to indicate success or failure
     */
    public String deleteEntry(int event, int student)
    {
        String sql = "DELETE * FROM tblParticipation WHERE EventID =" + event + " AND StudentID =" + student; //Deletes all columbs where the row number is equal to what the user has entered
        try
        {
            d.updateQuery(sql); //Executes the query
            for (int i =0; i < size-1; i++) //Loops through the array
            {
                if(PartArr[i].getEventID() == event && PartArr[i].getStudentID() == student) //Checks if the current array element in the loop matches the information given
                {
                    shiftLeft(event-1); //Calls the shift left method to remove the event from the array
                    return "You have successfully deleted the record from the database";
                }
            }
        }
        catch(SQLException e)
        {
            return "Error: Could not delete record";
        }
        return""; //Returns a string to indicate success or failure
    }
    
    /**
     * Returns the size of the array
     * @return Integer value of how many objects are in the array
     */
    public int getSize()//Returns the size of the array
    {
        return size; //Returns the size of the array
    }
   
    public String toString() //To String method returns all Participation records in the array
    {
        String temp = "";
        for(int i = 0; i < size; i++)
        {
            temp = temp + PartArr[i].toString() + "\n";
        }
        return temp;
    }
}
