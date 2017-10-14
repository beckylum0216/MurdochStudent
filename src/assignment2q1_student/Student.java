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
    private double[] pracWork = new double[10];
    private double examMark;
    
    Student()
    {
        this.setTitle(null);
        this.setFirstName(null);
        this.setLastName(null);
        this.setStudentDOB(new DOB());
        this.studentID = 0;
        this.assignmentOne = 0;
        this.assignmentTwo = 0;
        initPrac();
        this.examMark = 0;  
    }
    
    Student(String inputTitle, String inputFirstName, String inputLastName, 
            DOB inputDOB, long inputID, double inputAssignmentOne, 
            double inputAssignmentTwo, double[] inputPrac, double inputExam)
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
        
    }
    
    private void initPrac()
    {
        for(int i = 0; i < pracWork.length; i+=1)
        {
            this.pracWork[i] = 0;
        }
    }
    
    public double weightedAverage()
    {
        double totPracMark = 0;
        double weightedPracWork = 0;
        double weightedAssignmentOne = 0; 
        double weightedAssignmentTwo = 0; 
        double weightedExam = 0;
        double finalMark = 0;
        for (int i = 0; i < this.pracWork.length; i++ )
        {
            totPracMark = totPracMark + this.pracWork[i];
        }
        
        weightedPracWork = totPracMark * 0.01;
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
        if((this.getFirstName().compareTo(inputStudent.getFirstName())== 0) &&
                (this.getLastName().compareTo(inputStudent.getLastName())== 0) &&
                    (this.getStudentDOB().isEqual(inputStudent.getStudentDOB())) &&
                        (this.studentID == inputStudent.studentID))
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
    
    public double[] getPracWork()
    {
        return pracWork;
    }

    public double getPracWork(int inputIndex ) {
        return pracWork[inputIndex];
    }

    public void setPracWork(double[] pracWork) {
        this.pracWork = pracWork;
    }
    
    public void setPracWork(int inputIndex, double inputMark)
    {
        this.pracWork[inputIndex] = inputMark;
    }

    public double getExamMark() {
        return examMark;
    }

    public void setExamMark(double examMark) {
        this.examMark = examMark;
    }
    
    public boolean isIDZero()
    {
        boolean theFlag = false;
        
        if(this.getStudentID() == 0)
        {
            theFlag = true;
        }
        
        return theFlag;    
    }
    
    
}
