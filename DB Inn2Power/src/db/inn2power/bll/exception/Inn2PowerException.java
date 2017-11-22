/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.bll.exception;

/**
 *
 * @author pgn
 */
public class Inn2PowerException extends Exception
{

    public Inn2PowerException(String message)
    {
        super(message);
    }

    public Inn2PowerException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public Inn2PowerException(Throwable cause)
    {
        super(cause);
    }

}
