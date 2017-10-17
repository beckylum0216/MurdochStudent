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
public class ValidationCheckDateOfBirth implements ValidStudent{
    
    /**
     * This method checks if the date of birth of 
     * @param inputStudent
     * @return theFlag
     * @throws BadDetailsException 
     */
    
    @Override
    public boolean isValid(Student inputStudent)/*throws BadDetailsException*/
    {
        
        boolean theFlag = true;
        
        if(!inputStudent.getStudentDOB().isValidDate())
        {
            theFlag = false;
            System.out.println("The date of birth is invalid");
            //throw new BadDetailsException("The date of birth is invalid");
            
        }
       
        return !theFlag;
        
    }
}
