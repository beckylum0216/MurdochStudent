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
    
    @Override
    public boolean isValid(Student inputStudent)throws BadDetailsException
    {
        
        boolean theFlag = true;
        
        if(!inputStudent.getStudentDOB().isValidDate())
        {
            theFlag = false;
            throw new BadDetailsException("The date of birth is invalid");
            
        }
       
        return theFlag;
        
    }
}
