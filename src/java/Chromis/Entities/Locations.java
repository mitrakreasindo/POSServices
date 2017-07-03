/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "locations")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
  , @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id")
  , @NamedQuery(name = "Locations.findByName", query = "SELECT l FROM Locations l WHERE l.name = :name")
  , @NamedQuery(name = "Locations.findByAddress", query = "SELECT l FROM Locations l WHERE l.address = :address")
  , @NamedQuery(name = "Locations.findBySiteguid", query = "SELECT l FROM Locations l WHERE l.siteguid = :siteguid")
  , @NamedQuery(name = "Locations.findBySflag", query = "SELECT l FROM Locations l WHERE l.sflag = :sflag")
})
public class Locations implements Serializable
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
  @Size(max = 255)
  @Column(name = "address")
  private String address;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
  private Collection<Stockdiary> stockdiaryCollection;

  public Locations()
  {
  }

  public Locations(String id)
  {
    this.id = id;
  }

  public Locations(String id, String name, String siteguid)
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

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
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
  public Collection<Stockdiary> getStockdiaryCollection()
  {
    return stockdiaryCollection;
  }

  public void setStockdiaryCollection(Collection<Stockdiary> stockdiaryCollection)
  {
    this.stockdiaryCollection = stockdiaryCollection;
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
    if (!(object instanceof Locations))
    {
      return false;
    }
    Locations other = (Locations) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Locations[ id=" + id + " ]";
  }
  
}
