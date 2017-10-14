/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rebecca
 */
public class DOB {
    private int day;
    private int month;
    private int year;
    
    DOB()
    {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }
    
    DOB(int inputDay, int inputMonth, int inputYear)
    {
        this.day = inputDay;
        this.month = inputMonth;
        this.year = inputYear;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public boolean isEqual(DOB inputDate)
    {
        boolean theFlag = false;
        if((this.day == inputDate.day) && (this.month == inputDate.month) 
                && (this.year == inputDate.year))
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    public boolean isValidDate()
    {
        boolean theFlag = false;
        StringBuilder theDate = new StringBuilder();
        
        theDate.append(this.day);
        theDate.append(this.month);
        theDate.append(this.year);
        
        SimpleDateFormat theFormat = new SimpleDateFormat("ddmmyyyy");
        theFormat.setLenient(false);
        try
        {
            theFormat.parse(theDate.toString());
            theFlag = true;
            
        }
        catch (Exception e)
        {
            System.out.println(e);
            theFlag = false;
        }
        
        return theFlag;
    }
    
    public boolean isEmpty()
    {
        boolean theFlag = false;
        if(this.getDay() == 0)
        {
            theFlag = true;
        }
        
        if(this.getMonth() == 0)
        {
            theFlag = true;
        }
        
        if(this.getYear() == 0)
        {
            theFlag = true;
        }
        
        return theFlag;
    }
           
}
