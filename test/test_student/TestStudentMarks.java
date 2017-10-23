/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_student; 

import assignment2q1_student.Assignment2Q1_Student;
import assignment2q1_student.BadDetailsException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import assignment2q1_student.Student;
import assignment2q1_student.DOB; 


/**
 *
 * @author rebecca
 */
import assignment2q1_student.ValidStudent;
import assignment2q1_student.ValidationCheckDuplicateStudent;
import assignment2q1_student.ValidationCheckMarkRange;
public class TestStudentMarks {
    Student newStudent;
    
    public TestStudentMarks() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        DOB theDate = new DOB(06, 06, 1966);
        double thePrac = 5;
        newStudent = new Student("Ms", "Grace","Park", theDate, 12345678, 55,55,
                thePrac, 55);
    }
    
    @After
    public void tearDown() {
    }
    
  
    @Test
    public void testDuplicatesFile() {
        
        Assignment2Q1_Student.readStudent();
        ValidStudent theTesty = new ValidationCheckMarkRange();
        try
        {
             assertEquals("Result", false, theTesty.isValid(newStudent));
    
        }
        catch(BadDetailsException e)
        {
            System.out.println(e);
        }
    }
       
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
