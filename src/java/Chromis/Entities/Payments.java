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

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "payments")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p")
  , @NamedQuery(name = "Payments.findById", query = "SELECT p FROM Payments p WHERE p.id = :id")
  , @NamedQuery(name = "Payments.findByPayment", query = "SELECT p FROM Payments p WHERE p.payment = :payment")
  , @NamedQuery(name = "Payments.findByTotal", query = "SELECT p FROM Payments p WHERE p.total = :total")
  , @NamedQuery(name = "Payments.findByTransid", query = "SELECT p FROM Payments p WHERE p.transid = :transid")
  , @NamedQuery(name = "Payments.findByNotes", query = "SELECT p FROM Payments p WHERE p.notes = :notes")
  , @NamedQuery(name = "Payments.findByTendered", query = "SELECT p FROM Payments p WHERE p.tendered = :tendered")
  , @NamedQuery(name = "Payments.findByCardname", query = "SELECT p FROM Payments p WHERE p.cardname = :cardname")
  , @NamedQuery(name = "Payments.findBySiteguid", query = "SELECT p FROM Payments p WHERE p.siteguid = :siteguid")
  , @NamedQuery(name = "Payments.findBySflag", query = "SELECT p FROM Payments p WHERE p.sflag = :sflag")
})
public class Payments implements Serializable
{

  @Lob
  @Column(name = "returnmsg")
  private byte[] returnmsg;

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
  @Column(name = "payment")
  private String payment;
  @Basic(optional = false)
  @NotNull
  @Column(name = "total")
  private double total;
  @Size(max = 255)
  @Column(name = "transid")
  private String transid;
  @Size(max = 255)
  @Column(name = "notes")
  private String notes;
  @Basic(optional = false)
  @NotNull
  @Column(name = "tendered")
  private double tendered;
  @Size(max = 255)
  @Column(name = "cardname")
  private String cardname;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "receipt", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Receipts receipt;

  public Payments()
  {
  }

  public Payments(String id)
  {
    this.id = id;
  }

  public Payments(String id, String payment, double total, double tendered, String siteguid)
  {
    this.id = id;
    this.payment = payment;
    this.total = total;
    this.tendered = tendered;
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

  public String getPayment()
  {
    return payment;
  }

  public void setPayment(String payment)
  {
    this.payment = payment;
  }

  public double getTotal()
  {
    return total;
  }

  public void setTotal(double total)
  {
    this.total = total;
  }

  public String getTransid()
  {
    return transid;
  }

  public void setTransid(String transid)
  {
    this.transid = transid;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public double getTendered()
  {
    return tendered;
  }

  public void setTendered(double tendered)
  {
    this.tendered = tendered;
  }

  public String getCardname()
  {
    return cardname;
  }

  public void setCardname(String cardname)
  {
    this.cardname = cardname;
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

  public Receipts getReceipt()
  {
    return receipt;
  }

  public void setReceipt(Receipts receipt)
  {
    this.receipt = receipt;
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
    if (!(object instanceof Payments))
    {
      return false;
    }
    Payments other = (Payments) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Payments[ id=" + id + " ]";
  }

  public byte[] getReturnmsg()
  {
    return returnmsg;
  }

  public void setReturnmsg(byte[] returnmsg)
  {
    this.returnmsg = returnmsg;
  }
  
}
