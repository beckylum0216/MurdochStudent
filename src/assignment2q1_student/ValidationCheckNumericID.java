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
public class ValidationCheckNumericID implements ValidStudent{
    
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        boolean theFlag = false;
        try  
        {  
            long theID = Long.parseLong(Long.toString(inputStudent.getStudentID()));  
        }  
        catch(NumberFormatException nfe)  
        {  
            theFlag = true;
            throw new BadDetailsException("The student number is invalid");
              
        }
        
        return theFlag; 
    }
}
