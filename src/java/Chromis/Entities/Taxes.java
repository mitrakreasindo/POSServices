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
@Table(name = "taxes")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Taxes.findAll", query = "SELECT t FROM Taxes t")
  , @NamedQuery(name = "Taxes.findById", query = "SELECT t FROM Taxes t WHERE t.id = :id")
  , @NamedQuery(name = "Taxes.findByName", query = "SELECT t FROM Taxes t WHERE t.name = :name")
  , @NamedQuery(name = "Taxes.findByRate", query = "SELECT t FROM Taxes t WHERE t.rate = :rate")
  , @NamedQuery(name = "Taxes.findByRatecascade", query = "SELECT t FROM Taxes t WHERE t.ratecascade = :ratecascade")
  , @NamedQuery(name = "Taxes.findByRateorder", query = "SELECT t FROM Taxes t WHERE t.rateorder = :rateorder")
  , @NamedQuery(name = "Taxes.findBySiteguid", query = "SELECT t FROM Taxes t WHERE t.siteguid = :siteguid")
  , @NamedQuery(name = "Taxes.findBySflag", query = "SELECT t FROM Taxes t WHERE t.sflag = :sflag")
})
public class Taxes implements Serializable
{

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxid")
  private Collection<SalesItems> salesItemsCollection;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxid")
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
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Column(name = "rate")
  private double rate;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ratecascade")
  private boolean ratecascade;
  @Column(name = "rateorder")
  private Integer rateorder;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Taxcategories category;
  @JoinColumn(name = "custcategory", referencedColumnName = "id")
  @ManyToOne
  private Taxcustcategories custcategory;
  @OneToMany(mappedBy = "parentid")
  private Collection<Taxes> taxesCollection;
  @JoinColumn(name = "parentid", referencedColumnName = "id")
  @ManyToOne
  private Taxes parentid;
  
  public Taxes()
  {
  }

  public Taxes(String id)
  {
    this.id = id;
  }

  public Taxes(String id, String name, double rate, boolean ratecascade, String siteguid)
  {
    this.id = id;
    this.name = name;
    this.rate = rate;
    this.ratecascade = ratecascade;
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

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public double getRate()
  {
    return rate;
  }

  public void setRate(double rate)
  {
    this.rate = rate;
  }

  public boolean getRatecascade()
  {
    return ratecascade;
  }

  public void setRatecascade(boolean ratecascade)
  {
    this.ratecascade = ratecascade;
  }

  public Integer getRateorder()
  {
    return rateorder;
  }

  public void setRateorder(Integer rateorder)
  {
    this.rateorder = rateorder;
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

  public Taxcategories getCategory()
  {
    return category;
  }

  public void setCategory(Taxcategories category)
  {
    this.category = category;
  }

  public Taxcustcategories getCustcategory()
  {
    return custcategory;
  }

  public void setCustcategory(Taxcustcategories custcategory)
  {
    this.custcategory = custcategory;
  }

  @XmlTransient
  public Collection<Taxes> getTaxesCollection()
  {
    return taxesCollection;
  }

  public void setTaxesCollection(Collection<Taxes> taxesCollection)
  {
    this.taxesCollection = taxesCollection;
  }

  public Taxes getParentid()
  {
    return parentid;
  }

  public void setParentid(Taxes parentid)
  {
    this.parentid = parentid;
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
    if (!(object instanceof Taxes))
    {
      return false;
    }
    Taxes other = (Taxes) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Taxes[ id=" + id + " ]";
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
  
}
