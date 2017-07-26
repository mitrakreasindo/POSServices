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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
  , @NamedQuery(name = "Sales.findById", query = "SELECT s FROM Sales s WHERE s.id = :id")
  , @NamedQuery(name = "Sales.findByStatus", query = "SELECT s FROM Sales s WHERE s.status = :status")
  , @NamedQuery(name = "Sales.findBySiteguid", query = "SELECT s FROM Sales s WHERE s.siteguid = :siteguid")
  , @NamedQuery(name = "Sales.findBySflag", query = "SELECT s FROM Sales s WHERE s.sflag = :sflag")
})
public class Sales implements Serializable
{

  @JoinColumn(name = "customer", referencedColumnName = "id")
  @ManyToOne
  private Customers customer;
  @JoinColumn(name = "person", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private People person;
  @JoinColumn(name = "id", referencedColumnName = "id")
  @OneToOne(optional = false)
  private Receipts receipts;

  @Basic(optional = false)
  @NotNull
  @Column(name = "salestype")
  private int salestype;
  @Basic(optional = false)
  @NotNull
  @Column(name = "salesnum")
  private int salesnum;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesId")
  private Collection<SalesItems> salesItemsCollection;

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "id")
  private String id;
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

  public Sales()
  {
  }

  public Sales(String id)
  {
    this.id = id;
  }

  public Sales(String id, int status, String siteguid)
  {
    this.id = id;
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
    if (!(object instanceof Sales))
    {
      return false;
    }
    Sales other = (Sales) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Sales[ id=" + id + " ]";
  }

  public int getSalestype()
  {
    return salestype;
  }

  public void setSalestype(int salestype)
  {
    this.salestype = salestype;
  }

  public int getSalesnum()
  {
    return salesnum;
  }

  public void setSalesnum(int salesnum)
  {
    this.salesnum = salesnum;
  }

  @XmlTransient
  @JsonIgnore
  public Collection<SalesItems> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }

  public void setSalesItemsCollection(Collection<SalesItems> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
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
  
}
