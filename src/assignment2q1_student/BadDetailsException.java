/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2q1_student;

/**
 * @title Student Record System
 * @filename BadDetailsException.java
 * @purpose This class is used to extend the excdeption class.
 * @assumptions the inputs will only take in strings and doubles and do error 
 * checking on the input
 * @author Rebecca Lim
 */
public class BadDetailsException extends Exception {
    
    /**
     * Constructor to the exception
     */
    public BadDetailsException()
    {
        super("BadDetailsException");
    }
    
    /**
     * Constructor that accepts the error message for the exception
     * @param badMessage
     */
    public BadDetailsException(String badMessage)
    {
        super(badMessage);
    }
    
}
