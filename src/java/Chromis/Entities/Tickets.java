/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "tickets")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t")
  , @NamedQuery(name = "Tickets.findById", query = "SELECT t FROM Tickets t WHERE t.id = :id")
  , @NamedQuery(name = "Tickets.findByTickettype", query = "SELECT t FROM Tickets t WHERE t.tickettype = :tickettype")
  , @NamedQuery(name = "Tickets.findByTicketid", query = "SELECT t FROM Tickets t WHERE t.ticketid = :ticketid")
  , @NamedQuery(name = "Tickets.findByStatus", query = "SELECT t FROM Tickets t WHERE t.status = :status")
  , @NamedQuery(name = "Tickets.findBySiteguid", query = "SELECT t FROM Tickets t WHERE t.siteguid = :siteguid")
  , @NamedQuery(name = "Tickets.findBySflag", query = "SELECT t FROM Tickets t WHERE t.sflag = :sflag")
})
public class Tickets implements Serializable
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
  @Column(name = "tickettype")
  private int tickettype;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ticketid")
  private int ticketid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "status")
  private int status;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "customer", referencedColumnName = "id")
  @ManyToOne
  private Customers customer;
  @JoinColumn(name = "person", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private People person;
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private Receipts receipts;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tickets")
  private Collection<Ticketlines> ticketlinesCollection;

  public Tickets()
  {
  }

  public Tickets(String id)
  {
    this.id = id;
  }

  public Tickets(String id, int tickettype, int ticketid, int status, String siteguid)
  {
    this.id = id;
    this.tickettype = tickettype;
    this.ticketid = ticketid;
    this.status = status;
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

  public int getTickettype()
  {
    return tickettype;
  }

  public void setTickettype(int tickettype)
  {
    this.tickettype = tickettype;
  }

  public int getTicketid()
  {
    return ticketid;
  }

  public void setTicketid(int ticketid)
  {
    this.ticketid = ticketid;
  }

  public int getStatus()
  {
    return status;
  }

  public void setStatus(int status)
  {
    this.status = status;
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

  public Customers getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customers customer)
  {
    this.customer = customer;
  }

  public People getPerson()
  {
    return person;
  }

  public void setPerson(People person)
  {
    this.person = person;
  }

  public Receipts getReceipts()
  {
    return receipts;
  }

  public void setReceipts(Receipts receipts)
  {
    this.receipts = receipts;
  }

  @XmlTransient
  public Collection<Ticketlines> getTicketlinesCollection()
  {
    return ticketlinesCollection;
  }

  public void setTicketlinesCollection(Collection<Ticketlines> ticketlinesCollection)
  {
    this.ticketlinesCollection = ticketlinesCollection;
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
    if (!(object instanceof Tickets))
    {
      return false;
    }
    Tickets other = (Tickets) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Tickets[ id=" + id + " ]";
  }
  
}
