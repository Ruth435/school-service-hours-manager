/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Objects.Admin;
import Objects.DBService;
import Objects.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Manages an array of admin objects from the database
 * @author ruth2
 */
public class AdminManager {
    
    private int size = 0; //Stores the size of the array
    DBService d = new DBService(); //Creates a connection to the database
    private final Admin[] AdminArr = new Admin[500]; //Creates an array to store up to 500 Admin objects
    DefaultTableModel model = new DefaultTableModel(); //sets the table moddle to the default settings
    
    

    /**
     * Adds an admin to the array and to the database
     * @param fn String first name of the admin
     * @param sn String surname of the admin
     * @param ca Boolean to check if the admin oversees catering
     * @param p Boolean to check if the admin oversees photography
     * @param a Boolean to check if the admin oversees AV
     * @param f Boolean to check if the admin oversees First Aid
     * @throws SQLException 
     */
    public void add(String fn, String sn, boolean ca, boolean p, boolean a, boolean f) throws SQLException //Recives all the information for a new admin except the auto generated Admin ID
    {
        int num = AdminArr[size-1].getID() + 1; //Finds the last ID in the array and sets the value of num one higher
        Admin temp = new Admin(num,fn,sn,ca,p,a,f); //creates an admin admin object with all the new details
        AdminArr[size] = new Admin(num,fn,sn,ca,p,a,f);//adds new Admin to the Array 
        insertAdmin(AdminArr[size]); //calls insert admin method to add the admin to the databse
        size++; //Incriments size by 1
    }
    
    /**
     * Parameterized constructor to assign values to an admin
     * @throws SQLException
     */
    public AdminManager() throws SQLException //Constructor Method
    {
        String sql = "SELECT * FROM tblAdmins;"; //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql); //Puts the results of the query into a result set
        while(s.next()) //checks through each element of the result set
        {
           int n = s.getInt("AdminID"); //Assigns the current admin ID to n
           String name = s.getString("AdminName"); //Assigns the current admin first name to name
           String surName = s.getString("AdminSurname"); //Assigns the current admin surname to surName
           boolean catering = s.getBoolean("Catering"); //Assigns the current Admin Boolean indicating if the admin does or does not oversee catering
           boolean photography = s.getBoolean("Photography");//Assigns the current Admin Boolean indicating if the admin does or does not oversee photography
           boolean AV = s.getBoolean("AV"); //Assigns the current Admin Boolean indicating if the admin does or does not oversee AV
           boolean firstAid = s.getBoolean("First Aid");//Assigns the current Admin Boolean indicating if the admin does or does not oversee first aid
           AdminArr[size] = new Admin(n,name,surName, catering, photography, AV, firstAid); //Assigns all the details of the current admin to the object array in the next position
           size++; //Incriments size by 1
        }
    }
    
    /**
     * Receives a position from which elements will be moved to the left within the array, can be used to remove an element from the array
     * @param pos Integer value of the Admin position in the array
     */
    public void shiftLeft(int pos) 
    {
        for (int i = pos; i < size -1; i++) //Loops from position to the end of the array
        {
           AdminArr[i] = AdminArr[i +1]; //moves each element one forward
        }
        size--; //Decreases size by 1 to accomidate for the removed element
    }
    
    /**
     * Receives an admin object and creates a query with all relevant details to enter it into the database
     * @param f Admin object containing all the relevant details
     * @throws SQLException
     */
    public void insertAdmin(Admin f) throws SQLException 
    {
        String sql = "INSERT INTO tblAdmins([AdminName], [AdminSurname], [Catering], [Photography], [AV], [First Aid]) VALUES ('" 
        +  f.getAdminName() + "','" + f.getAdminSurname() + "','" + f.isCatering() + "','" 
        + f.isPhotography() + "','" + f.isAv() + "','" + f.isFirstAid()+"');"; //SQL query to insert an admin into the database

        try
        {
            d.updateQuery(sql); //Executes the query
        }
        catch(SQLException e)
        {
            System.out.println("Insert error: Please try again");
        }      
    }
    
    /**
     * Returns the size of the array
     * @return the size of the array
     */
    public int getSize()
    {
        return size; //Returns the size of the array
    }
    
