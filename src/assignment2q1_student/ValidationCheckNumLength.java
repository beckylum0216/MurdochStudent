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
public class ValidationCheckNumLength implements ValidStudent{
    
    /**
     * This method checks if the student number entered is the prescibed length
     * @param inputStudent
     * @return
     * @throws BadDetailsException
     */
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        
        boolean theFlag = true;
        int numLength = Long.valueOf(inputStudent.getStudentID()).toString().length();
        if(  numLength > 8)
        {
            theFlag = false;
            System.out.println("The student number is invalid");
            throw new BadDetailsException("The student number is invalid");
        }
        
        if(  numLength < 8)
        {
            theFlag = false;
            System.out.println("The student number is invalid");
            throw new BadDetailsException("The student number is invalid");
        }
        
        return !theFlag;
    }
}
