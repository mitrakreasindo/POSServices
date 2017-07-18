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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Type;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "receipts")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Receipts.findAll", query = "SELECT r FROM Receipts r")
  , @NamedQuery(name = "Receipts.findById", query = "SELECT r FROM Receipts r WHERE r.id = :id")
  , @NamedQuery(name = "Receipts.findByDatenew", query = "SELECT r FROM Receipts r WHERE r.datenew = :datenew")
  , @NamedQuery(name = "Receipts.findByPerson", query = "SELECT r FROM Receipts r WHERE r.person = :person")
  , @NamedQuery(name = "Receipts.findBySiteguid", query = "SELECT r FROM Receipts r WHERE r.siteguid = :siteguid")
  , @NamedQuery(name = "Receipts.findBySflag", query = "SELECT r FROM Receipts r WHERE r.sflag = :sflag")
})
public class Receipts implements Serializable
{

  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
  private Collection<Taxlines> taxlinesCollection;

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
  @Temporal(TemporalType.TIMESTAMP)
  private Date datenew;
  @Size(max = 255)
  @Column(name = "person")
  private String person;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "receipts")
  private Tickets tickets;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
  private Collection<Payments> paymentsCollection;
  @JoinColumn(name = "money", referencedColumnName = "money")
  @ManyToOne(optional = false)
  private Closedcash money;

  public Receipts()
  {
  }

  public Receipts(String id)
  {
    this.id = id;
  }

  public Receipts(String id, Date datenew, String siteguid)
  {
    this.id = id;
    this.datenew = datenew;
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

  public void setDatenew(Date datenew)
  {
    this.datenew = datenew;
  }

  public String getPerson()
  {
    return person;
  }

  public void setPerson(String person)
  {
    this.person = person;
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

  public Tickets getTickets()
  {
    return tickets;
  }

  public void setTickets(Tickets tickets)
  {
    this.tickets = tickets;
  }

  @XmlTransient
  public Collection<Payments> getPaymentsCollection()
  {
    return paymentsCollection;
  }

  public void setPaymentsCollection(Collection<Payments> paymentsCollection)
  {
    this.paymentsCollection = paymentsCollection;
  }

  public Closedcash getMoney()
  {
    return money;
  }

  public void setMoney(Closedcash money)
  {
    this.money = money;
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
    if (!(object instanceof Receipts))
    {
      return false;
    }
    Receipts other = (Receipts) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Receipts[ id=" + id + " ]";
  }

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
  }

  @XmlTransient
  public Collection<Taxlines> getTaxlinesCollection()
  {
    return taxlinesCollection;
  }

  public void setTaxlinesCollection(Collection<Taxlines> taxlinesCollection)
  {
    this.taxlinesCollection = taxlinesCollection;
  }
  
}
