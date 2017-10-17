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
public class BadDetailsException extends Exception {
    
    /**
     * 
     */
    public BadDetailsException()
    {
        super("BadDetailsException");
    }
    
    /**
     *
     * @param badMessage
     */
    public BadDetailsException(String badMessage)
    {
        super(badMessage);
    }
    
}
