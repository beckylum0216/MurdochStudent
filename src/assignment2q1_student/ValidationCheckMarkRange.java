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
    public boolean isValid(Student inputStudent)/*throws BadDetailsException*/
    {
        boolean theFlag = true;
        
        if(inputStudent.getAssignmentOne() > 100 )
        {
            theFlag = false;
            System.out.println("The assignment 1 mark is invalid");
            //throw new BadDetailsException("The assignment 1 mark is invalid");
        }
        
        if(inputStudent.getAssignmentOne() < 0)
        {
            theFlag = false;
            System.out.println("The assignment 1 mark is invalid");
            //throw new BadDetailsException("The assignment 1 mark is invalid");
        }
        
        if(inputStudent.getAssignmentTwo() > 100 )
        {
            theFlag = false;
            System.out.println("The assignment 2 mark is invalid");
            //throw new BadDetailsException("The assignment 2 mark is invalid");
        }
        
        if(inputStudent.getAssignmentTwo() < 0)
        {
            theFlag = false;
            System.out.println("The assignment 2 mark is invalid");
            //throw new BadDetailsException("The assignment 2 mark is invalid");
        }
        
        for(int i = 0; i < inputStudent.getPracWork().length; i++)
        {
            if(inputStudent.getPracWork(i) > 100)
            {
                theFlag = false;
                System.out.println("The practical ["+i+"] mark is invalid");
                //throw new BadDetailsException("The practical mark ["+i+"] 
                //is invalid");
            } 
        }
        
        
        for(int i = 0; i < inputStudent.getPracWork().length; i++)
        {
            if( inputStudent.getPracWork(i) < 0)
            {
                theFlag = false;
                System.out.println("The practical "+i+" mark is invalid");
                //throw new BadDetailsException("The practical mark ["+i+"] 
                //is invalid");
            } 
        }
         
        if(inputStudent.getExamMark() > 100)
        {
            theFlag = false;
            System.out.println("The exam mark is invalid");
            
            //throw new BadDetailsException("The exam mark is invalid");
        }
        
        if( inputStudent.getExamMark()< 0  )
        {
            theFlag = false;
            System.out.println("The exam mark is invalid");
            //throw new BadDetailsException("The exam mark is invalid");
        }
        return !theFlag;
    }
}
