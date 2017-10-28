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
public class ValidationCheckLastName implements ValidStudent{
    
    /**
     * This method validates the first name field against a regex string for 
     * any inputs that is not accpeted by the regex rule.
     * @param inputStudent
     * @return
     * @throws BadDetailsException
     */
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        boolean theFlag = true;
        String theRegx = "^[a-zA-Z]*$";
        Pattern thePattern = Pattern.compile(theRegx,Pattern.CASE_INSENSITIVE);
        Matcher theMatcher = thePattern.matcher(inputStudent.getLastName());
        
        if(!theMatcher.find())
        {
            theFlag = false;
            System.out.println("Please enter a name that contains "
                    + "[A to z or a to z]");
            throw new BadDetailsException("Please enter a name that contains "
                    + "[A to z or a to z]");
        }
        
        return !theFlag;
    }
}
