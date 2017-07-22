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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "merchants")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Merchants.findAll", query = "SELECT m FROM Merchants m")
  , @NamedQuery(name = "Merchants.findByCode", query = "SELECT m FROM Merchants m WHERE m.code = :code")
  , @NamedQuery(name = "Merchants.findByName", query = "SELECT m FROM Merchants m WHERE m.name = :name")
  , @NamedQuery(name = "Merchants.findByEmail", query = "SELECT m FROM Merchants m WHERE m.email = :email")
  , @NamedQuery(name = "Merchants.findByPhone", query = "SELECT m FROM Merchants m WHERE m.phone = :phone")
  , @NamedQuery(name = "Merchants.findByAddress", query = "SELECT m FROM Merchants m WHERE m.address = :address")
  , @NamedQuery(name = "Merchants.findByNpwpperusahaan", query = "SELECT m FROM Merchants m WHERE m.npwpperusahaan = :npwpperusahaan")
  , @NamedQuery(name = "Merchants.findBySflag", query = "SELECT m FROM Merchants m WHERE m.sflag = :sflag")
})
public class Merchants implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "code")
  private String code;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "email")
  private String email;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "phone")
  private String phone;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2147483647)
  @Column(name = "address")
  private String address;
  @Size(max = 255)
  @Column(name = "npwpperusahaan")
  private String npwpperusahaan;
  @Basic(optional = false)
  @NotNull
  @Column(name = "sflag")
  private boolean sflag;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne
  private MerchantCategories category;

  public Merchants()
  {
  }

  public Merchants(String code)
  {
    this.code = code;
  }

  public Merchants(String code, String name, String email, String phone, String address, boolean sflag)
  {
    this.code = code;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.sflag = sflag;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getNpwpperusahaan()
  {
    return npwpperusahaan;
  }

  public void setNpwpperusahaan(String npwpperusahaan)
  {
    this.npwpperusahaan = npwpperusahaan;
  }

  public boolean getSflag()
  {
    return sflag;
  }

  public void setSflag(boolean sflag)
  {
    this.sflag = sflag;
  }

  public MerchantCategories getCategory()
  {
    return category;
  }

  public void setCategory(MerchantCategories category)
  {
    this.category = category;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (code != null ? code.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Merchants))
    {
      return false;
    }
    Merchants other = (Merchants) object;
    if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Merchants[ code=" + code + " ]";
  }
  
}
