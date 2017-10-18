/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 * @title Student Record System
 * @filename DOB.java
 * @purpose This class is the object class that contains the person
 * object. Contains all the associated validation methods 
 * @assumptions 
 * @author Rebecca Lim
 */
public class Person {
    private String title;
    private  String firstName;
    private String lastName;
    private DOB studentDOB;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DOB getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(DOB studentDOB) {
        this.studentDOB = studentDOB;
    }
    
    public boolean isValidTitle()
    {
        boolean theFlag = false;
        
        if((this.title.compareTo("Mr") == 0) 
                || (this.title.compareTo("Mrs") == 0) 
                || (this.title.compareTo("Ms")== 0))
        {
            theFlag = true;
        }
        
        return theFlag;
    }
    
}
