/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Asun
 */
public class GeneralFunction {
    public static String checkNullString(String input){
        if(input == null){
            return "";
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
