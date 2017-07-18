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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "viewticketlines")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewticketlines.findAll", query = "SELECT v FROM Viewticketlines v")
  , @NamedQuery(name = "Viewticketlines.findByTicket", query = "SELECT v FROM Viewticketlines v WHERE v.ticket = :ticket")
  , @NamedQuery(name = "Viewticketlines.findByLine", query = "SELECT v FROM Viewticketlines v WHERE v.line = :line")
  , @NamedQuery(name = "Viewticketlines.findByProduct", query = "SELECT v FROM Viewticketlines v WHERE v.product = :product")
  , @NamedQuery(name = "Viewticketlines.findByAttributesetinstanceId", query = "SELECT v FROM Viewticketlines v WHERE v.attributesetinstanceId = :attributesetinstanceId")
  , @NamedQuery(name = "Viewticketlines.findByUnits", query = "SELECT v FROM Viewticketlines v WHERE v.units = :units")
  , @NamedQuery(name = "Viewticketlines.findByPrice", query = "SELECT v FROM Viewticketlines v WHERE v.price = :price")
  , @NamedQuery(name = "Viewticketlines.findByTaxid", query = "SELECT v FROM Viewticketlines v WHERE v.taxid = :taxid")
  , @NamedQuery(name = "Viewticketlines.findByRefundqty", query = "SELECT v FROM Viewticketlines v WHERE v.refundqty = :refundqty")
  , @NamedQuery(name = "Viewticketlines.findBySiteguid", query = "SELECT v FROM Viewticketlines v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewticketlines.findBySflag", query = "SELECT v FROM Viewticketlines v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewticketlines.findByProductName", query = "SELECT v FROM Viewticketlines v WHERE v.productName = :productName")
  , @NamedQuery(name = "Viewticketlines.findByTaxName", query = "SELECT v FROM Viewticketlines v WHERE v.taxName = :taxName")
  , @NamedQuery(name = "Viewticketlines.findByRate", query = "SELECT v FROM Viewticketlines v WHERE v.rate = :rate")
})
public class Viewticketlines implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Id
  @Column(name = "ticket")
  private String ticket;
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

//  @JoinColumn(name = "id", insertable = false, updatable = false)
//  @ManyToOne(optional = false)
//  private Viewtickets tickets;
//  
//  public Viewtickets getTickets()
//  {
//    return tickets;
//  }
//
//  public void setTickets(Viewtickets tickets)
//  {
//    this.tickets = tickets;
//  }
//  
  public Viewticketlines()
  {
  }

  public String getTicket()
  {
    return ticket;
  }

  public void setTicket(String ticket)
  {
    this.ticket = ticket;
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
