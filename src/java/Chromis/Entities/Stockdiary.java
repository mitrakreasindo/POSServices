/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "stockdiary")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Stockdiary.findAll", query = "SELECT s FROM Stockdiary s")
  , @NamedQuery(name = "Stockdiary.findById", query = "SELECT s FROM Stockdiary s WHERE s.id = :id")
  , @NamedQuery(name = "Stockdiary.findByDatenew", query = "SELECT s FROM Stockdiary s WHERE s.datenew = :datenew")
  , @NamedQuery(name = "Stockdiary.findByReason", query = "SELECT s FROM Stockdiary s WHERE s.reason = :reason")
  , @NamedQuery(name = "Stockdiary.findByUnits", query = "SELECT s FROM Stockdiary s WHERE s.units = :units")
  , @NamedQuery(name = "Stockdiary.findByPrice", query = "SELECT s FROM Stockdiary s WHERE s.price = :price")
  , @NamedQuery(name = "Stockdiary.findByAppuser", query = "SELECT s FROM Stockdiary s WHERE s.appuser = :appuser")
  , @NamedQuery(name = "Stockdiary.findBySiteguid", query = "SELECT s FROM Stockdiary s WHERE s.siteguid = :siteguid")
  , @NamedQuery(name = "Stockdiary.findBySflag", query = "SELECT s FROM Stockdiary s WHERE s.sflag = :sflag")
})
public class Stockdiary implements Serializable
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
  @Column(name = "datenew")
  //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private Date datenew;
  @Basic(optional = false)
  @NotNull
  @Column(name = "reason")
  private int reason;
  @Basic(optional = false)
  @NotNull
  @Column(name = "units")
  private double units;
  @Basic(optional = false)
  @NotNull
  @Column(name = "price")
  private double price;
  @Size(max = 255)
  @Column(name = "appuser")
  private String appuser;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributesetinstance_id", referencedColumnName = "id")
  @ManyToOne
  private Attributesetinstance attributesetinstanceId;
  @JoinColumn(name = "location", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Locations location;
  @JoinColumn(name = "product", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Products product;

  public Stockdiary()
  {
  }

  public Stockdiary(String id)
  {
    this.id = id;
  }

  public Stockdiary(String id, Date datenew, int reason, double units, double price, String siteguid)
  {
    this.id = id;
    this.datenew = datenew;
    this.reason = reason;
    this.units = units;
    this.price = price;
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

  public Date getDatenew()
  {
      return datenew;
  }

  public void setDatenew(Date datenew) throws ParseException
  {
    this.datenew = datenew;
  }

  public int getReason()
  {
    return reason;
  }

  public void setReason(int reason)
  {
    this.reason = reason;
  }

  public double getUnits()
  {
    return units;
  }

  public void setUnits(double units)
  {
    this.units = units;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public String getAppuser()
  {
    return appuser;
  }

  public void setAppuser(String appuser)
  {
    this.appuser = appuser;
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

  public Attributesetinstance getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }

  public void setAttributesetinstanceId(Attributesetinstance attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }

  public Locations getLocation()
  {
    return location;
  }

  public void setLocation(Locations location)
  {
    this.location = location;
  }

  public Products getProduct()
  {
    return product;
  }

  public void setProduct(Products product)
  {
    this.product = product;
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
    if (!(object instanceof Stockdiary))
    {
      return false;
    }
    Stockdiary other = (Stockdiary) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Stockdiary[ id=" + id + " ]";
  }
  
}
