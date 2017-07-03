/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Utilities;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author Asun
 */
public class GeneralFunction {
    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }
    
    public static String checkNullString(String input){
        if(input == null){
            return "";
        }
        else return input;
    }
    
    public static Date checkNullDate(Date input){
        if(input == null){
            return new Date();
        }
        else return input;
    }
    
    public static byte[] checkNullByte(byte[] input){
        if(input == null){
            return new byte[0];
        }
        else return input;
    }
}