    /**
     * checks if the current Admin oversees the portfolio specified by the string
     * @param c String name of the portfolio to be checked
     * @param i Integer value of the Admin ID
     * @return false if no match was found, returns true if the Admin does oversee the specified portfolio
     */
    public boolean getPortfolio(String c, int i)
    {
        boolean test = false;    
        for(int j =0; j < size; j++)//loops through all Admins in the array
        {
            if((AdminArr[j].getID()) == i)//checks each Admin ID aginst i
            {
                i = i-1;
            if(c.equalsIgnoreCase("Catering") && AdminArr[i].isCatering())//checks if the string entered is catering and if the current Admin oversees catering
            {
                test = true; 
            }
            else if (c.equalsIgnoreCase("Photography") && AdminArr[i].isPhotography())//checks if the string entered is photography and if the current Admin oversees photography
            {
                test = true;
            }
            else if (c.equalsIgnoreCase("av") && AdminArr[i].isAv())//checks if the string entered is AV and if the current Admin oversees AV
            {
                test = true;
            }
            else if (c.equalsIgnoreCase("First Aid") && AdminArr[i].isFirstAid())//checks if the string entered is First Aid and if the current Admin oversees First Aid
            {
                test = true;
            }
            }
        }
        return test; //Returns false if no match was found, returns true if the Admin does oversee the specified portfolio
    }
    
    /**
     * returns a string containing all the details of the Admin with Admin ID equal to i
     * @param i Integer value of Admin ID
     * @return the string containing all of the Admins formatted details
     */
    public String getCurrent(int i) throws SQLException
    {
        //Components
        String temp = "";
        size = 0;
        String sql = "SELECT * FROM tblAdmins;"; //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql); //Puts the results of the query into a result set
        while(s.next()) //checks through each element of the result set
        {
           int n = s.getInt("AdminID"); //Assigns the current admin ID to n
           String name = s.getString("AdminName"); //Assigns the current admin first name to name
           String surName = s.getString("AdminSurname"); //Assigns the current admin surname to surName
           boolean catering = s.getBoolean("Catering"); //Assigns the current Admin Boolean indicating if the admin does or does not oversee catering
           boolean photography = s.getBoolean("Photography");//Assigns the current Admin Boolean indicating if the admin does or does not oversee photography
           boolean AV = s.getBoolean("AV"); //Assigns the current Admin Boolean indicating if the admin does or does not oversee AV
           boolean firstAid = s.getBoolean("First Aid");//Assigns the current Admin Boolean indicating if the admin does or does not oversee first aid
           AdminArr[size] = new Admin(n,name,surName, catering, photography, AV, firstAid); //Assigns all the details of the current admin to the object array in the next position
           size++; //Incriments size by 1
        }
        for(int j =0; j < size; j++) //Loops through the array
        {
            if((AdminArr[j].getID()) == i) //checks if the current element in the array has the same ID value as the imputted value
            {
                i = j;
                temp = temp + "Name: " + AdminArr[i].getAdminName() + " " + AdminArr[i].getAdminSurname() + "\t\tAdmin ID: " + AdminArr[i].getID() + "\nPortfolios: ";
                if(AdminArr[i].isCatering()) //If the admin oversees catering, 'catering' is added to the string
                {
                    temp = temp + "Catering\t";//adds 'catering' to the string
                }
                if(AdminArr[i].isAv()) //If the admin oversees AV, 'AV' is added to the string
                {
                    temp = temp + "AV\t";//adds 'AV' to the string
                }
                if(AdminArr[i].isPhotography()) //If the admin oversees photography, 'photography' is added to the string
                {
                    temp = temp + "Photography\t";//adds 'photography' to the string
                }
                if(AdminArr[i].isFirstAid()) //If the admin oversees first aid, 'first aid' is added to the string
                {
                    temp = temp + "First Aid\t";//adds 'first aid' to the string
                }
            }
        }
        return temp; //Returns the string containing all of the Admin's formatted details
    }
    
    public String toString() //To String method returns all Admins in the array
    {
        String temp = "";
        for(int i = 0; i < size; i++)
        {
            temp = temp + AdminArr[i].toString() + "\n";
        }
        return temp;
    }
}
