/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "closedcash")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Closedcash.findAll", query = "SELECT c FROM Closedcash c")
  , @NamedQuery(name = "Closedcash.findByMoney", query = "SELECT c FROM Closedcash c WHERE c.money = :money")
  , @NamedQuery(name = "Closedcash.findByHost", query = "SELECT c FROM Closedcash c WHERE c.host = :host")
  , @NamedQuery(name = "Closedcash.findByHostsequence", query = "SELECT c FROM Closedcash c WHERE c.hostsequence = :hostsequence")
  , @NamedQuery(name = "Closedcash.findByDatestart", query = "SELECT c FROM Closedcash c WHERE c.datestart = :datestart")
  , @NamedQuery(name = "Closedcash.findByDateend", query = "SELECT c FROM Closedcash c WHERE c.dateend = :dateend")
  , @NamedQuery(name = "Closedcash.findByNosales", query = "SELECT c FROM Closedcash c WHERE c.nosales = :nosales")
  , @NamedQuery(name = "Closedcash.findBySiteguid", query = "SELECT c FROM Closedcash c WHERE c.siteguid = :siteguid")
  , @NamedQuery(name = "Closedcash.findBySflag", query = "SELECT c FROM Closedcash c WHERE c.sflag = :sflag")
})
public class Closedcash implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "money")
  private String money;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "host")
  private String host;
  @Basic(optional = false)
  @NotNull
  @Column(name = "hostsequence")
  private int hostsequence;
  @Basic(optional = false)
  @NotNull
  @Column(name = "datestart")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datestart;
  @Column(name = "dateend")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateend;
  @Basic(optional = false)
  @NotNull
  @Column(name = "nosales")
  private int nosales;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  //@OneToMany(cascade = CascadeType.ALL, mappedBy = "money")
  //private Collection<Receipts> receiptsCollection;

  public Closedcash()
  {
  }

  public Closedcash(String money)
  {
    this.money = money;
  }

  public Closedcash(String money, String host, int hostsequence, Date datestart, int nosales, String siteguid)
  {
    this.money = money;
    this.host = host;
    this.hostsequence = hostsequence;
    this.datestart = datestart;
    this.nosales = nosales;
    this.siteguid = siteguid;
  }

  public String getMoney()
  {
    return money;
  }

  public void setMoney(String money)
  {
    this.money = money;
  }

  public String getHost()
  {
    return host;
  }

  public void setHost(String host)
  {
    this.host = host;
  }

  public int getHostsequence()
  {
    return hostsequence;
  }

  public void setHostsequence(int hostsequence)
  {
    this.hostsequence = hostsequence;
  }

  public Date getDatestart()
  {
    return datestart;
  }

  public void setDatestart(Date datestart)
  {
    this.datestart = datestart;
  }

  public Date getDateend()
  {
    return dateend;
  }

  public void setDateend(Date dateend)
  {
    this.dateend = dateend;
  }

  public int getNosales()
  {
    return nosales;
  }

  public void setNosales(int nosales)
  {
    this.nosales = nosales;
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

//  @XmlTransient
//  public Collection<Receipts> getReceiptsCollection()
//  {
//    return receiptsCollection;
//  }
//
//  public void setReceiptsCollection(Collection<Receipts> receiptsCollection)
//  {
//    this.receiptsCollection = receiptsCollection;
//  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (money != null ? money.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Closedcash))
    {
      return false;
    }
    Closedcash other = (Closedcash) object;
    if ((this.money == null && other.money != null) || (this.money != null && !this.money.equals(other.money)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Closedcash[ money=" + money + " ]";
  }
  
}
