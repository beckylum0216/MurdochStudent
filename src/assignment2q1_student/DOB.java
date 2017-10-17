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
 *
 * @author rebecca
 */
public class DOB {
    private String day;
    private String month;
    private String year;
    
    DOB()
    {
        this.day = null;
        this.month = null;
        this.year = null;
    }
    
    DOB(String inputDay, String inputMonth, String inputYear)
    {
        this.day = inputDay;
        this.month = inputMonth;
        this.year = inputYear;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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
        boolean theFlag;
        StringBuilder theDate = new StringBuilder();
        
        theDate.append(this.day);
        theDate.append(this.month);
        theDate.append(this.year);
        
        SimpleDateFormat theFormat = new SimpleDateFormat("ddMMyyyy");
        
        
        try
        {
            theFormat.setLenient(false);
            
            theFormat.parse(theDate.toString());
            TemporalAccessor ta = DateTimeFormatter.ofPattern("ddMMyyyy")
                    .parse(theDate.toString());
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
        if(this.getDay().isEmpty())
        {
            theFlag = true;
        }
        
        if(this.getMonth().isEmpty())
        {
            theFlag = true;
        }
        
        if(this.getYear().isEmpty())
        {
            theFlag = true;
        }
        
        return theFlag;
    }
           
}
