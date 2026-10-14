/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Objects.DBService;
import Objects.Event;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.lang.model.SourceVersion;
import javax.swing.table.DefaultTableModel;

/**
 * Manages an array of Event Objects from the database
 * @author ruth2
 */
public class EventManager {//Class name
    //Components
    private int size = 0; //Stores the size of the array
    DBService d = new DBService(); //Creates a connection to the database
    Event[] EventArr = new Event[1000]; //Creates an array to store up to 1000 Event objects
    DefaultTableModel model = new DefaultTableModel(); //sets the table moddle to the default settings

    /**
     * Receives all information for a new event except the auto generated Event number
     * @param n String name of the event
     * @param h Integer hours of the event
     * @param d LocalDate date of the event
     * @param c the Boolean to check if the event is for catering
     * @param p the Boolean to check if the event is for photography
     * @param f the Boolean to check if the event is for First Aid
     * @param a the Boolean to check if the event is for AV
     * @throws SQLException
     */
    public void add(String n, double h,LocalDate d, boolean c, boolean p, boolean f, boolean a) throws SQLException
    {
        int x = size -1; //Sets x which will be used to allocate the place in the array where the new record will be stored
        int num = EventArr[x].getEventNum() + 1; //Finds the last ID in the array and sets the value of num one higher
        EventArr[size] = new Event(num,n,h,d,c,p,f,a);//Adds a new event to the array
        insertEvent(EventArr[size]);//calls the insert event method
        size++; //Adds 1 to size
    }
    
    /**
     * Constructor Method to assign Events to an array from the database
     * @throws SQLException
     */
    public EventManager() throws SQLException 
    {
        String sql = "SELECT * FROM tblEvents;";   //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql); //Puts the results of the query into a result set
        while(s.next()) //checks through each element of the result set
        {
           int n = s.getInt("EventID"); //Assigns the current Event ID to n
           String name = s.getString("EventName"); //Assigns the current event name to name
           double h = s.getDouble("Hours"); //Assigns the current Event hours to hours
           Date date = s.getDate("EventDate"); //Assigns the current Event date to date
           LocalDate localDate = date.toLocalDate(); //Converts date to local date
           boolean catering = s.getBoolean("Catering"); //Assigns the current event Boolean indicating if the event is for catering
           boolean photography = s.getBoolean("Photography"); //Assigns the current event Boolean indicating if the event is for photography
           boolean firstAid = s.getBoolean("FirstAid"); //Assigns the current event Boolean indicating if the event is for first aid
           boolean AV = s.getBoolean("AV"); //Assigns the current event Boolean indicating if the event is for AV
           EventArr[size] = new Event(n,name,h,localDate,catering,photography,firstAid,AV); //Assigns all the details of the current event to the object array in the next position
           size++;//Adds 1 to size
        }
    }
    
    /**
     * Receives a position from which elements will be moved to the left within the array, can be used to remove an element from the array
     * @param pos position of the event in the array
     */
    public void shiftLeft(int pos)
    {
        for (int i = pos; i < size -1; i++) //Loops from position to the end of the array
        {
           EventArr[i] = EventArr[i +1]; //moves each element one forward
        } 
        size--; //Decreases size by 1 to accomidate for the removed element
    }
      
    /**
     * Receives an event object and creates a query with all relevant details to enter it into the database
     * @param f Event Object containing all the event details
     * @throws SQLException
     */
    public void insertEvent(Event f) throws SQLException 
    {
        String sql = "INSERT INTO tblEvents([EventName], [Hours], [EventDate], [Catering], [Photography], [FirstAid], [AV]) VALUES ('" 
            + f.getEventName() + "','" + f.getNumHours() + "','" + f.getDate() + "','" + f.isCatering() + "','" 
            + f.isPhotography() + "','" + f.isFirstAid() + "','" + f.isAudioVisual()+"');"; //SQL query to insert an event into the database

        try
        {
            d.updateQuery(sql); //Executes the query
        }
        catch(SQLException e)
        {
            System.out.println("Insert error: could not insert event");
        }      
    }
    
    
    /**
     * Returns the size of the array
     * @return Integer value of the array size
     */
    public int getSize()
    {
        return size; //Returns the size of the array
    }
   
    public String toString() //To String method returns all events in the array
    {
        String temp = "";
        for(int i = 0; i < size; i++)
        {
            temp = temp + EventArr[i].toString() + "\n";
        }
        return temp;
    } 
}
