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
    
    @Override
    public boolean isValid(Student inputStudent)throws BadDetailsException
    {
        boolean theFlag = true;
        
        if(inputStudent.getAssignmentOne() > 100 && inputStudent.getAssignmentOne() < 0)
        {
            theFlag = false;
            throw new BadDetailsException("The assignment 1 mark is invalid");
        }
        
        if(inputStudent.getAssignmentTwo() > 100 && inputStudent.getAssignmentTwo() < 0)
        {
            theFlag = false;
            throw new BadDetailsException("The assignment 2 mark is invalid");
        }
        
        for(int i = 0; i < inputStudent.getPracWork().length; i++)
        {
            if(inputStudent.getPracWork(i) > 100 && inputStudent.getPracWork(i) < 0)
            {
                theFlag = false;
                throw new BadDetailsException("The practical mark ["+i+"] is invalid");
            } 
        }
        
        
        if(inputStudent.getExamMark() > 100 && inputStudent.getExamMark()< 0  )
        {
            theFlag = false;
            throw new BadDetailsException("The exam mark is invalid");
        }
        
        return theFlag;
    }
}
