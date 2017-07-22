/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "merchant_people")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "MerchantPeople.findAll", query = "SELECT m FROM MerchantPeople m")
  , @NamedQuery(name = "MerchantPeople.findById", query = "SELECT m FROM MerchantPeople m WHERE m.id = :id")
  , @NamedQuery(name = "MerchantPeople.findByName", query = "SELECT m FROM MerchantPeople m WHERE m.name = :name")
  , @NamedQuery(name = "MerchantPeople.findByPersonId", query = "SELECT m FROM MerchantPeople m WHERE m.personId = :personId")
})
public class MerchantPeople implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Size(max = 255)
  @Column(name = "name")
  private String name;
  @Size(max = 255)
  @Column(name = "person_id")
  private String personId;

  public MerchantPeople()
  {
  }

  public MerchantPeople(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPersonId()
  {
    return personId;
  }

  public void setPersonId(String personId)
  {
    this.personId = personId;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MerchantPeople))
    {
      return false;
    }
    MerchantPeople other = (MerchantPeople) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.MerchantPeople[ id=" + id + " ]";
  }
  
}
