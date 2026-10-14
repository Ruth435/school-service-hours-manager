/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * Stores the details of a participation record
 * @author ruth2
 */
public class Participation {//Class Name 
    //Components 
    private int eventID; //Event ID
    private int studentID; //Student ID
    
    //Constructor Method

    /**
     * parameterized constructor to assign default values to a participation record
     * @param studentID the integer student ID
     * @param eventID the integer event ID
     */
    public Participation(int studentID,int eventID) 
    {
        this.eventID = eventID; //assigns imput value to private variable
        this.studentID = studentID; //assigns imput value to private variable
    }

    //Accessor and Mutator Methods

    /**
     * getter method for the event ID of the participation record
     * @return the Event ID as an integer
     */
    public int getEventID() 
    {
        return eventID; //Returns EventID
    }

    /**
     * getter method for the Student ID of the participation record
     * @return the Student ID as an integer
     */
    public int getStudentID() 
    {
        return studentID; //Returns Student ID
    }

    @Override
    //toString Method
    public String toString() 
    {
        return "Participation{" + "eventID=" + eventID + ", studentID=" + studentID + '}'; //Returns all the values as a formatted string
    }
}
