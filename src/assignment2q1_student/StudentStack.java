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
public class StudentStack {
    private int theMaxSize;
    private Student[] stackArr;
    private int theIndex;
    
    
    public StudentStack(int inputSize)
    {
        this.theMaxSize = inputSize;
        this.stackArr = new Student[theMaxSize];
        this.theIndex = -1;
    }
    
    public void push(Student inputElement)
    {
        if(theIndex < stackArr.length - 1)
        {
            theIndex++;
            stackArr[theIndex] = inputElement;
            System.out.println("The record is saved.");
        }
        else
        {
            System.out.println("The array is full!");
        }
    }
    
    public void pop()
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
    
    public boolean isEmpty() 
    {
        return (theIndex == -1);
    }
    
    public boolean isFull() 
    {
        return (theIndex == stackArr.length - 1);
    }
    
}
