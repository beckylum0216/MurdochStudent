/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 * @title Student Record System
 * @filename Assignment2Q1_Student.java
 * @purpose This class is the client class that contains the logic of the 
 * program
 * @assumptions the inputs will only take in strings and doubles and do error 
 * checking on the input
 * @author Rebecca Lim
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rebecca
 */
public class Assignment2Q1_Student {

    /**
     * @param args the command line arguments
     */
    
    static final int THE_NUMBER = 1024;
    static int theIndex = -1;
    public static Student[] theStudent = new Student[THE_NUMBER];
    static Scanner theKB = new Scanner(System.in);
        
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean theFlag = true;
       
        int theChoice;
        studentInfo();
       
        do
        {
            printMenu();
            theChoice = Integer.parseInt(theKB.nextLine());
            System.out.println();
            switch (theChoice)
            {
                case 0:
                    readStudent();
                    break; 
                case 1:
                    theFlag = exitProg();
                    break;
                case 2:
                    addRecord();
                    break;
                case 3:
                    printStudents();
                    break;
                case 4:
                    printMean();
                    break;
                case 5:
                    printPassFail();
                    break;
                case 6:
                    printDistribution();
                    break;
                case 7:
                    searchStudentID();
                    break;
                case 8:
                    searchStudentName();
                    break;
                case 9:
                    findFirstSecond(theStudent, theIndex+1);
                    break;
                case 10:
                    sSort(theStudent, theIndex+1);
                    printStudents();
                    break;
                case 11:
                    iSort(theStudent, theIndex+1);
                    printStudents();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
            
        }while(theFlag);
        
        System.out.println("Exiting...");
    }
    
    /**
     * Method prints out the assignment's student's details.
     */
    public static void studentInfo()
    {
        System.out.println("Name:               Rebecca Lim");
        System.out.println("Student Number:     33111264");
        System.out.println("Enrolement:         Internal");
        System.out.println("Tutor:              Mark Abernethy");
        System.out.println("Tutorial:           Thursday, 10.30am");
        System.out.println();
    }
    
    /**
     * This method shows the menu options available to the user.
     */
    public static void printMenu()
    {
        System.out.println("Menu");
        System.out.println("==============================================");
        System.out.println("1: Quit.");
        System.out.println("2: Press 2 to add student information.");
        System.out.println("3: Press 3 to display all student information.");
        System.out.println("4: Press 4 to calculate and display the average for "
                + "the class.");
        System.out.println("5: Press 5 to display students above or below "
                + "the average mark.");
        System.out.println("6: Press 6 to show the distribution of grades.");
        System.out.println("7: Press 7 to search for student by student ID.");
        System.out.println("8: Press 8 to search for student by name.");
        System.out.println("9: Press 9 to list first and second highest marks.");
        System.out.println("10: Press 10 to sort the class by name.");
        System.out.println("11: Press 11 to sort the class by student number.");
        
    }
    
