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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "promotions")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p")
  , @NamedQuery(name = "Promotions.findById", query = "SELECT p FROM Promotions p WHERE p.id = :id")
  , @NamedQuery(name = "Promotions.findByName", query = "SELECT p FROM Promotions p WHERE p.name = :name")
  , @NamedQuery(name = "Promotions.findByAllproducts", query = "SELECT p FROM Promotions p WHERE p.allproducts = :allproducts")
  , @NamedQuery(name = "Promotions.findByIsenabled", query = "SELECT p FROM Promotions p WHERE p.isenabled = :isenabled")
  , @NamedQuery(name = "Promotions.findBySiteguid", query = "SELECT p FROM Promotions p WHERE p.siteguid = :siteguid")
  , @NamedQuery(name = "Promotions.findBySflag", query = "SELECT p FROM Promotions p WHERE p.sflag = :sflag")
})
public class Promotions implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "id")
  private String id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Lob
  @Column(name = "criteria")
  private byte[] criteria;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Column(name = "script")
  private byte[] script;
  @Column(name = "allproducts")
  private Boolean allproducts;
  @Column(name = "isenabled")
  private Boolean isenabled;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(mappedBy = "promotionid")
  private Collection<Products> productsCollection;

  public Promotions()
  {
  }

  public Promotions(String id)
  {
    this.id = id;
  }

  public Promotions(String id, String name, byte[] script, String siteguid)
  {
    this.id = id;
    this.name = name;
    this.script = script;
    this.siteguid = siteguid;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
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

  public byte[] getCriteria()
  {
    return criteria;
  }

  public void setCriteria(byte[] criteria)
  {
    this.criteria = criteria;
  }

  public byte[] getScript()
  {
    return script;
  }

  public void setScript(byte[] script)
  {
    this.script = script;
  }

  public Boolean getAllproducts()
  {
    return allproducts;
  }

  public void setAllproducts(Boolean allproducts)
  {
    this.allproducts = allproducts;
  }

  public Boolean getIsenabled()
  {
    return isenabled;
  }

  public void setIsenabled(Boolean isenabled)
  {
    this.isenabled = isenabled;
  }

  public String getSiteguid()
  {
    return siteguid;
  }

  public void setSiteguid(String siteguid)
  {
    this.siteguid = siteguid;
  }

  public Boolean getSflag()
  {
    return sflag;
  }

  public void setSflag(Boolean sflag)
  {
    this.sflag = sflag;
  }

  @XmlTransient
  public Collection<Products> getProductsCollection()
  {
    return productsCollection;
  }

  public void setProductsCollection(Collection<Products> productsCollection)
  {
    this.productsCollection = productsCollection;
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
    if (!(object instanceof Promotions))
    {
      return false;
    }
    Promotions other = (Promotions) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Promotions[ id=" + id + " ]";
  }
  
}
