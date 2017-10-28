/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 * @title Student Record System
 * @filename ValidStudent.java
 * @purpose This interface is the class that sets up the testing modules 
 * requirements
 * @assumptions the validations done via this interfaces would allow the program
 * to call it all at once or individually.
 * @author Rebecca Lim
 */
public interface ValidStudent {
    
    /**
     * This is the abstract method that is implemented by the subclasses to 
     * this interface.
     * @param studentData
     * @return
     * @throws BadDetailsException
     */
    public boolean isValid(Student studentData) throws BadDetailsException;
    
    
}
