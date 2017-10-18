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
public class ValidationCheckDuplicateStudent implements ValidStudent{
    
    /**
     * This method checks if the date of birth of 
     * @param inputStudent
     * @return theFlag
     * @throws BadDetailsException 
     */
    
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        
        boolean theFlag = false;
        
        for(int i = 0; i < Assignment2Q1_Student.theIndex+1; i++)
        {
            Student tempStudent = Assignment2Q1_Student.theStudent[i];
            
            if(tempStudent.isEqual(inputStudent))
            {
                theFlag = true;
                System.out.println("The student exists already!");
                throw new BadDetailsException("The student exists already");
            }
        }
        
        return theFlag;
        
    }
}
