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
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Assignment2Q1_Student {

    /**
     * @param args the command line arguments
     */
    
    static String[] initTitle = {"Mr", "Mrs", "Ms"};
    static String[] initFirst = {"Pippen", "Beverly", "John", "Robin", "Angelyn", "Kevin"};
    static String[] initLast = {"Pink", "Yellow", "Cyan", "Red","Blue", "Green"};
    static final int THE_NUMBER = 12;
    static Student[] theStudent = new Student[THE_NUMBER];
    static Scanner theKB = new Scanner(System.in);
    
    
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
                    initStudent();
                    break; 
                case 1:
                    theFlag = exitProg();
                    break;
                case 2:
                    addEdit();
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
                    findFirstSecond(theStudent, theStudent.length);
                    break;
                case 10:
                    sSort(theStudent, theStudent.length);
                    printStudents();
                    break;
                case 11:
                    iSort(theStudent, theStudent.length);
                    printStudents();
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
            
        }while(theFlag);
        
        System.out.println("Exiting...");
    }
    
    public static void studentInfo()
    {
        System.out.println("Name:               Rebecca Lim");
        System.out.println("Student Number:     33111264");
        System.out.println("Enrolement:         Internal");
        System.out.println("Tutor:              Mark Abernethy");
        System.out.println("Tutorial:           Thursday, 10.30am");
        System.out.println();
    }
    
    public static void printMenu()
    {
        System.out.println("Menu");
        System.out.println("==============================================");
        System.out.println("1: Quit.");
        System.out.println("2: Press 1 to add student information.");
        System.out.println("3: Press 2 to display all student information.");
        System.out.println("4: Press 3 to calculate and display the average for "
                + "the class.");
        System.out.println("5: Press 4 to display students above or below "
                + "the average mark.");
        System.out.println("6: Press 5 to show the distribution of grades.");
        System.out.println("7: Press 6 to search for student by student number.");
        System.out.println("8: Press 7 to search for student by name.");
        System.out.println("9: Press 8 to list first and second highest marks.");
        System.out.println("10: Press 9 to sort the class by name.");
        System.out.println("11: Press 10 to sort the class by student number.");
        
    }
    
    public static void initStudent()
    {
        Random theNum = new Random();
        double[] tempArr = new double[10];
        
        for(int g = 0; g < THE_NUMBER; g++  )
        {
            theStudent[g] = new Student(); 
            String anyTitle = initTitle[theNum.nextInt(3)];
            theStudent[g].setTitle(anyTitle);
            String anyFirst = initFirst[theNum.nextInt(6)];
            theStudent[g].setFirstName(anyFirst); 
            String anyLast = initLast[theNum.nextInt(6)];
            theStudent[g].setLastName(anyLast);
            theStudent[g].setStudentID(theNum.nextInt(99999999));
            theStudent[g].setStudentDOB(new DOB(theNum.nextInt(30), 
                    theNum.nextInt(12), theNum.nextInt(100)));
            theStudent[g].setAssignmentOne(theNum.nextInt(100));
            theStudent[g].setAssignmentTwo(theNum.nextInt(100));
            for (int i = 0; i < theStudent[g].getPracWork().length; i++)
            {
                tempArr[i] = theNum.nextInt(100);
            }
            
            theStudent[g].setPracWork(tempArr);
            
            theStudent[g].setExamMark(theNum.nextInt(100));
        }
        
    }
    
    public static void addEdit()
    {
        boolean theFlag = true;
        String zTitle = null;
        String zFirstName = null;
        String zLastName = null;
        long zStudentNum  = 0;
        int zDay = 0;
        int zMonth = 0;
        int zYear = 0;
        double zAssignmentOne = 0.00;
        double zAssignmentTwo = 0.00;
        double[] zPrac = new double[10];
        double zExam = 0.00;
        
        Student newStudent  = new Student();
        
        
        ValidStudent[] testStudent = new ValidStudent[11];
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
        
        do
        {
            try
            {
                System.out.println("Please enter title.");
                zTitle = theKB.nextLine();
                newStudent.setTitle(zTitle);
                theFlag = testStudent[0].isValid(newStudent);
                theFlag = testStudent[1].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
        }while(theFlag);
        
               
        do
        {
            try
            {
                System.out.println("Please enter firstname.");
                zFirstName = theKB.nextLine();
                newStudent.setFirstName(zFirstName);
                theFlag = testStudent[2].isValid(newStudent);
                theFlag = testStudent[3].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
        }while (theFlag);
                
        do
        {
            try
            {
                
                System.out.println("Please enter the surname");
                zLastName  = theKB.nextLine();
                newStudent.setLastName(zLastName);
                theFlag = testStudent[4].isValid(newStudent);
                theFlag = testStudent[5].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
        }while(theFlag);
        
        do
        {
            try
            {
                
                System.out.println("Please enter the student number");
                String tempStudentNum  = theKB.nextLine();
                zStudentNum  = Long.parseLong(tempStudentNum);
                newStudent.setStudentID(zStudentNum);
                theFlag = testStudent[6].isValid(newStudent);
                theFlag = testStudent[7].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                System.out.println(e);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            
        }while(theFlag);
                
        do
        {
            try
            {
                System.out.println("Please enter the date of birth");
                System.out.println("Please enter the day:");
                String tempDay = theKB.nextLine();
                zDay = Integer.parseInt(tempDay);
                System.out.println("Please enter the month:");
                String tempMonth = theKB.nextLine();
                zMonth = Integer.parseInt(tempMonth);
                System.out.println("Please enter the year");
                String tempYear = theKB.nextLine();
                zYear = Integer.parseInt(tempYear);
                DOB tempDate = new DOB(zDay, zMonth, zYear);
                newStudent.setStudentDOB(tempDate);
                testStudent[8].isValid(newStudent);
                testStudent[9].isValid(newStudent);
            }
            catch(BadDetailsException e)
            {
                
            }
            
        }while(theFlag);
                
                
                System.out.println("Please enter the mark for assignment 1");
                zAssignmentOne = theKB.nextDouble();
                newStudent.setAssignmentOne(zAssignmentOne);
                System.out.println("Please enter the mark for assignment 2");
                zAssignmentTwo = theKB.nextDouble();
                newStudent.setAssignmentTwo(zAssignmentTwo);
                for(int i = 0; i < zPrac.length; i++)
                {
                    System.out.println("Please enter the mark for practical ["+i+"]");
                    zPrac[i] = theKB.nextDouble();
                }
                newStudent.setPracWork(zPrac);
                System.out.println("Please enter the mark for the exam.");
                zExam = theKB.nextDouble();
                theKB.nextLine();
                newStudent.setExamMark(zExam);
                testStudent[10].isValid(newStudent);
                
                for(int i = 0; i < testStudent.length; i++)
                {
                    testStudent[i].isValid(newStudent);
                }

            }
            catch(InputMismatchException exp)
            {
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
            
        }while(theFlag); 
        
        addElement(theStudent, newStudent);
       
    }
    
    private static void addElement(Student[] inputArr, Student inputData)
    {
        
        
        int i = findLogicalSize(inputArr);
        theStudent[i] = inputData;
    }
    
    private static int findLogicalSize(Student[] inputArr)
    {
        int theIndex = 0;
        for(int i = 0; i < inputArr.length; i++)
        {
            if(inputArr[i] == null && i < (inputArr.length-1))
            {
                theIndex = i;
            }
            else
            {
                System.out.println("The array is full");
                break;
                        
            }
        }
        
        return theIndex;
        
    }
    
    public static void printStudents()
    {
        for(int g = 0; g < theStudent.length; g++)
        {
            printStudent(g);
        }
    }
    
    private static void printStudent(int studentIndex)
    {   
        
        System.out.println("Title: " + theStudent[studentIndex].getTitle());
        System.out.println("First Name: " + theStudent[studentIndex].getFirstName());
        System.out.println("Last Name: " + theStudent[studentIndex].getLastName());
        System.out.println("Title: " + theStudent[studentIndex].getStudentID());
        System.out.println("Date of Birth: " 
                + theStudent[studentIndex].getStudentDOB().getDay()+"/"
                +theStudent[studentIndex].getStudentDOB().getMonth()+ "/"
                + theStudent[studentIndex].getStudentDOB().getYear());
        System.out.println("Mark: " + theStudent[studentIndex].weightedAverage());
        System.out.println("Title: " 
                + theStudent[studentIndex].printFinalMark(theStudent[studentIndex]
                        .weightedAverage()));
        System.out.println();
    }
    
    
    
    public static void printMarks()
    {
        double[] tempArr = new double[10]; 
        for(int g = 0; g < theStudent.length; g++)
        {
            System.out.println("Assignment 1: " + theStudent[g].getAssignmentOne());
            System.out.println("Assignment 2: " + theStudent[g].getAssignmentTwo());
            tempArr = theStudent[g].getPracWork();
            for(int i = 0; i < theStudent[g].getPracWork().length; i++)
            {
                
                System.out.println("Practical "+ i + " mark: " + tempArr[i]);
            }
            System.out.println("Exam: " + theStudent[g].getExamMark());
        }
    }
    
    public static void printMean()
    {
        System.out.println("The class mean is: " + geoMean());
        System.out.println();
    }
    
    public static double geoMean()
    {   
        double geoTotal = 1;
        double theMean = 0;
        
        for (int i= 0; i < theStudent.length; i++)
        {
            geoTotal = geoTotal * theStudent[i].weightedAverage();
        }
        
        theMean = Math.pow(geoTotal, 1.0/theStudent.length);
        
        return theMean;
    }
    
    public static void printPassFail()
    {
        System.out.println("The number passed: "+ passNum());
        System.out.println();
        System.out.println("The number failed: "+ failNum());
        System.out.println();
    }
    
    public static int passNum()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() >= geoMean())
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static int failNum()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() < geoMean())
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
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
    
    public static int filterHD()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() > 80)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static int filterD()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() > 70)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static int filterC()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() > 60)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static int filterP()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() >= 50)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static int filterN()
    {
        int counter = 0;
        for(int i = 0; i < theStudent.length; i++)
        {
            if(theStudent[i].weightedAverage() < 50)
            {
                counter = counter + 1;
            }
        }
        return counter;
    }
    
    public static void searchStudentID()
    {
        String theInput;
        long theKey = 0;
        int theResult = 0;
        
        boolean theFlag = true; 
        
        iSort(theStudent, theStudent.length);
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
    
    public static void searchStudentName()
    {
        String inputFirst;
        String inputLast;
        String theInput;
        String theKey = "";
        int theResult = 0;
        
        boolean theFlag = true; 
        
        sSort(theStudent, theStudent.length);
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
    
    public static int bSearch(Student[] inputArr, long inputKey)
    {
        int firstElement = 0;
        int lastElement = inputArr.length - 1;
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
    
    public static int bSearch(Student[] inputArr, String inputKey)
    {
        int firstElement = 0;
        int lastElement = inputArr.length - 1;
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
