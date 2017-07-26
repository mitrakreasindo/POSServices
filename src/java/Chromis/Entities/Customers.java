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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
  , @NamedQuery(name = "Customers.findById", query = "SELECT c FROM Customers c WHERE c.id = :id")
  , @NamedQuery(name = "Customers.findBySearchkey", query = "SELECT c FROM Customers c WHERE c.searchkey = :searchkey")
  , @NamedQuery(name = "Customers.findByTaxid", query = "SELECT c FROM Customers c WHERE c.taxid = :taxid")
  , @NamedQuery(name = "Customers.findByName", query = "SELECT c FROM Customers c WHERE c.name = :name")
  , @NamedQuery(name = "Customers.findByCard", query = "SELECT c FROM Customers c WHERE c.card = :card")
  , @NamedQuery(name = "Customers.findByMaxdebt", query = "SELECT c FROM Customers c WHERE c.maxdebt = :maxdebt")
  , @NamedQuery(name = "Customers.findByAddress", query = "SELECT c FROM Customers c WHERE c.address = :address")
  , @NamedQuery(name = "Customers.findByAddress2", query = "SELECT c FROM Customers c WHERE c.address2 = :address2")
  , @NamedQuery(name = "Customers.findByPostal", query = "SELECT c FROM Customers c WHERE c.postal = :postal")
  , @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city")
  , @NamedQuery(name = "Customers.findByRegion", query = "SELECT c FROM Customers c WHERE c.region = :region")
  , @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country")
  , @NamedQuery(name = "Customers.findByFirstname", query = "SELECT c FROM Customers c WHERE c.firstname = :firstname")
  , @NamedQuery(name = "Customers.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname")
  , @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email")
  , @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")
  , @NamedQuery(name = "Customers.findByPhone2", query = "SELECT c FROM Customers c WHERE c.phone2 = :phone2")
  , @NamedQuery(name = "Customers.findByFax", query = "SELECT c FROM Customers c WHERE c.fax = :fax")
  , @NamedQuery(name = "Customers.findByNotes", query = "SELECT c FROM Customers c WHERE c.notes = :notes")
  , @NamedQuery(name = "Customers.findByVisible", query = "SELECT c FROM Customers c WHERE c.visible = :visible")
  , @NamedQuery(name = "Customers.findByCurdate", query = "SELECT c FROM Customers c WHERE c.curdate = :curdate")
  , @NamedQuery(name = "Customers.findByCurdebt", query = "SELECT c FROM Customers c WHERE c.curdebt = :curdebt")
  , @NamedQuery(name = "Customers.findByDiscount", query = "SELECT c FROM Customers c WHERE c.discount = :discount")
  , @NamedQuery(name = "Customers.findByDob", query = "SELECT c FROM Customers c WHERE c.dob = :dob")
  , @NamedQuery(name = "Customers.findBySiteguid", query = "SELECT c FROM Customers c WHERE c.siteguid = :siteguid")
  , @NamedQuery(name = "Customers.findBySflag", query = "SELECT c FROM Customers c WHERE c.sflag = :sflag")
})
public class Customers implements Serializable
{

  @Lob
  @Column(name = "image")
  private byte[] image;
  @OneToMany(mappedBy = "customer")
  private Collection<Sales> salesCollection;

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
  @Column(name = "searchkey")
  private String searchkey;
  @Size(max = 255)
  @Column(name = "taxid")
  private String taxid;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Size(max = 255)
  @Column(name = "card")
  private String card;
  @Basic(optional = false)
  @NotNull
  @Column(name = "maxdebt")
  private double maxdebt;
  @Size(max = 255)
  @Column(name = "address")
  private String address;
  @Size(max = 255)
  @Column(name = "address2")
  private String address2;
  @Size(max = 255)
  @Column(name = "postal")
  private String postal;
  @Size(max = 255)
  @Column(name = "city")
  private String city;
  @Size(max = 255)
  @Column(name = "region")
  private String region;
  @Size(max = 255)
  @Column(name = "country")
  private String country;
  @Size(max = 255)
  @Column(name = "firstname")
  private String firstname;
  @Size(max = 255)
  @Column(name = "lastname")
  private String lastname;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "email")
  private String email;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "phone")
  private String phone;
  @Size(max = 255)
  @Column(name = "phone2")
  private String phone2;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "fax")
  private String fax;
  @Size(max = 255)
  @Column(name = "notes")
  private String notes;
  @Basic(optional = false)
  @NotNull
  @Column(name = "visible")
  private boolean visible;
  @Column(name = "curdate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date curdate;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "curdebt")
  private Double curdebt;
  @Column(name = "discount")
  private Double discount;
  @Column(name = "dob")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dob;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "taxcategory", referencedColumnName = "id")
  @ManyToOne
  private Taxcustcategories taxcategory;

  public Customers()
  {
  }

  public Customers(String id)
  {
    this.id = id;
  }

  public Customers(String id, String searchkey, String name, double maxdebt, boolean visible, String siteguid)
  {
    this.id = id;
    this.searchkey = searchkey;
    this.name = name;
    this.maxdebt = maxdebt;
    this.visible = visible;
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

  public String getSearchkey()
  {
    return searchkey;
  }

  public void setSearchkey(String searchkey)
  {
    this.searchkey = searchkey;
  }

  public String getTaxid()
  {
    return taxid;
  }

  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getCard()
  {
    return card;
  }

  public void setCard(String card)
  {
    this.card = card;
  }

  public double getMaxdebt()
  {
    return maxdebt;
  }

  public void setMaxdebt(double maxdebt)
  {
    this.maxdebt = maxdebt;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getAddress2()
  {
    return address2;
  }

  public void setAddress2(String address2)
  {
    this.address2 = address2;
  }

  public String getPostal()
  {
    return postal;
  }

  public void setPostal(String postal)
  {
    this.postal = postal;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getPhone2()
  {
    return phone2;
  }

  public void setPhone2(String phone2)
  {
    this.phone2 = phone2;
  }

  public String getFax()
  {
    return fax;
  }

  public void setFax(String fax)
  {
    this.fax = fax;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public boolean getVisible()
  {
    return visible;
  }

  public void setVisible(boolean visible)
  {
    this.visible = visible;
  }

  public Date getCurdate()
  {
    return curdate;
  }

  public void setCurdate(Date curdate)
  {
    this.curdate = curdate;
  }

  public Double getCurdebt()
  {
    return curdebt;
  }

  public void setCurdebt(Double curdebt)
  {
    this.curdebt = curdebt;
  }


  public Double getDiscount()
  {
    return discount;
  }

  public void setDiscount(Double discount)
  {
    this.discount = discount;
  }

  public Date getDob()
  {
    return dob;
  }

  public void setDob(Date dob)
  {
    this.dob = dob;
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

  public Taxcustcategories getTaxcategory()
  {
    return taxcategory;
  }

  public void setTaxcategory(Taxcustcategories taxcategory)
  {
    this.taxcategory = taxcategory;
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
    if (!(object instanceof Customers))
    {
      return false;
    }
    Customers other = (Customers) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Customers[ id=" + id + " ]";
  }

  public byte[] getImage()
  {
    return image;
  }

  public void setImage(byte[] image)
  {
    this.image = image;
  }

  @XmlTransient
  @JsonIgnore
  public Collection<Sales> getSalesCollection()
  {
    return salesCollection;
  }

  public void setSalesCollection(Collection<Sales> salesCollection)
  {
    this.salesCollection = salesCollection;
  }
  
}
