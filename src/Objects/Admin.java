/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * Store details of an Admin
 * @author ruth2
 */
public class Admin {//Class Name 
    //Components 
    private int ID; //Admin ID
    private String adminName; //Admin first name
    private String adminSurname; //Admin surname
    private boolean photography; // Boolean to check if the admin oversees Photography
    private boolean catering; //Boolean to check if the admin oversees Catering
    private boolean firstAid; //Boolean to check if the admin oversees FirstAid 
    private boolean av; //Boolean to check if the admin oversees AV

    //Constructor Method

    /**
     * Parameterized constructor to assign default values to an admin
     * @param ID integer ID of the Admin
     * @param adminName String first name of the Admin
     * @param adminSurname String surname of the Admin
     * @param catering Boolean to check if the admin oversees catering
     * @param photography Boolean to check if the admin oversees photography
     * @param av Boolean to check if the admin oversees AV
     * @param firstAid Boolean to check if the admin oversees FirstAid 
     */
    public Admin(int ID, String adminName, String adminSurname, boolean catering, boolean photography, boolean av, boolean firstAid) 
    {
        this.ID = ID; //Assigns imput value to the variable
        this.adminName = adminName; //Assigns imput value to the variable
        this.adminSurname = adminSurname; //Assigns imput value to the variable
        this.photography = photography; //Assigns imput value to the variable
        this.catering = catering; //Assigns imput value to the variable
        this.firstAid = firstAid; //Assigns imput value to the variable
        this.av = av; //Assigns imput value to the variable
    }

    //Accessor and Mutator Methods

    /**
     * getter method for Admin ID
     * @return the Admin ID as an integer
     */
    public int getID() 
    {
        return ID;//Returns Admin ID
    }

    /**
     * getter method for Admin first name
     * @return the Admins first name as a String 
     */
    public String getAdminName() 
    {
        return adminName; //Returns the admin first name
    }

    /**
     * getter method for admin surname
     * @return the admins surname as a String 
     */
    public String getAdminSurname() 
    {
        return adminSurname; //Returns the admin surname
    }

    /**
     * getter method for Boolean photography
     * @return a Boolean to check if the admin oversees photography
     */
    public boolean isPhotography() 
    {
        return photography; //Returns the Boolean to check if the admin oversees photography
    }

    /**
     * getter method for Boolean Catering
     * @return a Boolean to check if the admin oversees catering
     */
    public boolean isCatering() 
    {
        return catering;//Returns the Boolean to check if the admin oversees Catering
    }

    /**
     * getter method for Boolean FirstAid
     * @return a Boolean to check if the admin oversees first aid
     */
    public boolean isFirstAid() 
    {
        return firstAid; //Returns the Boolean to check if the admin oversees FirstAid 
    }

    /**
     * getter method for Boolean AV
     * @return a Boolean to check if the admin oversees AV
     */
    public boolean isAv() 
    {
        return av; //Returns the Boolean to check if the admin oversees AV
    }

    @Override
    //toString Method
    public String toString() //Returns all the details of an admin as a formatted string
    {
        return "Admin{" + "ID=" + ID + ", adminName=" + adminName + ", adminSurname=" + adminSurname + ", photography=" + photography + ", catering=" + catering + ", firstAid=" + firstAid + ", av=" + av + '}';
    }
}
