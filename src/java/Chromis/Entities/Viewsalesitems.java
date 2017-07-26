/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "viewsalesitems")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewsalesitems.findAll", query = "SELECT v FROM Viewsalesitems v")
  , @NamedQuery(name = "Viewsalesitems.findById", query = "SELECT v FROM Viewsalesitems v WHERE v.id = :id")
  , @NamedQuery(name = "Viewsalesitems.findBySalesId", query = "SELECT v FROM Viewsalesitems v WHERE v.salesId = :salesId")
  , @NamedQuery(name = "Viewsalesitems.findByLine", query = "SELECT v FROM Viewsalesitems v WHERE v.line = :line")
  , @NamedQuery(name = "Viewsalesitems.findByProduct", query = "SELECT v FROM Viewsalesitems v WHERE v.product = :product")
  , @NamedQuery(name = "Viewsalesitems.findByAttributesetinstanceId", query = "SELECT v FROM Viewsalesitems v WHERE v.attributesetinstanceId = :attributesetinstanceId")
  , @NamedQuery(name = "Viewsalesitems.findByUnits", query = "SELECT v FROM Viewsalesitems v WHERE v.units = :units")
  , @NamedQuery(name = "Viewsalesitems.findByPrice", query = "SELECT v FROM Viewsalesitems v WHERE v.price = :price")
  , @NamedQuery(name = "Viewsalesitems.findByTaxid", query = "SELECT v FROM Viewsalesitems v WHERE v.taxid = :taxid")
  , @NamedQuery(name = "Viewsalesitems.findByRefundqty", query = "SELECT v FROM Viewsalesitems v WHERE v.refundqty = :refundqty")
  , @NamedQuery(name = "Viewsalesitems.findBySiteguid", query = "SELECT v FROM Viewsalesitems v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewsalesitems.findBySflag", query = "SELECT v FROM Viewsalesitems v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewsalesitems.findByProductName", query = "SELECT v FROM Viewsalesitems v WHERE v.productName = :productName")
  , @NamedQuery(name = "Viewsalesitems.findByTaxName", query = "SELECT v FROM Viewsalesitems v WHERE v.taxName = :taxName")
  , @NamedQuery(name = "Viewsalesitems.findByRate", query = "SELECT v FROM Viewsalesitems v WHERE v.rate = :rate")
})
public class Viewsalesitems implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Column(name = "id")
  @Id
  private Integer id;
  @Size(max = 255)
  @Column(name = "salesId")
  private String salesId;
  @Column(name = "line")
  private Integer line;
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
  @Column(name = "taxid")
  private String taxid;
  @Lob
  @Column(name = "attributes")
  private byte[] attributes;
  @Column(name = "refundqty")
  private Double refundqty;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Size(max = 255)
  @Column(name = "product_name")
  private String productName;
  @Size(max = 255)
  @Column(name = "tax_name")
  private String taxName;
  @Column(name = "rate")
  private Double rate;

  public Viewsalesitems()
  {
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getSalesId()
  {
    return salesId;
  }

  public void setSalesId(String salesId)
  {
    this.salesId = salesId;
  }

  public Integer getLine()
  {
    return line;
  }

  public void setLine(Integer line)
  {
    this.line = line;
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

  public String getTaxid()
  {
    return taxid;
  }

  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }

  public Double getRefundqty()
  {
    return refundqty;
  }

  public void setRefundqty(Double refundqty)
  {
    this.refundqty = refundqty;
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

  public String getTaxName()
  {
    return taxName;
  }

  public void setTaxName(String taxName)
  {
    this.taxName = taxName;
  }

  public Double getRate()
  {
    return rate;
  }

  public void setRate(Double rate)
  {
    this.rate = rate;
  }
  
}
