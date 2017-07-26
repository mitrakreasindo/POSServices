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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "sales_items")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "SalesItems.findAll", query = "SELECT s FROM SalesItems s")
  , @NamedQuery(name = "SalesItems.findById", query = "SELECT s FROM SalesItems s WHERE s.id = :id")
  , @NamedQuery(name = "SalesItems.findByLine", query = "SELECT s FROM SalesItems s WHERE s.line = :line")
  , @NamedQuery(name = "SalesItems.findByUnits", query = "SELECT s FROM SalesItems s WHERE s.units = :units")
  , @NamedQuery(name = "SalesItems.findByPrice", query = "SELECT s FROM SalesItems s WHERE s.price = :price")
  , @NamedQuery(name = "SalesItems.findByRefundqty", query = "SELECT s FROM SalesItems s WHERE s.refundqty = :refundqty")
  , @NamedQuery(name = "SalesItems.findBySiteguid", query = "SELECT s FROM SalesItems s WHERE s.siteguid = :siteguid")
  , @NamedQuery(name = "SalesItems.findBySflag", query = "SELECT s FROM SalesItems s WHERE s.sflag = :sflag")
})
public class SalesItems implements Serializable
{

  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @JoinColumn(name = "attributesetinstance_id", referencedColumnName = "id")
  @ManyToOne
  private Attributesetinstance attributesetinstanceId;
  @JoinColumn(name = "product", referencedColumnName = "id")
  @ManyToOne
  private Products product;
  @JoinColumn(name = "taxid", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Taxes taxid;

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "line")
  private int line;
  @Basic(optional = false)
  @NotNull
  @Column(name = "units")
  private double units;
  @Basic(optional = false)
  @NotNull
  @Column(name = "price")
  private double price;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "refundqty")
  private Double refundqty;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "salesId", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Sales salesId;

  public SalesItems()
  {
  }

  public SalesItems(Integer id)
  {
    this.id = id;
  }

  public SalesItems(Integer id, int line, double units, double price, String siteguid)
  {
    this.id = id;
    this.line = line;
    this.units = units;
    this.price = price;
    this.siteguid = siteguid;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public int getLine()
  {
    return line;
  }

  public void setLine(int line)
  {
    this.line = line;
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

  public Sales getSalesId()
  {
    return salesId;
  }

  public void setSalesId(Sales salesId)
  {
    this.salesId = salesId;
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
    if (!(object instanceof SalesItems))
    {
      return false;
    }
    SalesItems other = (SalesItems) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.SalesItems[ id=" + id + " ]";
  }

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }

  public Attributesetinstance getAttributesetinstanceId()
  {
    return attributesetinstanceId;
  }

  public void setAttributesetinstanceId(Attributesetinstance attributesetinstanceId)
  {
    this.attributesetinstanceId = attributesetinstanceId;
  }

  public Products getProduct()
  {
    return product;
  }

  public void setProduct(Products product)
  {
    this.product = product;
  }

  public Taxes getTaxid()
  {
    return taxid;
  }

  public void setTaxid(Taxes taxid)
  {
    this.taxid = taxid;
  }
  
}
