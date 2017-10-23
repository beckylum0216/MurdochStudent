/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 * @title Student Record System
 * @filename Person.java
 * @purpose This class is the object class that contains the person
 * object. Contains all the associated validation methods.
 * @assumptions 
 * @author Rebecca Lim
 */
public class Person {
    private String title;
    private  String firstName;
    private String lastName;
    private DOB studentDOB;

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public DOB getStudentDOB() {
        return studentDOB;
    }

    /**
     *
     * @param studentDOB
     */
    public void setStudentDOB(DOB studentDOB) {
        this.studentDOB = studentDOB;
    }
    
    /**
     *
     * @return
     */
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
