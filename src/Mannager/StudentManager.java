/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mannager;

import Objects.DBService;
import Objects.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 * Manage an array of student objects
 * @author ruth2
 */
public class StudentManager {//Class Name
    //Components
    private int size = 0; //Stores the size of the array
    DBService d = new DBService(); //Creates a connection to the database
    private Student[] StudentArr = new Student[1000];//Creates an array to store up to 1000 Student objects
    DefaultTableModel model = new DefaultTableModel(); //sets the table moddle to the default settings
    
    

    /**
     * adds a new Student object to the database and the array
     * @param fn String value of the student name
     * @param sn String value of the student surname
     * @param g Integer value of the student grade
     * @param c Integer value of the student class
     * @param gen character value of the student gender (M/F)
     * @param ca the Boolean indicating if the student does or does not do catering
     * @param p the Boolean indicating if the student does or does not do photography
     * @param a the Boolean indicating if the student does or does not do AV
     * @param f the Boolean indicating if the student does or does not do First Aid
     * @throws SQLException
     */
    public void add(String fn, String sn, int g, int c, char gen, boolean ca, boolean p, boolean a, boolean f) throws SQLException//recives all the details of a student object except the auto generated StudentID
    {
        int x = size -1; //Sets x which will be used to allocate the place in the array where the new record will be stored
        int num = (StudentArr[x].getStuID()) + 1; //Finds the last ID in the array and sets the value of num one higher
        size++; //Increases size by 1
        StudentArr[size] = new Student(num,fn,sn,g,c,gen,ca,p,a,f);//adds new Student to the Array
        insertStudent(StudentArr[size]);//calls insert student method to add the student to the databse
    }
    
    /**
     * Assigns values to each student object and adds them to the array
     * @throws SQLException
     */
    public StudentManager() throws SQLException
    {
        String sql = "SELECT * FROM tblStudents;";   //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql); //Puts the results of the query into a result set
        while(s.next()) //checks through each element of the result set
        {
           int n = s.getInt("StudentID"); //Assigns the current student ID to n
           String name = s.getString("FirstName");//Assigns the current student first name to name
           String surName = s.getString("Surname");//Assigns the current student surname to surName
           int grade = s.getInt("Grade");//Assigns the current student grade to grade
           int classPoint = s.getInt("Class");//Assigns the current student class to classPoint
           char g = (s.getString("Gender")).charAt(0);//Assigns the current student gender to g
           boolean catering = s.getBoolean("Catering");//Assigns the current student Boolean indicating if the student does or does not do catering
           boolean photography = s.getBoolean("Photography");//Assigns the current student Boolean indicating if the student does or does not do photography
           boolean AV = s.getBoolean("AV");//Assigns the current student Boolean indicating if the student does or does not do AV
           boolean firstAid = s.getBoolean("FirstAid");//Assigns the current student Boolean indicating if the student does or does not do first aid
           StudentArr[size] = new Student(n,name,surName,grade,classPoint, g, catering, photography, AV, firstAid); //Assigns all the details of the current student to the object array in the next position
           size++; //incriments size by 1
        }
    }
    
    /**
     * Receives a position from which elements will be moved to the left within the array, can be used to remove an element from the array
     * @param pos integer value of the students position in the array
     */
    public void shiftLeft(int pos) 
    {
        pos--; //moves to the eliment before the position received
        for (int i = pos; i < size -1; i++) //Loops from position to the end of the array
        {
           StudentArr[i] = StudentArr[i +1];//moves each element one forward
        }
        size--; //Decreases size by 1 to accomidate for the removed element
    }
    
    /**
     * Returns the ID of the last student in the array
     * @return the integer value of the ID belonging to the last student in the array
     */
    public int getLast()
    {
        return StudentArr[size].getStuID();//returns the ID of the element in the array
    }

