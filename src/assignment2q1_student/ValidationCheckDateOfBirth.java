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
     * This class checks if the date of birth of the student is valid.
     * @param inputStudent
     * @return theFlag
     * @throws BadDetailsException 
     */
    
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        
        boolean theFlag = false;
        
        if(!inputStudent.getStudentDOB().isValidDate())
        {
            theFlag = true;
            System.out.println("The date of birth is invalid");
            throw new BadDetailsException("The date of birth is invalid");
            
        }
       
        return theFlag;
        
    }
}
