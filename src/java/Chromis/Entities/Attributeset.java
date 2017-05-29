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
@Table(name = "attributeset")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Attributeset.findAll", query = "SELECT a FROM Attributeset a")
  , @NamedQuery(name = "Attributeset.findById", query = "SELECT a FROM Attributeset a WHERE a.id = :id")
  , @NamedQuery(name = "Attributeset.findByName", query = "SELECT a FROM Attributeset a WHERE a.name = :name")
  , @NamedQuery(name = "Attributeset.findBySiteguid", query = "SELECT a FROM Attributeset a WHERE a.siteguid = :siteguid")
  , @NamedQuery(name = "Attributeset.findBySflag", query = "SELECT a FROM Attributeset a WHERE a.sflag = :sflag")
})
public class Attributeset implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "id")
  private String id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(mappedBy = "attributesetId")
  private Collection<Products> productsCollection;

  public Attributeset()
  {
  }

  public Attributeset(String id)
  {
    this.id = id;
  }

  public Attributeset(String id, String name, String siteguid)
  {
    this.id = id;
    this.name = name;
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
    if (!(object instanceof Attributeset))
    {
      return false;
    }
    Attributeset other = (Attributeset) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Attributeset[ id=" + id + " ]";
  }
  
}
