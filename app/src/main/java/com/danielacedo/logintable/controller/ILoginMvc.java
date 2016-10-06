package com.danielacedo.logintable.controller;

/**
 * Created by Daniel on 6/10/16
 */

/**
 * Interface that works as a base for the controller classes in our login
 * @author Daniel Acedo Calderón
 */


public interface ILoginMvc {
    /**
     * Parses the user and password input and checks for errors
     * @param user The user input
     * @param pass The password input
     * @return Status code
     * @author Daniel Acedo Calderón
     */
    public int validateCredentials(String user, String pass);
}
