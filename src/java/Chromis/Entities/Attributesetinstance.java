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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "attributesetinstance")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Attributesetinstance.findAll", query = "SELECT a FROM Attributesetinstance a")
  , @NamedQuery(name = "Attributesetinstance.findById", query = "SELECT a FROM Attributesetinstance a WHERE a.id = :id")
  , @NamedQuery(name = "Attributesetinstance.findByDescription", query = "SELECT a FROM Attributesetinstance a WHERE a.description = :description")
  , @NamedQuery(name = "Attributesetinstance.findBySiteguid", query = "SELECT a FROM Attributesetinstance a WHERE a.siteguid = :siteguid")
  , @NamedQuery(name = "Attributesetinstance.findBySflag", query = "SELECT a FROM Attributesetinstance a WHERE a.sflag = :sflag")
})
public class Attributesetinstance implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "id")
  private String id;
  @Size(max = 255)
  @Column(name = "description")
  private String description;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributeset_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Attributeset attributesetId;
  @OneToMany(mappedBy = "attributesetinstanceId")
  private Collection<SalesItems> salesItemsCollection;
  @OneToMany(mappedBy = "attributesetinstanceId")
  private Collection<Stockdiary> stockdiaryCollection;

  public Attributesetinstance()
  {
  }

  public Attributesetinstance(String id)
  {
    this.id = id;
  }

  public Attributesetinstance(String id, String siteguid)
  {
    this.id = id;
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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
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

  public Attributeset getAttributesetId()
  {
    return attributesetId;
  }

  public void setAttributesetId(Attributeset attributesetId)
  {
    this.attributesetId = attributesetId;
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
    if (!(object instanceof Attributesetinstance))
    {
      return false;
    }
    Attributesetinstance other = (Attributesetinstance) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Attributesetinstance[ id=" + id + " ]";
  }

  @XmlTransient
  @JsonIgnore
  public Collection<SalesItems> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }

  public void setSalesItemsCollection(Collection<SalesItems> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  
}
