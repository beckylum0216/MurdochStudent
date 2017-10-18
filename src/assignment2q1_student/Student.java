/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 *
 * @author rebecca
 */
public class Student extends Person {
    
    private long studentID;
    private double assignmentOne;
    private double assignmentTwo;
    private double pracWork;
    private double examMark;
    private double overallMark;
    private String theGrade;
    
    public Student()
    {
        this.setTitle(null);
        this.setFirstName(null);
        this.setLastName(null);
        this.setStudentDOB(new DOB());
        this.studentID = -1;
        this.assignmentOne = -1;
        this.assignmentTwo = -1;
        this.pracWork = -1;
        this.examMark = -1;
        this.overallMark = -1;
        this.theGrade = null;
    }
    
    public Student(String inputTitle, String inputFirstName, String inputLastName, 
            DOB inputDOB, long inputID, double inputAssignmentOne, 
            double inputAssignmentTwo, double inputPrac, double inputExam)
    {
        this.setTitle(inputTitle);
        this.setFirstName(inputFirstName);
        this.setLastName(inputLastName);
        this.setStudentDOB(inputDOB);
        this.setStudentID(inputID);
        this.setAssignmentOne(inputAssignmentOne);
        this.setAssignmentTwo(inputAssignmentTwo);
        this.setPracWork(inputPrac);
        this.setExamMark(inputExam);
        this.setOverallMark(weightedAverage());
        this.setTheGrade(printFinalMark(this.getOverallMark()));
        
    }
    
    public double weightedAverage()
    {

        double weightedPracWork = 0;
        double weightedAssignmentOne = 0; 
        double weightedAssignmentTwo = 0; 
        double weightedExam = 0;
        double finalMark = 0;
        
        weightedPracWork = this.pracWork;
        weightedAssignmentOne = 0.2 * this.assignmentOne;
        weightedAssignmentTwo = 0.2 * this.assignmentTwo;
        weightedExam = 0.5 * this.examMark;
        
        finalMark = weightedPracWork + weightedAssignmentOne 
                + weightedAssignmentTwo + weightedExam;
        
        return finalMark;
    }
    
    public String printFinalMark(double inputMark)
    {
        String finalResult = "";
        
        if (inputMark > 80.00)
        {
            finalResult = "HD";
        }
        else if (inputMark > 70)
        {
            finalResult = "D";
        }
        else if(inputMark > 60)
        {
            finalResult  = "C";
        }
        else if(inputMark > 50)
        {
            finalResult = "P";
        }
        else
        {
            finalResult = "N";
        }
            
        return finalResult;
    }

    public boolean isEqual(Student inputStudent)
    {
        boolean theFlag = false;
        if((this.getFirstName().equalsIgnoreCase(inputStudent.getFirstName()))
                &&(this.getLastName().equalsIgnoreCase(inputStudent.getLastName())) 
                  &&(this.getStudentDOB().isEqual(inputStudent.getStudentDOB()))
                        &&(this.getStudentID() == inputStudent.getStudentID()))
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    
    public boolean isIDZero()
    {
        boolean theFlag = false;
        
        if(this.getStudentID() == -1)
        {
            theFlag = true;
        }
        
        return theFlag;    
    }
    
    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public double getAssignmentOne() {
        return assignmentOne;
    }

    public void setAssignmentOne(double assignmentOne) {
        this.assignmentOne = assignmentOne;
    }

    public double getAssignmentTwo() {
        return assignmentTwo;
    }

    public void setAssignmentTwo(double assignmentTwo) {
        
        this.assignmentTwo = assignmentTwo;
    }
    
    public double getPracWork()
    {
        return pracWork;
    }

    public void setPracWork(double pracWork) {
        this.pracWork = pracWork;
    }

    public double getExamMark() {
        return examMark;
    }

    public void setExamMark(double examMark) {
        this.examMark = examMark;
    }

    public double getOverallMark() {
        return overallMark;
    }

    public void setOverallMark(double overallMark) {
        this.overallMark = overallMark;
    }

    public String getTheGrade() {
        return theGrade;
    }

    public void setTheGrade(String theGrade) {
        this.theGrade = theGrade;
    }
    
    
}
