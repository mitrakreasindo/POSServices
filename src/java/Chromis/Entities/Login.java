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
public class Login implements Serializable
{
  private String kodeMerchant;
  private String username;
  private String password;
  
  public String getKodeMerchant()
  {
    return kodeMerchant;
  }

  public void setKodeMerchant(String kodeMerchant)
  {
    this.kodeMerchant = kodeMerchant;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
