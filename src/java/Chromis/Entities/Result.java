/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;

/**
 *
 * @author Asun
 */
public class Result implements Serializable
{
  int retval;

  public int getRetval()
  {
    return retval;
  }

  public void setRetval(int retval)
  {
    this.retval = retval;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }
  String message;
  
}
