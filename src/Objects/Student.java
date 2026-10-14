/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * Store Details of a Student
 * @author ruth2
 */
public class Student {//Class Name 
    //Components 
    private int stuID; //Student ID
    private String stuName; //Studnet First Name
    private String stuSurname; //Student surname
    private int grade; //Student grade (8-12)
    private int classPoint; //Student class (1-5)
    private char gender; //Student gender (M/F)
    private boolean catering; // the Boolean indicating if the student does or does not do catering
    private boolean photography; // the Boolean indicating if the student does or does not do photography
    private boolean av; // the Boolean indicating if the student does or does not do AV
    private boolean firstAid; //the Boolean indicating if the student does or does not do First Aid

    /**
     * Parameterized Constructor Method to assign values to a student
     * @param stuID the integer ID of the student
     * @param stuName the String first name of the student
     * @param stuSurname the String surname of the student
     * @param grade the integer grade of the student (8 to 12)
     * @param classPoint the integer class of the student (1 to 5)
     * @param gender the character gender of the student (M or F)
     * @param catering the Boolean indicating if the student does or does not do catering
     * @param photography the Boolean indicating if the student does or does not do photography
     * @param av the Boolean indicating if the student does or does not do AV
     * @param firstAid the Boolean indicating if the student does or does not do First Aid
     */
    public Student(int stuID, String stuName, String stuSurname, int grade, int classPoint, char gender, boolean catering, boolean photography, boolean av, boolean firstAid) 
    {
        this.stuID = stuID; //Assigns imput value to the variable
        this.stuName = stuName; //Assigns imput value to the variable
        this.stuSurname = stuSurname; //Assigns imput value to the variable
        this.grade = grade; //Assigns imput value to the variable
        this.classPoint = classPoint; //Assigns imput value to the variable
        this.gender = gender; //Assigns imput value to the variable
        this.catering = catering; //Assigns imput value to the variable
        this.photography = photography; //Assigns imput value to the variable
        this.av = av; //Assigns imput value to the variable
        this.firstAid = firstAid; //Assigns imput value to the variable
    }

    //Accessor and Mutator Methods
    /**
     * Getter method for the student ID
     * @return the Student ID as an integer
     */
    public int getStuID() 
    {
        return stuID; //Returns the Student ID
    }

    /**
     * Getter method for the student first name
     * @return the student's first name as a string
     */
    public String getStuName() 
    {
        return stuName; //Returns the Student First Name
    }

    /**
     * Getter method for the student surname
     * @return String value of the student surname
     */
    public String getStuSurname() 
    {
        return stuSurname; //Resturns the Student surname
    }

    /**
     * Getter method for the student grade
     * @return Integer value of the students grade
     */
    public int getGrade() 
    {
        return grade; //Returns the student grade
    }

    /**
     * Getter method for the students class
     * @return Integer value of the students class
     */
    public int getClassPoint() 
    {
        return classPoint; //Returns the students class
    }

    /**
     * Setter method for the students Class
     * @param classPoint receives the class of the learner
     */
    public void setClassPoint(int classPoint) 
    {
        this.classPoint = classPoint; //Assigns the imput value to the variable
    }

    /**
     * Getter method for the students gender
     * @return the character value of the students gender (M/F)
     */
    public char getGender() 
    {
        return gender; //Returns the students gender
    }

    /**
     * Setter method for the students gender
     * @param gender the character value of the gender
     */
    public void setGender(char gender) 
    {
        this.gender = gender; //Assigns the imput value to the variable
    }

    /**
     * Getter method for Boolean indicating if the student does or does not do catering
     * @return the Boolean indicating if the student does or does not do catering
     */
    public boolean isCatering() 
    {
        return catering;
    }

    /**
     * Setter method for the Boolean indicating if the student does or does not do catering
     * @param catering receives the Boolean indicating if the student does or does not do catering
     */
    public void setCatering(boolean catering) 
    {
        this.catering = catering; //Assigns the imput value to the variable
    }

    /**
     * Getter method for the Boolean indicating if the student does or does not do photography
     * @return the Boolean indicating if the student does or does not do photography
     */
    public boolean isPhotography() 
    {
        return photography; //Returns for the Boolean indicating if the student does or does not do photography
    }

    /**
     * Setter method for the Boolean indicating if the student does or does not do photography
     * @param photography receives the Boolean indicating if the student does or does not do photography
     */
    public void setPhotography(boolean photography) 
    {
        this.photography = photography;//Assigns  the imput value to the variable
    }

    /**
     * Getter method for the Boolean indicating if the student does or does not do AV
     * @return the Boolean indicating if the student does or does not do AV
     */
    public boolean isAv() 
    {
        return av; //Return the Boolean indicating if the student does or does not do AV
    }

    /**
     * Setter method for the Boolean indicating if the student does or does not do AV
     * @param av the Boolean indicating if the student does or does not do AV
     */
    public void setAv(boolean av) 
    {
        this.av = av; //Assigns the imput value to the variable
    }

    /**
     * Getter method for the Boolean indicating if the student does or does not do FirstAid
     * @return the Boolean indicating if the student does or does not do FirstAid
     */
    public boolean isFirstAid() 
    {
        return firstAid;//Returns the Boolean indicating if the student does or does not do FirstAid
    }

    /**
     * Setter method the Boolean indicating if the student does or does not do FirstAid
     * @param firstAid receives the Boolean indicating if the student does or does not do FirstAid
     */
    public void setFirstAid(boolean firstAid) 
    {
        this.firstAid = firstAid; //Assigns the imput value to the variable
    }

    @Override
    //toString Method
    public String toString() //Returns the values of the student as a formatted String
    {
        return "Student{" + "stuID=" + stuID + ", stuName=" + stuName + ", stuSurname=" + stuSurname + ", grade=" + grade + ", classPoint=" + classPoint + ", gender=" + gender + ", catering=" + catering + ", photography=" + photography + ", av=" + av + ", firstAid=" + firstAid + '}';
    }
}
