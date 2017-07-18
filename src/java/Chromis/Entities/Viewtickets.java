/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "viewtickets")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewtickets.findAll", query = "SELECT v FROM Viewtickets v")
  , @NamedQuery(name = "Viewtickets.findById", query = "SELECT v FROM Viewtickets v WHERE v.id = :id")
  , @NamedQuery(name = "Viewtickets.findByTickettype", query = "SELECT v FROM Viewtickets v WHERE v.tickettype = :tickettype")
  , @NamedQuery(name = "Viewtickets.findByTicketid", query = "SELECT v FROM Viewtickets v WHERE v.ticketid = :ticketid")
  , @NamedQuery(name = "Viewtickets.findByPerson", query = "SELECT v FROM Viewtickets v WHERE v.person = :person")
  , @NamedQuery(name = "Viewtickets.findByCustomer", query = "SELECT v FROM Viewtickets v WHERE v.customer = :customer")
  , @NamedQuery(name = "Viewtickets.findByStatus", query = "SELECT v FROM Viewtickets v WHERE v.status = :status")
  , @NamedQuery(name = "Viewtickets.findBySiteguid", query = "SELECT v FROM Viewtickets v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewtickets.findBySflag", query = "SELECT v FROM Viewtickets v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewtickets.findByCustomerName", query = "SELECT v FROM Viewtickets v WHERE v.customerName = :customerName")
  , @NamedQuery(name = "Viewtickets.findByPersonName", query = "SELECT v FROM Viewtickets v WHERE v.personName = :personName")
  , @NamedQuery(name = "Viewtickets.findByDatenew", query = "SELECT v FROM Viewtickets v WHERE v.datenew = :datenew")
})
public class Viewtickets implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "tickettype")
  private Integer tickettype;
  @Column(name = "ticketid")
  private Integer ticketid;
  @Size(max = 255)
  @Column(name = "person")
  private String person;
  @Size(max = 255)
  @Column(name = "customer")
  private String customer;
  @Column(name = "status")
  private Integer status;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Size(max = 255)
  @Column(name = "customer_name")
  private String customerName;
  @Size(max = 255)
  @Column(name = "person_name")
  private String personName;
  @Column(name = "datenew")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datenew;
  
  //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tickets")
  private Collection<Viewticketlines> ticketlinesCollection;

  public Viewtickets()
  {
  }

  @XmlTransient
  public Collection<Viewticketlines> getTicketlinesCollection()
  {
    return ticketlinesCollection;
  }

  public void setTicketlinesCollection(Collection<Viewticketlines> ticketlinesCollection)
  {
    this.ticketlinesCollection = ticketlinesCollection;
  }

  
  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public Integer getTickettype()
  {
    return tickettype;
  }

  public void setTickettype(Integer tickettype)
  {
    this.tickettype = tickettype;
  }

  public Integer getTicketid()
  {
    return ticketid;
  }

  public void setTicketid(Integer ticketid)
  {
    this.ticketid = ticketid;
  }

  public String getPerson()
  {
    return person;
  }

  public void setPerson(String person)
  {
    this.person = person;
  }

  public String getCustomer()
  {
    return customer;
  }

  public void setCustomer(String customer)
  {
    this.customer = customer;
  }

  public Integer getStatus()
  {
    return status;
  }

  public void setStatus(Integer status)
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

  public String getCustomerName()
  {
    return customerName;
  }

  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }

  public String getPersonName()
  {
    return personName;
  }

  public void setPersonName(String personName)
  {
    this.personName = personName;
  }

  public Date getDatenew()
  {
    return datenew;
  }

  public void setDatenew(Date datenew)
  {
    this.datenew = datenew;
  }
  
}
