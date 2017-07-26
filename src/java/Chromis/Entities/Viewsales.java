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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "viewsales")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewsales.findAll", query = "SELECT v FROM Viewsales v")
  , @NamedQuery(name = "Viewsales.findById", query = "SELECT v FROM Viewsales v WHERE v.id = :id")
  , @NamedQuery(name = "Viewsales.findBySalestype", query = "SELECT v FROM Viewsales v WHERE v.salestype = :salestype")
  , @NamedQuery(name = "Viewsales.findBySalesnum", query = "SELECT v FROM Viewsales v WHERE v.salesnum = :salesnum")
  , @NamedQuery(name = "Viewsales.findByPerson", query = "SELECT v FROM Viewsales v WHERE v.person = :person")
  , @NamedQuery(name = "Viewsales.findByCustomer", query = "SELECT v FROM Viewsales v WHERE v.customer = :customer")
  , @NamedQuery(name = "Viewsales.findByStatus", query = "SELECT v FROM Viewsales v WHERE v.status = :status")
  , @NamedQuery(name = "Viewsales.findBySiteguid", query = "SELECT v FROM Viewsales v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewsales.findBySflag", query = "SELECT v FROM Viewsales v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewsales.findByCustomerName", query = "SELECT v FROM Viewsales v WHERE v.customerName = :customerName")
  , @NamedQuery(name = "Viewsales.findByPersonName", query = "SELECT v FROM Viewsales v WHERE v.personName = :personName")
  , @NamedQuery(name = "Viewsales.findByDatenew", query = "SELECT v FROM Viewsales v WHERE v.datenew = :datenew")
})
public class Viewsales implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Column(name = "id")
  @Id
  private String id;
  @Column(name = "salestype")
  private Integer salestype;
  @Column(name = "salesnum")
  private Integer salesnum;
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
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;

  public Viewsales()
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

  public Integer getSalestype()
  {
    return salestype;
  }

  public void setSalestype(Integer salestype)
  {
    this.salestype = salestype;
  }

  public Integer getSalesnum()
  {
    return salesnum;
  }

  public void setSalesnum(Integer salesnum)
  {
    this.salesnum = salesnum;
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

  public String getDatenew()
  {
    return datenew;
  }

  public void setDatenew(String datenew)
  {
    this.datenew = datenew;
  }
  
}
