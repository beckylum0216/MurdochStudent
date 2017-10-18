/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @title Student Record System
 * @filename DOB.java
 * @purpose This class is the object class that contains the date of birth
 * object. Contains all the associated validation methods 
 * @assumptions the inputs will only take in strings and doubles and do error 
 * checking on the input
 * @author Rebecca Lim
 */
public class DOB {
    private int day;
    private int month;
    private int year;
    
    /**
     *
     */
    public DOB()
    {
        this.day = -1;
        this.month = -1;
        this.year = -1;
    }
    
    /**
     * Constructor with 
     * @param inputDay
     * @param inputMonth
     * @param inputYear
     */
    public DOB(int inputDay, int inputMonth, int inputYear)
    {
        this.day = inputDay;
        this.month = inputMonth;
        this.year = inputYear;
    }

    /**
     *
     * @return
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     *
     * @param inputDate
     * @return
     */
    public boolean isEqual(DOB inputDate)
    {
        boolean theFlag = false;
        if((this.day == inputDate.day) 
                && (this.month == inputDate.month) 
                && (this.year == inputDate.year))
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    /**
     *
     * @return
     */
    public boolean isValidDate()
    {
        boolean theFlag;
        int theYear = this.year;
        int theMonth = this.month;
        int theDay = this.day;
        
        if(theYear >= 1900 
                && theYear <= 9999)
        {
            if(theMonth >= 1 && theMonth <= 12)
            {
                if((theDay >=1 && theDay <= 31)&&(theMonth == 1|| theMonth == 3)
                        || theMonth == 5 || theMonth == 7 || theMonth==8
                        || theMonth ==10 || theMonth == 12)
                {
                    theFlag = true;
                }
                else if((theDay >= 1 && theDay <= 30) && (theMonth == 4 
                        || theMonth == 6|| theMonth == 9|| theMonth == 11))
                {
                    theFlag = true;
                }
                else if((theDay >= 1 && theDay <= 28) && theMonth ==2)
                {
                    theFlag = true;
                }
                else if((theDay == 29)&&(theYear % 400 == 0 
                        || ((theYear % 4 == 0) && theYear%100 != 0)))
                {
                    theFlag = true;
                }
                else
                {
                    theFlag = false;
                }
            }
            else
            {
                theFlag = false;
            }
            
        }
        else
        {
            theFlag = false;
        }
        
        return theFlag;
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty()
    {
        boolean theFlag = false;
        if(this.getDay() == -1)
        {
            theFlag = true;
        }
        
        if(this.getMonth() == -1)
        {
            theFlag = true;
        }
        
        if(this.getYear() == -1)
        {
            theFlag = true;
        }
        
        return theFlag;
    }
           
}
