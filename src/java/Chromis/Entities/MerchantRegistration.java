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
public class MerchantRegistration implements Serializable
{
  private Merchants merchant;

  public Merchants getMerchant()
  {
    return merchant;
  }

  public void setMerchant(Merchants merchant)
  {
    this.merchant = merchant;
  }

  public People getPeople()
  {
    return people;
  }

  public void setPeople(People people)
  {
    this.people = people;
  }
  private People people;
  
}