    /**
     * This method allows the user to upload list of students that is stored in 
     * a text file.
     */
    public static void readStudent()
    {
        Path csvFile = Paths.get("src/assignment2q1_student/StudentData.csv");
        String theRecord = "";
        String csvSplit = ",";
        boolean theFlag = true;
        //Kludgy because it is not encapsulated in a class
        ValidStudent[] testStudent = new ValidStudent[13];
        testStudent[0] = new ValidationCheckEmptyTitle();
        testStudent[1] = new ValidationCheckTitle();
        testStudent[2] = new ValidationCheckEmptyFirstName();
        testStudent[3] = new ValidationCheckFirstName();
        testStudent[4] = new ValidationCheckEmptyLastName();
        testStudent[5] = new ValidationCheckLastName();
        testStudent[6] = new ValidationCheckEmptyID();
        testStudent[7] = new ValidationCheckNumLength();
        testStudent[8] = new ValidationCheckEmptyDOB();
        testStudent[9] = new ValidationCheckDateOfBirth();
        testStudent[10] = new ValidationCheckMarkRange();
        testStudent[11] = new ValidationCheckNumericID();
        testStudent[12] = new ValidationCheckDuplicateStudent();
        
        do
        {
            Student newStudent;
            try (BufferedReader theBR = Files.newBufferedReader(csvFile, 
                    StandardCharsets.UTF_8))
            {
                theBR.readLine();
                while ((theRecord = theBR.readLine()) != null)
                {
                    try
                    {
                        String[] theAttribute = theRecord.split(csvSplit);
                        newStudent = createStudentObj(theAttribute);
                        boolean theCheck = false;
                        for(int i = 0; i < testStudent.length; i++)
                        {
                            theCheck  = testStudent[i].isValid(newStudent);

                            if(theCheck)
                            {
                                break;
                            }
                        }

                        if(!theCheck)
                        {
                            System.out.println("The record is valid");
                            push(newStudent);

                        }
                        else
                        {
                            System.out.println("The record is invalid");
                        }

                        System.out.println("===Mark===");
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println(e);
                        System.out.println("===Mark===");
                        
                    }
                    catch(BadDetailsException e)
                    {
                        System.out.println(e);
                        System.out.println("===Mark===");
                    }
                    
                }
                theFlag = false;
            }
            
            catch(FileNotFoundException e)
            {
                System.out.println(e);
            }
            catch(IOException e)
            {
                System.out.println(e);
            } 
        }while(theFlag);
        
    }
    
    /**
     * This method is a helper method that allows the readStudent method to 
     * create the object for storing in the array.  
     */
    private static Student createStudentObj(String[] inputArr)
    {
        String zTitle = inputArr[0];
        String zFirstName = inputArr[1];
        String zLastName = inputArr[2];
        int zDay = Integer.parseInt(inputArr[3]);
        int zMonth = Integer.parseInt(inputArr[4]);
        int zYear = Integer.parseInt(inputArr[5]);
        DOB zBirthDay = new DOB(zDay, zMonth, zYear);
        long zStudentNum  = Long.parseLong(inputArr[6]);
        double zAssignmentOne = Double.parseDouble(inputArr[7]);
        double zAssignmentTwo = Double.parseDouble(inputArr[8]);
        double zPrac = Double.parseDouble(inputArr[9]);
        double zExam = Double.parseDouble(inputArr[10]);
        
        return new Student(zTitle, zFirstName, zLastName, zBirthDay
                , zStudentNum, zAssignmentOne, zAssignmentTwo, zPrac, zExam);
    }
    
