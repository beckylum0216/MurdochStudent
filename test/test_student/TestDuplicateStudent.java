/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_student; 

import assignment2q1_student.Assignment2Q1_Student;
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
public class TestDuplicateStudent {
    
    public TestDuplicateStudent() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Student newStudent;
        DOB theDate = new DOB("06", "06", "1966");
        double[] thePrac = new double[10];
        thePrac[0] = 55;
        thePrac[1] = 55;
        thePrac[2] = 55;
        thePrac[3] = 55;
        thePrac[4] = 55;
        thePrac[5] = 55;
        thePrac[6] = 55;
        thePrac[7] = 55;
        thePrac[8] = 55;
        thePrac[9] = 55;
        newStudent = new Student("Ms", "Grace","Park", theDate, 12345678, 55,55,
                thePrac, 55);
        Student tempStudent  = newStudent;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDuplicatesException() {
        Student newStudent;
        DOB theDate = new DOB("06", "06", "1966");
        double[] thePrac = new double[10];
        for (int i = 0; i < thePrac.length; i++)
        {
            thePrac[i] = 55;
        }
        newStudent = new Student("Ms", "Grace","Park", theDate, 12345678, 55,55,
                thePrac, 55);
        Student tempStudent  = newStudent;
        
        assertEquals("Result", true, newStudent.isEqual(tempStudent));
        
    }
    
    @Test
    public void testDuplicatesValidation() {
        Student newStudent;
        DOB theDate = new DOB("06", "06", "1966");
        double[] thePrac = new double[10];
        for (int i = 0; i < thePrac.length; i++)
        {
            thePrac[i] = 55;
        }
        newStudent = new Student("Ms", "Grace","Park", theDate, 12345678, 55,55,
                thePrac, 55);
        Student tempStudent  = newStudent;
        Assignment2Q1_Student.push(newStudent);
        ValidStudent theTesty = new ValidationCheckDuplicateStudent();
        assertEquals("Result", true, theTesty.isValid(tempStudent));
        
    }
    
    @Test
    public void testDuplicatesFile() {
        Student newStudent;
        DOB theDate = new DOB("06", "06", "1966");
        double[] thePrac = new double[10];
        for (int i = 0; i < thePrac.length; i++)
        {
            thePrac[i] = 55;
        }
        newStudent = new Student("Ms", "Grace","Park", theDate, 12345678, 55,55,
                thePrac, 55);
        Student tempStudent  = newStudent;
        Assignment2Q1_Student.readStudent();
        ValidStudent theTesty = new ValidationCheckDuplicateStudent();
        assertEquals("Result", true, theTesty.isValid(tempStudent));
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
