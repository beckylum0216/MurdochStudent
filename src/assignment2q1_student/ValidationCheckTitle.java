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
public class ValidationCheckTitle implements ValidStudent{
    
    @Override
    public boolean isValid(Student inputStudent)throws BadDetailsException
    {
        boolean theFlag = true;
        String theRegx = "[a-zA-Z]";
        Pattern thePattern = Pattern.compile(theRegx,Pattern.CASE_INSENSITIVE);
        Matcher theMatcher = thePattern.matcher(inputStudent.getTitle());
        
        if(!theMatcher.find())
        {
            theFlag = false;
            throw new BadDetailsException("Please enter a title that contains "
                    + "[A to z or a to z]");
        }
        
        if(!inputStudent.isValidTitle())
        {
            theFlag = false;
            throw new BadDetailsException("Please enter a title that contains "
                    + "[Mr/Mrs/Ms]");
        }
        
        return !theFlag;
        
    }
}