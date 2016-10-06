package com.danielacedo.logintable.controller;

/**
 * Created by usuario on 5/10/16.
 */

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;

import java.util.regex.Pattern;

/**
 * Controller class that regulates the user and password input from the view and returns an status code associated with the business policies
 * @author Daniel Acedo Calderón
 */

public class LoginTable_Controller implements ILoginMvc{

    public static final int OK = 0; // Success
    public static final int PASSWORD_DIGIT = 1; //The password doesn't comply with the password minimum digit policy
    public static final int PASSWORD_UPPERLOWERCASE = 2; //The password doesn't comply with the password minimum lowercase/uppercase policy
    public static final int PASSWORD_LENGTH = 3; //The password doesn't comply with the password length policy

    /**
     * Parses the user and password input and checks for errors
     * @param user The user input
     * @param pass The password input
     * @return Status code
     * @author Daniel Acedo Calderón
     */
    public int validateCredentials(String user, String pass){
        if(!Pattern.matches(".*[0-9].*", pass)){
            return PASSWORD_DIGIT;
        }

        if(!Pattern.matches(".*[a-z].*",pass) || !Pattern.matches(".*[A-Z].*",pass)){
            return PASSWORD_UPPERLOWERCASE;
        }

        if(pass.length()<8){
            return PASSWORD_LENGTH;
        }

        return OK;
    }
}
