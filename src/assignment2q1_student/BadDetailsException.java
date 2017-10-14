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
public class BadDetailsException extends Exception {
    
    public BadDetailsException()
    {
        super("BadDetailsException");
    }
    
    public BadDetailsException(String badMessage)
    {
        super(badMessage);
    }
    
}
