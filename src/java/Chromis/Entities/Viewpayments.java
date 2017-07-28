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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "viewpayments")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewpayments.findAll", query = "SELECT v FROM Viewpayments v")
  , @NamedQuery(name = "Viewpayments.findById", query = "SELECT v FROM Viewpayments v WHERE v.id = :id")
  , @NamedQuery(name = "Viewpayments.findByReceipt", query = "SELECT v FROM Viewpayments v WHERE v.receipt = :receipt")
  , @NamedQuery(name = "Viewpayments.findByPayment", query = "SELECT v FROM Viewpayments v WHERE v.payment = :payment")
  , @NamedQuery(name = "Viewpayments.findByTotal", query = "SELECT v FROM Viewpayments v WHERE v.total = :total")
  , @NamedQuery(name = "Viewpayments.findByTransid", query = "SELECT v FROM Viewpayments v WHERE v.transid = :transid")
  , @NamedQuery(name = "Viewpayments.findByNotes", query = "SELECT v FROM Viewpayments v WHERE v.notes = :notes")
  , @NamedQuery(name = "Viewpayments.findByTendered", query = "SELECT v FROM Viewpayments v WHERE v.tendered = :tendered")
  , @NamedQuery(name = "Viewpayments.findByCardname", query = "SELECT v FROM Viewpayments v WHERE v.cardname = :cardname")
  , @NamedQuery(name = "Viewpayments.findBySiteguid", query = "SELECT v FROM Viewpayments v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewpayments.findBySflag", query = "SELECT v FROM Viewpayments v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewpayments.findByDatenew", query = "SELECT v FROM Viewpayments v WHERE v.datenew = :datenew")
})
public class Viewpayments implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Column(name = "id")
  @Id
  private String id;
  @Size(max = 255)
  @Column(name = "receipt")
  private String receipt;
  @Size(max = 255)
  @Column(name = "payment")
  private String payment;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "total")
  private Double total;
  @Size(max = 255)
  @Column(name = "transid")
  private String transid;
  @Size(max = 255)
  @Column(name = "notes")
  private String notes;
  @Column(name = "tendered")
  private Double tendered;
  @Size(max = 255)
  @Column(name = "cardname")
  private String cardname;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "returnmsg")
  private byte[] returnmsg;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;

  public Viewpayments()
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

  public String getReceipt()
  {
    return receipt;
  }

  public void setReceipt(String receipt)
  {
    this.receipt = receipt;
  }

  public String getPayment()
  {
    return payment;
  }

  public void setPayment(String payment)
  {
    this.payment = payment;
  }

  public Double getTotal()
  {
    return total;
  }

  public void setTotal(Double total)
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

  public Double getTendered()
  {
    return tendered;
  }

  public void setTendered(Double tendered)
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

  public byte[] getReturnmsg()
  {
    return returnmsg;
  }

  public void setReturnmsg(byte[] returnmsg)
  {
    this.returnmsg = returnmsg;
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

  public String getDatenew()
  {
    return datenew;
  }

  public void setDatenew(String datenew)
  {
    this.datenew = datenew;
  }
  
}
