/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "viewstockdiary")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewstockdiary.findAll", query = "SELECT v FROM Viewstockdiary v")
  , @NamedQuery(name = "Viewstockdiary.findById", query = "SELECT v FROM Viewstockdiary v WHERE v.id = :id")
  , @NamedQuery(name = "Viewstockdiary.findByDatenew", query = "SELECT v FROM Viewstockdiary v WHERE v.datenew = :datenew")
  , @NamedQuery(name = "Viewstockdiary.findByReason", query = "SELECT v FROM Viewstockdiary v WHERE v.reason = :reason")
  , @NamedQuery(name = "Viewstockdiary.findByLocation", query = "SELECT v FROM Viewstockdiary v WHERE v.location = :location")
  , @NamedQuery(name = "Viewstockdiary.findByProduct", query = "SELECT v FROM Viewstockdiary v WHERE v.product = :product")
  , @NamedQuery(name = "Viewstockdiary.findByAttributesetinstanceId", query = "SELECT v FROM Viewstockdiary v WHERE v.attributesetinstanceId = :attributesetinstanceId")
  , @NamedQuery(name = "Viewstockdiary.findByUnits", query = "SELECT v FROM Viewstockdiary v WHERE v.units = :units")
  , @NamedQuery(name = "Viewstockdiary.findByPrice", query = "SELECT v FROM Viewstockdiary v WHERE v.price = :price")
  , @NamedQuery(name = "Viewstockdiary.findByAppuser", query = "SELECT v FROM Viewstockdiary v WHERE v.appuser = :appuser")
  , @NamedQuery(name = "Viewstockdiary.findBySiteguid", query = "SELECT v FROM Viewstockdiary v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewstockdiary.findBySflag", query = "SELECT v FROM Viewstockdiary v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewstockdiary.findByProductName", query = "SELECT v FROM Viewstockdiary v WHERE v.productName = :productName")
})
public class Viewstockdiary implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;
  @Column(name = "reason")
  private Integer reason;
  @Size(max = 255)
  @Column(name = "location")
  private String location;
  @Size(max = 255)
  @Column(name = "product")
  private String product;
  @Size(max = 255)
  @Column(name = "attributesetinstance_id")
  private String attributesetinstanceId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "units")
  private Double units;
  @Column(name = "price")
  private Double price;
  @Size(max = 255)
  @Column(name = "appuser")
  private String appuser;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Size(max = 255)
  @Column(name = "product_name")
  private String productName;

  public Viewstockdiary()
  {
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getDatenew()
  {
    return datenew;
  }

  public void setDatenew(String datenew)
  {
    this.datenew = datenew;
  }

  public Integer getReason()
  {
    return reason;
  }

  public void setReason(Integer reason)
  {
    this.reason = reason;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public String getProduct()
  {
    return product;
  }

  public void setProduct(String product)
  {
    this.product = product;
  }

  public String getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }

  public void setAttributesetinstanceId(String attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }

  public Double getUnits()
  {
    return units;
  }

  public void setUnits(Double units)
  {
    this.units = units;
  }

  public Double getPrice()
  {
    return price;
  }

  public void setPrice(Double price)
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

  public String getProductName()
  {
    return productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }
  
}
