/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

import static assignment2q1_student.Assignment2Q1_Student.initStudentTests;
import static assignment2q1_student.Assignment2Q1_Student.push;
import static assignment2q1_student.Assignment2Q1_Student.theKB;

/**
 *
 * @author rebecca
 */
public class SignUpStudent {
    
    private boolean zFlag0;
    private boolean zFlag1;
    private Student newStudent;  
    private ValidStudent[] testStudent; 
    
    public SignUpStudent()
    {
        newStudent = new Student();
        testStudent = initStudentTests();   
    }
    
    public Student addStudentDetails(String zField)
    {
        do
        {
            try
            {
                 
                this.zFlag0 = true;
                this.zFlag1 = true;
                
                if(zField == "Title")
                {
                    this.addStudentTitle();
                    this.zFlag0 = this.testStudent[0].isValid(newStudent);
                    this.zFlag1 = this.testStudent[1].isValid(newStudent);
                }
                else if(zField == "FirstName")
                {
                    this.addStudentFirstName();
                    this.zFlag0 = this.testStudent[2].isValid(newStudent);
                    this.zFlag1 = this.testStudent[3].isValid(newStudent);
                }
                else if(zField == "LastName")
                {
                    this.addStudentLastName();
                    this.zFlag0 = this.testStudent[4].isValid(newStudent);
                    this.zFlag1 = this.testStudent[5].isValid(newStudent);
                }
                else if(zField == "StudentNumber")
                {
                    this.addStudentNumber();
                    this.zFlag0 = this.testStudent[6].isValid(newStudent);
                    this.zFlag1 = this.testStudent[7].isValid(newStudent);
                }
                else if(zField == "DOB")
                {
                    this.addStudentDOB();
                    this.zFlag0 = this.testStudent[8].isValid(newStudent);
                    this.zFlag1 = this.testStudent[9].isValid(newStudent);
                }
                else if(zField == "Marks")
                {
                    this.addStudentMarks();
                    this.zFlag0 = this.testStudent[10].isValid(newStudent);
                    this.zFlag1 = this.testStudent[11].isValid(newStudent);
                }
                else if(zField == "Duplicates")
                {
                    this.zFlag0  = this.testStudent[12].isValid(newStudent);
                    this.zFlag1 = false;
                    if(!this.zFlag0)
                    {
                        this.newStudent.setOverallMark(newStudent.weightedAverage());
                        this.newStudent.setTheGrade(newStudent
                            .printFinalMark(newStudent.getOverallMark()));
                       
                    }
                }
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }/*
            catch(Exception e)
            {
                System.out.println(e);
            }*/
        }while(zFlag0 || zFlag1);
        
        return newStudent;
    }
    
    public void addStudentTitle()
    {
        System.out.println("Please enter title.");
        this.newStudent.setTitle(theKB.nextLine());
    }
    
    public void addStudentFirstName()
    {
        System.out.println("Please enter firstname.");       
        this.newStudent.setFirstName(theKB.nextLine());      
    }
    
    public void addStudentLastName()
    {
        System.out.println("Please enter the surname");
        this.newStudent.setLastName(theKB.nextLine());        
    }
    
    public void addStudentNumber()
    {
        System.out.println("Please enter the student number");
        this.newStudent.setStudentID(Long.parseLong(theKB.nextLine()));
      
    }
    
    public void addStudentDOB()
    {
        int zDay;
        int zMonth;
        int zYear;
        
        System.out.println("Please enter the date of birth");
        System.out.println("Please enter the day:");
        zDay = Integer.parseInt(theKB.nextLine());
        System.out.println("Please enter the month:");
        zMonth = Integer.parseInt(theKB.nextLine());
        System.out.println("Please enter the year");
        zYear = Integer.parseInt(theKB.nextLine());
        DOB tempDate = new DOB(zDay, zMonth, zYear);
        this.newStudent.setStudentDOB(tempDate);
      
    }
    
    public void addStudentMarks()
    {
        System.out.println("Please enter the mark for assignment 1");
        this.newStudent.setAssignmentOne(theKB.nextDouble());
        System.out.println("Please enter the mark for assignment 2");
        this.newStudent.setAssignmentTwo(theKB.nextDouble());
        System.out.println("Please enter the mark for the practical "
                + "[out of 10]");
        this.newStudent.setPracWork(theKB.nextDouble());
        System.out.println("Please enter the mark for the exam.");
        this.newStudent.setExamMark(theKB.nextDouble());
        theKB.nextLine();
        
        
    }

    public Student getNewStudent() {
        return newStudent;
    }
    
    
            
}