    /**
     * This method is the interface that validates and adds one record to
     * the array. 
     */
    public static void addRecord()
    {
        boolean theFlag0 = true;
        boolean theFlag1 = true; 
        String zTitle = null;
        String zFirstName = null;
        String zLastName = null;
        long zStudentNum  = 0;
        int zDay = -1;
        int zMonth = -1;
        int zYear = -1;
        double zAssignmentOne = 0.00;
        double zAssignmentTwo = 0.00;
        double zPrac = -1;
        double zExam = 0.00;
        
        Student newStudent  = new Student();
        //Kludgy because it is not encapsulated in a class 
        ValidStudent[] testStudent = new ValidStudent[13];
        testStudent[0] = new ValidationCheckEmptyTitle();
        testStudent[1] = new ValidationCheckTitle();
        testStudent[2] = new ValidationCheckEmptyFirstName();
        testStudent[3] = new ValidationCheckFirstName();
        testStudent[4] = new ValidationCheckEmptyLastName();
        testStudent[5] = new ValidationCheckLastName();
        testStudent[6] = new ValidationCheckEmptyID();
        testStudent[7] = new ValidationCheckNumLength();
        testStudent[8] = new ValidationCheckEmptyDOB();
        testStudent[9] = new ValidationCheckDateOfBirth();
        testStudent[10] = new ValidationCheckMarkRange();
        testStudent[11] = new ValidationCheckNumericID();
        testStudent[12] = new ValidationCheckDuplicateStudent();
    
        
        do
        {
            try
            {
                System.out.println("Please enter title.");
                zTitle = theKB.nextLine();
                newStudent.setTitle(zTitle);
                theFlag0 = testStudent[0].isValid(newStudent);
                theFlag1 = testStudent[1].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }while(theFlag0 || theFlag1);
        
        theFlag0 = true;
        theFlag1 = true;
        
        do
        {
            try
            {
                System.out.println("Please enter firstname.");
                zFirstName = theKB.nextLine();
                newStudent.setFirstName(zFirstName);
                theFlag0 = testStudent[2].isValid(newStudent);
                theFlag1 = testStudent[3].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }while (theFlag0 || theFlag1);
        
        theFlag0 = true;
        theFlag1 = true;
        do
        {
            try
            {
                
                System.out.println("Please enter the surname");
                zLastName  = theKB.nextLine();
                newStudent.setLastName(zLastName);
                theFlag0 = testStudent[4].isValid(newStudent);
                theFlag1 = testStudent[5].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }while(theFlag0 || theFlag1);
        
        theFlag0 = true;
        theFlag1 = true;
        do
        {
            try
            {
                
                System.out.println("Please enter the student number");
                String tempStudentNum  = theKB.nextLine();
                zStudentNum  = Long.parseLong(tempStudentNum);
                newStudent.setStudentID(zStudentNum);
                theFlag0 = testStudent[6].isValid(newStudent);
                theFlag1 = testStudent[7].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(NumberFormatException en)
            {
                theFlag0 = true;
                System.out.println(en);
                        
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            
        }while(theFlag0 || theFlag1);
        
        theFlag0 = true;
        theFlag1 = true;
        do
        {
            try
            {
                System.out.println("Please enter the date of birth");
                System.out.println("Please enter the day:");
                zDay = Integer.parseInt(theKB.nextLine());
                System.out.println("Please enter the month:");
                zMonth = Integer.parseInt(theKB.nextLine());
                System.out.println("Please enter the year");
                zYear = Integer.parseInt(theKB.nextLine());
                DOB tempDate = new DOB(zDay, zMonth, zYear);
                newStudent.setStudentDOB(tempDate);
                theFlag0 = testStudent[8].isValid(newStudent);
                theFlag1 = testStudent[9].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }while(theFlag0 || theFlag1);
                
        theFlag0 = true;
        theFlag1 = true;
        do
        {
            try
            {
                System.out.println("Please enter the mark for assignment 1");
                zAssignmentOne = theKB.nextDouble();
                newStudent.setAssignmentOne(zAssignmentOne);
                System.out.println("Please enter the mark for assignment 2");
                zAssignmentTwo = theKB.nextDouble();
                newStudent.setAssignmentTwo(zAssignmentTwo);
              
                System.out.println("Please enter the mark for the practical "
                        + "[out of 10]");
                zPrac = theKB.nextDouble();
                newStudent.setPracWork(zPrac);
                System.out.println("Please enter the mark for the exam.");
                zExam = theKB.nextDouble();
                theKB.nextLine();
                newStudent.setExamMark(zExam);
                theFlag0  = testStudent[10].isValid(newStudent);
                theFlag1 = testStudent[11].isValid(newStudent);
                
            }
            catch(InputMismatchException exp)
            {
                theFlag0 = true;
                System.out.println(exp);
            }
            catch(BadDetailsException ek)
            {
                System.out.println(ek);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }while(theFlag0); 
        
        theFlag0 = true;
        try
        {
            theFlag0  = testStudent[12].isValid(newStudent);
            if(!theFlag0)
            {
                push(newStudent); 
            }
        }
        catch(BadDetailsException e)
        {
            System.out.println(e);
        }
        
    }
    
    /**
     * This method allows the user to add recordds to the array while keeping 
     * track of te logical size of the array used. It updates the index variable
     * and checks whether the array is full before adding the record. This 
     * method is public as the unit test uses this method. 
     * @param inputData takes on the Student object
     */
    public static void push(Student inputData)
    {
        if(theIndex < theStudent.length - 1)
        {
            theIndex++;
            theStudent[theIndex] = inputData;
            System.out.println("The record is saved.");
        }
        else
        {
            System.out.println("The array is full!");
        }
    }
    
    /**
     * This method allows the user to delete records in the array while keeping 
     * track of te logical size of the array used. It updates the index variable
     * and checks whether the array is empty before deleting the record.
     */
    private static void pop()
    {
        if(theIndex >= 0)
        {
            theIndex--;
            System.out.println("The record is deleted.");
        }
        else
        {
            System.out.println("The array is empty!");
        }
    }
    /**
     * This method is a utility function that tells the user whether the array 
     * is empty.
     * @return a boolean when the array is empty.
     */
    public boolean isEmpty() 
    {
        return (theIndex == -1);
    }
    /**
     * This method tests if the array is full and returns the result
     * @return a true boolean value if the array is full
     */
    public boolean isFull() 
    {
        return (theIndex == theStudent.length - 1);
    }
    
    
    /**
     * This method prints out a list of student calls the printStudent method.
     */
    public static void printStudents()
    {
        for(int g = 0; g < theIndex+1; g++)
        {
            printStudent(g);
        }
    }
    
    /**
     * This method prints out a singular student given the index of the student
     * @param studentIndex 
     */
    private static void printStudent(int studentIndex)
    {   
        
        System.out.println("Title: " + theStudent[studentIndex].getTitle());
        System.out.println("First Name: " + theStudent[studentIndex].getFirstName());
        System.out.println("Last Name: " + theStudent[studentIndex].getLastName());
        System.out.println("Student ID: " + theStudent[studentIndex].getStudentID());
        System.out.println("Date of Birth: " 
                + theStudent[studentIndex].getStudentDOB().getDay()+"/"
                +theStudent[studentIndex].getStudentDOB().getMonth()+ "/"
                + theStudent[studentIndex].getStudentDOB().getYear());
        System.out.printf("Mark: %.2f \n", theStudent[studentIndex].getOverallMark());
        System.out.println("Grade: " 
                + theStudent[studentIndex].getTheGrade());
        System.out.println();
    }
    
    /**
     * This method would print the mark of all students 
     */
    public static void printMarks()
    {
        
        for(int g = 0; g < theStudent.length; g++)
        {
            System.out.println("Assignment 1: " + theStudent[g].getAssignmentOne());
            System.out.println("Assignment 2: " + theStudent[g].getAssignmentTwo());
            System.out.println("Practical mark: " + theStudent[g].getPracWork());
            System.out.println("Exam: " + theStudent[g].getExamMark());
        }
    }
    
    /**
     * The method prints the mean of the cohort.
     */
    public static void printMean()
    {
        System.out.println("The class mean is: " + geoMean());
        System.out.println();
    }
    
    /**
     * This method calculates the mean of the cohort.
     * @return the mean of the cohort.
     */
    private static double geoMean()
    {   
        double geoTotal = 1;
        double theMean = 0;
        
        for (int i= 0; i < theIndex+1; i++)
        {
            geoTotal = geoTotal * theStudent[i].weightedAverage();
        }
        
        theMean = Math.pow(geoTotal, 1.0/(theIndex+1));
        
        return theMean;
    }
    
    /**
     * This method prints the aggregated passess or fails of the cohort.
     */
    public static void printPassFail()
    {
        System.out.println("The number passed: "+ passNum());
        System.out.println();
        System.out.println("The number failed: "+ failNum());
        System.out.println();
    }
    
    /**
     * This method calculates the number of students that pass the course
     * @return 
     */
    public static int passNum()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() >= geoMean())
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method calculates the fails in the cohort.
     * @return this returns the number of fails in the cohort
     */
    public static int failNum()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() < geoMean())
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method prints the distribution of the cohorts grades.
     */
    public static void printDistribution()
    {
        System.out.println("The number HD: "+ filterHD());
        System.out.println();
        System.out.println("The number H: "+ filterD());
        System.out.println();
        System.out.println("The number C: "+ filterC());
        System.out.println();
        System.out.println("The number P: "+ filterP());
        System.out.println();
        System.out.println("The number N: "+ filterN());
    }
    
    /**
     * This method calculates the number of HD achieved within the cohort.
     * @return a counter indicating the number of HD
     */
    public static int filterHD()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() > 80)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method calculates the number of D achieved within the cohort.
     * @return a counter indicating the number of D
     */
    public static int filterD()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() > 70)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method calculates the number of C achieved within the cohort.
     * @return a counter indicating the number of C
     */
    public static int filterC()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() > 60)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method calculates the number of P achieved within the cohort.
     * @return a counter indicating the number of P
     */
    public static int filterP()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() >= 50)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method calculates the number of N achieved within the cohort.
     * @return a counter indicating the number of N
     */
    public static int filterN()
    {
        int counter = 0;
        for(int i = 0; i < theIndex+1; i++)
        {
            if(theStudent[i].weightedAverage() < 50)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    /**
     * This method is the interface for the user to search and return a student
     * record by student ID.
     */
    public static void searchStudentID()
    {
        String theInput;
        long theKey = 0;
        int theResult = 0;
        
        boolean theFlag = true; 
        
        iSort(theStudent, theIndex+1);
        do
        {
            System.out.println("Please enter a student ID to start searching:");
            theInput = theKB.nextLine();
            if (theInput.isEmpty())
            {
                System.out.println("Please enter a number!");
                theFlag = true;
            }
            else if(isLong(theInput))
            {
                theKey = Long.parseLong(theInput);
                theFlag = false;
            }
            else
            {
                System.out.println("Please enter a student number: ");
                theFlag = true;
            }
            
        }while(theFlag);
        
        theResult = bSearch(theStudent, theKey);
        
        if(theResult == -1)
        {
            System.out.println("Error no record");
        }
        else
        {
            System.out.println();
            printStudent(theResult);
        }
    }
    
    /**
     * This method is the interface for the user to search and return a student
     * record by student name.
     */
    public static void searchStudentName()
    {
        String inputFirst;
        String inputLast;
        String theInput;
        String theKey = "";
        int theResult = 0;
        
        boolean theFlag = true; 
        
        sSort(theStudent, theIndex+1);
        do
        {
            System.out.println("Please enter a student name to start searching:");
            System.out.println("Please enter the first name: ");
            inputFirst = theKB.nextLine();
            System.out.println("Please enter the last name: ");
            inputLast = theKB.nextLine();
           
            theInput = inputFirst.concat(inputLast);
            
            if (theInput.isEmpty())
            {
                System.out.println("Please enter a name!");
                theFlag = true;
            }
            else
            {
                theKey = theInput;
                theFlag = false;
            }
            
        }while(theFlag);
        
        theResult = bSearch(theStudent, theKey);
        
        if(theResult == -1)
        {
            System.out.println("Error no record");
        }
        else
        {
            System.out.println();
            printStudent(theResult);
        }
    }
    
    /**
     *
     * @param inputString
     * @return
     */
    public static boolean isLong(String inputString)  
    {  
        try  
        {  
          long d = Long.parseLong(inputString);  
        }  
        catch(NumberFormatException exception)  
        {  
          return false;  
        }  
        return true;  
    }
    
    /**
     * This method is a binary search, it allows the user to search for a given 
     * student and returns a student. 
     * @param inputArr
     * @param inputKey
     * @return Student
     */
    public static int bSearch(Student[] inputArr, long inputKey)
    {
        int firstElement = 0;
        int lastElement = (theIndex+1) - 1;
        int midElement;
        
        while(firstElement <= lastElement)
        {
            midElement = (firstElement + lastElement)/2;
            
            if (inputKey == inputArr[midElement].getStudentID()) 
            {
                return midElement;
            }
            
            if (inputKey < inputArr[midElement].getStudentID()) {
                lastElement = midElement - 1;
            } else {
                firstElement = midElement + 1;
            }
        }
        
        return -1;
    }
    
    /**
     *
     * @param inputArr
     * @param inputKey
     * @return
     */
    public static int bSearch(Student[] inputArr, String inputKey)
    {
        int firstElement = 0;
        int lastElement = (theIndex+1) - 1;
        int midElement;
        
        while(firstElement <= lastElement)
        {
            midElement = (firstElement + lastElement)/2;
            
            if (inputArr[midElement].getFirstName()
                    .concat(inputArr[midElement].getLastName())
                    .compareTo(inputKey) > 0) 
            {
                lastElement = midElement - 1;
            } else if(inputArr[midElement].getFirstName()
                    .concat(inputArr[midElement].getLastName())
                    .compareTo(inputKey) < 0){
                firstElement = midElement + 1;
            }
            else
            {
                return midElement;
            }
        }
        
        return -1;
    }
    
    /**
     *
     * @param inputArr
     * @param inputLength
     */
    public static void sSort(Student[] inputArr, int inputLength)
    {
        for (int i = 0; i < inputLength - 1; ++i)
        {
            int minElement = i;
            for (int j = i + 1; j < inputLength; ++j)
            {   
                String tempOrig = inputArr[j].getFirstName()
                        .concat(inputArr[j].getLastName());
                String tempComp = inputArr[minElement].getFirstName()
                        .concat(inputArr[minElement].getLastName());
                if (tempOrig.compareTo(tempComp) < 0)
                {
                  minElement = j;
                }
            }

            Student temp = inputArr[i];
            inputArr[i] = inputArr[minElement];
            inputArr[minElement] = temp;
        }
    }
    
    /**
     * This method sorts the student array via an insertion sort.
     * @param inputArr
     * @param inputLength
     */
    public static void iSort(Student[] inputArr, int inputLength)
    {
        Student temp  = new Student();
        int j = 0; 
        for(int i = 0; i < inputLength; i+=1)
        {
            temp = inputArr[i];
            j = i;
            while(j > 0 && temp.getStudentID() < inputArr[j-1].getStudentID())
            {
                inputArr[j] = inputArr[j-1];
                j = j-1;
            }
            
            inputArr[j] = temp;
        }
    }
    
    /**
     * The method allows the user to find the First and Second best students in 
     * the cohort.
     * @param inputArr
     * @param inputLength
     */
    public static void findFirstSecond(Student[] inputArr, int inputLength )
    {
        //Student numSmallest = inputArr[0];
        //Student numSmall = inputArr[0];
        int numLarge = 0;
        int numLargest = 0;
        
        for (int j = 0; j < inputLength; j++ )
        {
            /*
            if(inputArr[j].weightedAverage() < numSmallest.weightedAverage())
            {
                numSmall = numSmallest;
                numSmallest = inputArr[j];
            }
            else 
            {
                if(inputArr[j].weightedAverage() < numSmall.weightedAverage())
                {
                    numSmall = inputArr[j];
                }
            }
            */

            if(inputArr[j].weightedAverage() > inputArr[numLargest].weightedAverage())
            {
                numLarge = numLargest;
                numLargest = j;
            }
            else
            {
                if(inputArr[j].weightedAverage() > inputArr[numLarge].weightedAverage())
                {
                    numLarge = j;
                }
            }
        }
        
        
        
        System.out.println();
        System.out.println("The largest number is: ");
        printStudent(numLargest);
        System.out.println();
        System.out.println("The second largest number is: ");
        printStudent(numLarge);
        System.out.println();
    }
    
    /**
     * This method allows the user to exit the program.
     * @return
     */
    public static boolean exitProg()
    {
        Scanner theKB = new Scanner(System.in);
        char theResponse;
        boolean theCheck = true;
        boolean theFlag = true;
        do
        {
            System.out.println("Would you like to continue");
            theResponse = theKB.nextLine().toLowerCase().charAt(0);
            if(theResponse == 'y')
            {
                theCheck = false;
                theFlag = true;
            }
            else if(theResponse == 'n')
            {
                theCheck = false;
                theFlag = false;
            }
            else
            {
                System.out.println("Please enter the Y/N only");
                theCheck = true;
            }
                
        }while(theCheck);
        
        return theFlag;
    }
    
}