    /**
     * Receives a student object and creates a query with all relevant details to enter it into the database
     * @param f Student object containing all the students information
     * @throws SQLException
     */
    public void insertStudent(Student f) throws SQLException
    {
        String sql = "INSERT INTO tblStudents([firstName], [Surname], [Grade], [Class], [Gender], [Catering], [Photography], [AV], [FirstAid]) VALUES ('" 
            + f.getStuName() + "','" + f.getStuSurname() + "','" + f.getGrade() + "','" + f.getClassPoint() + "','"  + f.getGender() + "','" + f.isCatering() + "','" 
            + f.isPhotography() + "','" + f.isAv() + "','" + f.isFirstAid()+"');"; //SQL query to insert a student into the database
        try
        {
            d.updateQuery(sql); //Executes the query
        }
        catch(SQLException e)
        {
            System.out.println("Insert error: Could not insert Student");
        }      
    }
    
    /**
     * Returns the size of the array
     * @return the size of the array/ number of students in the array
     */
    public int getSize()
    {
        return size;//Returns the size of the array
    }
    
    /**
     * Returns a string containing all the details of the student with student ID equal to i
     * @param i the integer value of the Student ID
     * @return all the formatted details of the student as a String
     * @throws SQLException
     */
    public String getCurrent(int i) throws SQLException 
    {
        //Components
        String temp = "";
        int c =0; //holds the number of catering hours
        int p = 0;//holds the number of photography hours
        int a = 0;//holds the number of AV hours
        int f = 0;//holds the number of First Aid hours
        String sql = "SELECT * FROM tblStudents;";   //Select all from database and initialize the array with returned values from the database
        ResultSet s = d.queryDatabase(sql);
        size = 0; //Sets size back to 0
        while(s.next()) //checks through each element of the result set
        {
           int n = s.getInt("StudentID"); //Assigns the current student ID to n
           String name = s.getString("FirstName");//Assigns the current student first name to name
           String surName = s.getString("Surname");//Assigns the current student surname to surName
           int grade = s.getInt("Grade");//Assigns the current student grade to grade
           int classPoint = s.getInt("Class");//Assigns the current student class to classPoint
           char g = (s.getString("Gender")).charAt(0);//Assigns the current student gender to g
           boolean catering = s.getBoolean("Catering");//Assigns the current student Boolean indicating if the student does or does not do catering
           boolean photography = s.getBoolean("Photography");//Assigns the current student Boolean indicating if the student does or does not do photography
           boolean AV = s.getBoolean("AV");//Assigns the current student Boolean indicating if the student does or does not do AV
           boolean firstAid = s.getBoolean("FirstAid");//Assigns the current student Boolean indicating if the student does or does not do first aid
           StudentArr[size] = new Student(n,name,surName,grade,classPoint, g, catering, photography, AV, firstAid); //Assigns all the details of the current student to the object array in the next position
           size++; //incriments size by 1
        }
        for(int j =0; j < size; j++) //Loops through the array
        {
            if((StudentArr[j].getStuID()) == i)//checks if the current element in the array has the same ID value as the imputted value
            {
                ResultSet ch = d.queryDatabase("SELECT tblStudents.StudentID, SUM(tblEvents.hours) AS CateringHours\n" +
                "FROM tblStudents, tblEvents, tblParticipation\n" +
                "WHERE tblParticipation.StudentID = " + i + " And " + i + " = tblStudents.StudentID AND tblEvents.EventID = tblParticipation.EventID AND tblEvents.Catering = True\n" +
                "GROUP BY tblStudents.StudentID;"); //Selects the total number of catering hours
                ResultSet ph = d.queryDatabase("SELECT tblStudents.StudentID, SUM(tblEvents.hours) AS PhotographyHours\n" +
                "FROM tblStudents, tblEvents, tblParticipation\n" +
                "WHERE tblParticipation.StudentID = " + i + " And " + i + " = tblStudents.StudentID AND tblEvents.EventID = tblParticipation.EventID AND tblEvents.Photography = True\n" +
                "GROUP BY tblStudents.StudentID;");//Selects the total number of Photography hours
                ResultSet avh = d.queryDatabase("SELECT tblStudents.StudentID, SUM(tblEvents.hours) AS AVHours\n" +
                "FROM tblStudents, tblEvents, tblParticipation\n" +
                "WHERE tblParticipation.StudentID = " + i + " And " + i + " = tblStudents.StudentID AND tblEvents.EventID = tblParticipation.EventID AND tblEvents.AV = True\n" +
                "GROUP BY tblStudents.StudentID;");//Selects the total number of AV hours
                ResultSet fh = d.queryDatabase("SELECT tblStudents.StudentID, SUM(tblEvents.hours) AS FirstAidHours\n" +
                "FROM tblStudents, tblEvents, tblParticipation\n" +
                "WHERE tblParticipation.StudentID = " + i + " And " + i + " = tblStudents.StudentID AND tblEvents.EventID = tblParticipation.EventID AND tblEvents.FirstAid = True\n" +
                "GROUP BY tblStudents.StudentID;");//Selects the total number of First Aid hours
                i = j;
                temp = temp + "Name: " + StudentArr[i].getStuName() + " " + StudentArr[i].getStuSurname() + "\t\tStudent ID: " + StudentArr[i].getStuID() + "\nGrade: ";
                temp = temp + StudentArr[i].getGrade() + "." + StudentArr[i].getClassPoint() + "\t\tGender: " + StudentArr[i].getGender() + "\nPortfolios: "; // formats the Student details
                if(StudentArr[i].isCatering()) //If the student does catering, the total number of catering hours is added to the string
                {
                    temp = temp + "Catering "; //Adds 'catering' to the string
                    while(ch.next())
                    {
                        c = ch.getInt("CateringHours");//Assigns the total number of catering hours to c                    
                        temp = temp + "-" + c; //Adds the number of catering hours to the string
                    }      
                    temp = temp + "\t";
                }
                if(StudentArr[i].isAv()) //If the student does AV, the total number of AV hours is added to the string
                {
                    temp = temp + "AV "; //Adds 'AV' to the string
                    while(avh.next())
                    {
                        a = avh.getInt("AVHours");//Assigns the total number of AV hours hours to a     
                        temp = temp + "-" + a; //Adds the number of av hours to the string
                    }
                    temp = temp + "\t";
                }
                if(StudentArr[i].isPhotography()) //If the student does photography, the total number of photography hours is added to the string
                {
                    temp = temp + "Photography "; //Adds 'photography' to the string
                    while(ph.next())
                    {
                        p = ph.getInt("PhotographyHours"); //Assigns the total number of photography hours to p      
                        temp = temp + "-" + p; //Adds the number of photography hours to the string
                    }
                    temp = temp + "\t";
                }
                if(StudentArr[i].isFirstAid()) //If the student does FirstAid, the total number of FirstAid hours is added to the string
                {
                    temp = temp + "First Aid "; //Adds 'first aid' to the string
                    while(fh.next())
                    {
                        f= fh.getInt("FirstAidHours");//Assigns the total number of first aid hours to f      
                        temp = temp + "-" + f; //Adds the number of first aid hours to the string
                    }
                    temp = temp + "\t";
                }
            }  
        }
        return temp; //Returns the string containing all of the student's formatted details
    }
   
