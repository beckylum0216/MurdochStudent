/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rebecca
 */
public class ValidationCheckEmptyID implements ValidStudent{
    
    /**
     * This method checks if the student number field has is an empty field and 
     * returns a boolean to flag this error.
     * @param inputStudent
     * @return
     * @throws BadDetailsException
     */
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        boolean theFlag = true;
        if(inputStudent.isIDZero())
        {
            theFlag = false;
            System.out.println("You didn't enter anything. Please enter something.");
            throw new BadDetailsException("You didn't enter anything. "
                    + "Please enter something");
           
        }
        
        return !theFlag;
        
    }
}
