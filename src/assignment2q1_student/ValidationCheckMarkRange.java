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
public class ValidationCheckMarkRange implements ValidStudent{
    
    /**
     *
     * @param inputStudent
     * @return
     * @throws BadDetailsException
     */
    @Override
    public boolean isValid(Student inputStudent) throws BadDetailsException
    {
        boolean theFlag = false;
        
        if(!(inputStudent.getAssignmentOne() >=0 
                && inputStudent.getAssignmentOne()<=  100))
        {
            theFlag = true;
            System.out.println("The assignment 1 mark is invalid");
            throw new BadDetailsException("The assignment 1 mark is invalid");
        }
        
        
        if(!(inputStudent.getAssignmentTwo() >= 0 
                && inputStudent.getAssignmentTwo() <=100))
        {
            theFlag = true;
            System.out.println("The assignment 2 mark is invalid");
            throw new BadDetailsException("The assignment 2 mark is invalid");
        }
        
        
        if(!(inputStudent.getPracWork() >= 0 && inputStudent.getPracWork() <= 10))
        {
            theFlag = true;
            System.out.println("The practical mark is invalid");
            throw new BadDetailsException("The practical mark is invalid");
        } 
        
         
        if(!(inputStudent.getExamMark() >= 0 && inputStudent.getExamMark() <= 100))
        {
            theFlag = true;
            System.out.println("The exam mark is invalid");
            
            throw new BadDetailsException("The exam mark is invalid");
        }
        
       
        return theFlag;
    }
}
