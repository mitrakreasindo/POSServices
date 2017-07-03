/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "ticketlines")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Ticketlines.findAll", query = "SELECT t FROM Ticketlines t")
  , @NamedQuery(name = "Ticketlines.findByTicket", query = "SELECT t FROM Ticketlines t WHERE t.ticketlinesPK.ticket = :ticket")
  , @NamedQuery(name = "Ticketlines.findByLine", query = "SELECT t FROM Ticketlines t WHERE t.ticketlinesPK.line = :line")
  , @NamedQuery(name = "Ticketlines.findByUnits", query = "SELECT t FROM Ticketlines t WHERE t.units = :units")
  , @NamedQuery(name = "Ticketlines.findByPrice", query = "SELECT t FROM Ticketlines t WHERE t.price = :price")
  , @NamedQuery(name = "Ticketlines.findByRefundqty", query = "SELECT t FROM Ticketlines t WHERE t.refundqty = :refundqty")
  , @NamedQuery(name = "Ticketlines.findBySiteguid", query = "SELECT t FROM Ticketlines t WHERE t.siteguid = :siteguid")
  , @NamedQuery(name = "Ticketlines.findBySflag", query = "SELECT t FROM Ticketlines t WHERE t.sflag = :sflag")
})
public class Ticketlines implements Serializable
{

  @Lob
  @Column(name = "attributes")
  private byte[] attributes;

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected TicketlinesPK ticketlinesPK;
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
  @JoinColumn(name = "attributesetinstance_id", referencedColumnName = "id")
  @ManyToOne
  private Attributesetinstance attributesetinstanceId;
  @JoinColumn(name = "product", referencedColumnName = "id")
  @ManyToOne
  private Products product;
  @JoinColumn(name = "taxid", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Taxes taxid;
  @JoinColumn(name = "ticket", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Tickets tickets;

  public Ticketlines()
  {
  }

  public Ticketlines(TicketlinesPK ticketlinesPK)
  {
    this.ticketlinesPK = ticketlinesPK;
  }

  public Ticketlines(TicketlinesPK ticketlinesPK, double units, double price, String siteguid)
  {
    this.ticketlinesPK = ticketlinesPK;
    this.units = units;
    this.price = price;
    this.siteguid = siteguid;
  }

  public Ticketlines(String ticket, int line)
  {
    this.ticketlinesPK = new TicketlinesPK(ticket, line);
  }

  public TicketlinesPK getTicketlinesPK()
  {
    return ticketlinesPK;
  }

  public void setTicketlinesPK(TicketlinesPK ticketlinesPK)
  {
    this.ticketlinesPK = ticketlinesPK;
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

  public Tickets getTickets()
  {
    return tickets;
  }

  public void setTickets(Tickets tickets)
  {
    this.tickets = tickets;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (ticketlinesPK != null ? ticketlinesPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Ticketlines))
    {
      return false;
    }
    Ticketlines other = (Ticketlines) object;
    if ((this.ticketlinesPK == null && other.ticketlinesPK != null) || (this.ticketlinesPK != null && !this.ticketlinesPK.equals(other.ticketlinesPK)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Ticketlines[ ticketlinesPK=" + ticketlinesPK + " ]";
  }

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }
  
}
