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
@Table(name = "viewreceipts")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewreceipts.findAll", query = "SELECT v FROM Viewreceipts v")
  , @NamedQuery(name = "Viewreceipts.findById", query = "SELECT v FROM Viewreceipts v WHERE v.id = :id")
  , @NamedQuery(name = "Viewreceipts.findByMoney", query = "SELECT v FROM Viewreceipts v WHERE v.money = :money")
  , @NamedQuery(name = "Viewreceipts.findByDatenew", query = "SELECT v FROM Viewreceipts v WHERE v.datenew = :datenew")
  , @NamedQuery(name = "Viewreceipts.findByPerson", query = "SELECT v FROM Viewreceipts v WHERE v.person = :person")
  , @NamedQuery(name = "Viewreceipts.findBySiteguid", query = "SELECT v FROM Viewreceipts v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewreceipts.findBySflag", query = "SELECT v FROM Viewreceipts v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewreceipts.findByHost", query = "SELECT v FROM Viewreceipts v WHERE v.host = :host")
})
public class Viewreceipts implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Column(name = "id")
  @Id
  private String id;
  @Size(max = 255)
  @Column(name = "money")
  private String money;
  @Column(name = "datenew")
  //@Temporal(TemporalType.TIMESTAMP)
  private String datenew;
  @Size(max = 255)
  @Column(name = "person")
  private String person;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Size(max = 255)
  @Column(name = "host")
  private String host;

  public Viewreceipts()
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

  public String getMoney()
  {
    return money;
  }

  public void setMoney(String money)
  {
    this.money = money;
  }

  public String getDatenew()
  {
    return datenew;
  }

  public void setDatenew(String datenew)
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

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
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

  public String getHost()
  {
    return host;
  }

  public void setHost(String host)
  {
    this.host = host;
  }
  
}
