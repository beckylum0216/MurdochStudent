
package assignment2q1_student;

import static assignment2q1_student.Assignment2Q1_Student.initStudentTests;
import static assignment2q1_student.Assignment2Q1_Student.push;
import static assignment2q1_student.Assignment2Q1_Student.theKB;
/**
 * @title Student Record System
 * @filename SignUpStudent.java
 * @purpose This class is the object class that will collate and collect the
 * student details that is to be entered into the system.
 * @assumptions the inputs will only take in strings and doubles and do error 
 * checking on the input
 * @author Rebecca Lim
 */
public class SignUpStudent {
    
    private boolean zFlag0;
    private boolean zFlag1;
    private Student tempStudent;  
    private Student newStudent;
    private ValidStudent[] testStudent; 
    
    /**
     * Constructor fo SignUpStudent. Initialises the Student object and the 
     * tests that is used to validate the student object.
     */
    public SignUpStudent()
    {
        
        tempStudent = new Student();
        testStudent = initStudentTests();   
    }
    
    /**
     * This method is the allows the application to add student individually.
     * @param zField
     * @return Student object with all the student details.
     */
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
                    this.zFlag0 = this.testStudent[0].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[1].isValid(tempStudent);
                }
                else if(zField == "FirstName")
                {
                    this.addStudentFirstName();
                    this.zFlag0 = this.testStudent[2].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[3].isValid(tempStudent);
                }
                else if(zField == "LastName")
                {
                    this.addStudentLastName();
                    this.zFlag0 = this.testStudent[4].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[5].isValid(tempStudent);
                }
                else if(zField == "StudentNumber")
                {
                    this.addStudentNumber();
                    this.zFlag0 = this.testStudent[6].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[7].isValid(tempStudent);
                }
                else if(zField == "DOB")
                {
                    this.addStudentDOB();
                    this.zFlag0 = this.testStudent[8].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[9].isValid(tempStudent);
                }
                else if(zField == "Marks")
                {
                    this.addStudentMarks();
                    this.zFlag0 = this.testStudent[10].isValid(tempStudent);
                    this.zFlag1 = this.testStudent[11].isValid(tempStudent);
                }
                else if(zField == "Duplicates")
                {
                    this.zFlag0  = this.testStudent[12].isValid(tempStudent);
                    this.zFlag1 = false;
                    /*
                    if(!this.zFlag0)
                    {
                        this.newStudent.setOverallMark(newStudent.weightedAverage());
                        this.newStudent.setTheGrade(newStudent
                            .printFinalMark(newStudent.getOverallMark()));
                       
                    }*/
                }
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }while(zFlag0 || zFlag1);
        
        return tempStudent;
    }
    
    /**
     * This method allows the program to read the title into the object
     */
    public void addStudentTitle()
    {
        System.out.println("Please enter title.");
        this.tempStudent.setTitle(theKB.nextLine().toLowerCase());
    }
    
    /**
     * This method allows the program to read the first name into the object
     */
    public void addStudentFirstName()
    {
        System.out.println("Please enter firstname.");       
        this.tempStudent.setFirstName(theKB.nextLine().trim());      
    }
    
    /**
     * This method allows the programs to read the last name into the object
     */
    public void addStudentLastName()
    {
        System.out.println("Please enter the surname");
        this.tempStudent.setLastName(theKB.nextLine().trim());        
    }
    
    /**
     * This method allows the program to read the Student Number into the object
     */
    public void addStudentNumber()
    {
        System.out.println("Please enter the student number");
        this.tempStudent.setStudentID(Long.parseLong(theKB.nextLine().trim()));
      
    }
    
    /**
     * This method allows the program to read the DOB into the student object
     */
    public void addStudentDOB()
    {
        int zDay;
        int zMonth;
        int zYear;
        
        System.out.println("Please enter the date of birth");
        System.out.println("Please enter the day:");
        zDay = Integer.parseInt(theKB.nextLine().trim());
        System.out.println("Please enter the month:");
        zMonth = Integer.parseInt(theKB.nextLine().trim());
        System.out.println("Please enter the year");
        zYear = Integer.parseInt(theKB.nextLine().trim());
        DOB tempDate = new DOB(zDay, zMonth, zYear);
        this.tempStudent.setStudentDOB(tempDate);
      
    }
    
    /**
     * This method allows the application to record the marks into the object
     */
    public void addStudentMarks()
    {
        System.out.println("Please enter the mark for assignment 1");
        this.tempStudent
                .setAssignmentOne(Double.parseDouble(theKB.nextLine().trim()));
        System.out.println("Please enter the mark for assignment 2");
        this.tempStudent
                .setAssignmentTwo(Double.parseDouble(theKB.nextLine().trim()));
        System.out.println("Please enter the mark for the practical "
                + "[out of 10]");
        this.tempStudent
                .setPracWork(Double.parseDouble(theKB.nextLine().trim()));
        System.out.println("Please enter the mark for the exam.");
        this.tempStudent
                .setExamMark(Double.parseDouble(theKB.nextLine().trim()));

        
        
    }

    /**
     *
     * @return
     */
    public Student getNewStudent() {
        return newStudent = new Student(tempStudent.getTitle(), 
                tempStudent.getFirstName(), tempStudent.getLastName(), 
                tempStudent.getStudentDOB(), tempStudent.getStudentID(), 
                tempStudent.getAssignmentOne(), tempStudent.getAssignmentTwo(), 
                tempStudent.getPracWork(), tempStudent.getExamMark());
    }
    
    
            
}
