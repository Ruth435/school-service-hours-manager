/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.time.LocalDate;

/**
 * Stores details of an event
 * @author ruth2
 */
public class Event {//Class Name 
    //Components 
    private int eventNum; //Event number
    private String eventName; //Event Name
    private double numHours; //Event number of hours
    private LocalDate date; //Event date
    private boolean catering; //Boolean to check if the event is for catering
    private boolean photography;//Boolean to check if the event is for photography
    private boolean firstAid; //Boolean to check if the event is for FirstAid
    private boolean audioVisual; //Boolean to check if the event is for AV

   //Constructor Method

    /**
     * parameterized constructor to assign default values to an event
     * @param num the integer event number
     * @param n the String name of the event
     * @param h the integer number of hours of the event
     * @param d the date of the event
     * @param c the Boolean to check if the event is for catering
     * @param p the Boolean to check if the event is for photography
     * @param f the Boolean to check if the event is for first aid
     * @param a the Boolean to check if the event is for AV
     */
    public Event(int num, String n, double h,LocalDate d, boolean c, boolean p, boolean f, boolean a)
    {
        eventNum = num; //Assigns imput value to the variable
        eventName = n; //Assigns imput value to the variable
        numHours = h; //Assigns imput value to the variable
        date = d; //Assigns imput value to the variable
        catering = c; //Assigns imput value to the variable
        photography = p; //Assigns imput value to the variable
        firstAid = f; //Assigns imput value to the variable
        audioVisual = a; //Assigns imput value to the variable
    }
    
    //Accessor and Mutator Methods

    /**
     * getter method for the event number
     * @return the the number of the event as an integer
     */
    public int getEventNum() 
    {
        return eventNum;//Returns the event number
    }

    /**
     * getter method for the event name
     * @return the name of the event as a String
     */
    public String getEventName() 
    {
        return eventName;//Returns the event name
    }

    /**
     * getter method for hours (number of hours for which the event lasts)
     * @return the number of hours as an integer
     */
    public double getNumHours() 
    {
        return numHours;//Returns the event hours
    }

    /**
     * getter method for the event date
     * @return the date of the event as a LocalDate
     */
    public LocalDate getDate() 
    {
        return date; //Returns the event date
    }

    /**
     * getter method for the Boolean catering
     * @return a Boolean to check if the event is for catering
     */
    public boolean isCatering() 
    {
        return catering; //Returns the Boolean to check if the event is for catering
    }

    /**
     * getter method for the Boolean photography
     * @return a Boolean to check if the event is for photography
     */
    public boolean isPhotography() 
    {
        return photography;//Returns the Boolean to check if the event is for photography
    }

    /**
     * getter method for the Boolean FirstAid
     * @return a Boolean to check if the event is for first aid
     */
    public boolean isFirstAid() 
    {
        return firstAid; //Return the Boolean to check if the event is for first aid
    }

    /**
     * getter method for the Boolean Audio Visual
     * @return a Boolean to check if the event is for AV
     */
    public boolean isAudioVisual() 
    {
        return audioVisual; //Returns the Boolean to check if the event is for AV
    }

    @Override
    //toString Method
    public String toString()//Returns all the details of the event as a formatted string
    {
        return "Event{" + "eventNum=" + eventNum + ", eventName=" + eventName + ", numHours=" + numHours + ", date=" + date + ", catering=" + catering + ", photography=" + photography + ", firstAid=" + firstAid + ", audioVisual=" + audioVisual + '}';
    }
}