    /**
     * checks if the current Student(position in database at i) participates in the portfolio specified by the string
     * @param c the String name of the portfolio to be checked
     * @param i the Integer value of the student ID
     * @return false if no match was found, returns true if the Admin does oversee the specified portfolio
     */
    public boolean getPortfolio(String c, int i)
    {
        boolean test = false;    
        for(int j =0; j < size; j++)//loops through all studetents in the array
        {
            if((StudentArr[j].getStuID()) == i)//checks each Student ID aginst i
            {
                if(c.equalsIgnoreCase("Catering") && StudentArr[j].isCatering())//checks if the string entered is catering and if the current student does catering
                {
                    test = true;
                }
                else if (c.equalsIgnoreCase("Photography") && StudentArr[j].isPhotography())//checks if the string entered is photography and if the current student does photography
                {
                    test = true;
                }
                else if (c.equalsIgnoreCase("av") && StudentArr[j].isAv())//checks if the string entered is AV and if the current student does AV
                {
                    test = true;
                }
                else if (c.equalsIgnoreCase("First Aid") && StudentArr[j].isFirstAid())//checks if the string entered is First Aid and if the current student does First Aid
                {
                    test = true;
                }
            }
        }
        return test; //Returns false if no match was found, returns true if the student does participate in the specified portfolio
    }
       
    public String toString() //To String method returns all Students in the array
    {
        String temp = "";
        for(int i = 0; i < size; i++)
        {
            temp = temp + StudentArr[i].toString() + "\n";
        }
        return temp;
    }
    
}

