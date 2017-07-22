/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "merchantcategories")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "MerchantCategories.findAll", query = "SELECT m FROM MerchantCategories m")
  , @NamedQuery(name = "MerchantCategories.findById", query = "SELECT m FROM MerchantCategories m WHERE m.id = :id")
  , @NamedQuery(name = "MerchantCategories.findByName", query = "SELECT m FROM MerchantCategories m WHERE m.name = :name")
  , @NamedQuery(name = "MerchantCategories.findBySubcategory", query = "SELECT m FROM MerchantCategories m WHERE m.subcategory = :subcategory")
  , @NamedQuery(name = "MerchantCategories.findBySflag", query = "SELECT m FROM MerchantCategories m WHERE m.sflag = :sflag")
})
public class MerchantCategories implements Serializable
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
  @Column(name = "subcategory")
  private String subcategory;
  @Basic(optional = false)
  @NotNull
  @Column(name = "sflag")
  private boolean sflag;
  @OneToMany(mappedBy = "category")
  private Collection<Merchants> merchantsCollection;

  public MerchantCategories()
  {
  }

  public MerchantCategories(Integer id)
  {
    this.id = id;
  }

  public MerchantCategories(Integer id, boolean sflag)
  {
    this.id = id;
    this.sflag = sflag;
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

  public String getSubcategory()
  {
    return subcategory;
  }

  public void setSubcategory(String subcategory)
  {
    this.subcategory = subcategory;
  }

  public boolean getSflag()
  {
    return sflag;
  }

  public void setSflag(boolean sflag)
  {
    this.sflag = sflag;
  }

  @XmlTransient
  @JsonIgnore
  public Collection<Merchants> getMerchantsCollection()
  {
    return merchantsCollection;
  }

  public void setMerchantsCollection(Collection<Merchants> merchantsCollection)
  {
    this.merchantsCollection = merchantsCollection;
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
    if (!(object instanceof MerchantCategories))
    {
      return false;
    }
    MerchantCategories other = (MerchantCategories) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.MerchantCategories[ id=" + id + " ]";
  }
  
}
