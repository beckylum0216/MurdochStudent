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
public class ValidationCheckEmptyLastName implements ValidStudent{
    
    /**
     * This method checks if the last name field has is an empty field and 
     * returns a boolean to flag this error.
     * @param inputStudent
     * @return
     * @throws BadDetailsException
     */
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        boolean theFlag = true;
        
        if(inputStudent.getLastName().isEmpty())
        {
            theFlag = false;
            System.out.println("You didn't enter anything. Please enter something.");
            throw new BadDetailsException("You didn't enter anything. "
                    + "Please enter something");
        }
            
        return !theFlag;
        
    }
}
