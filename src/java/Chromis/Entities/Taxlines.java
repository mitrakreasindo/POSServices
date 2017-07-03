/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import Chromis.Entities.Receipts;
import Chromis.Entities.Taxes;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "taxlines")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Taxlines.findAll", query = "SELECT t FROM Taxlines t")
  , @NamedQuery(name = "Taxlines.findById", query = "SELECT t FROM Taxlines t WHERE t.id = :id")
  , @NamedQuery(name = "Taxlines.findByBase", query = "SELECT t FROM Taxlines t WHERE t.base = :base")
  , @NamedQuery(name = "Taxlines.findByAmount", query = "SELECT t FROM Taxlines t WHERE t.amount = :amount")
  , @NamedQuery(name = "Taxlines.findBySiteguid", query = "SELECT t FROM Taxlines t WHERE t.siteguid = :siteguid")
  , @NamedQuery(name = "Taxlines.findBySflag", query = "SELECT t FROM Taxlines t WHERE t.sflag = :sflag")
})
public class Taxlines implements Serializable
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
  @Column(name = "base")
  private double base;
  @Basic(optional = false)
  @NotNull
  @Column(name = "amount")
  private double amount;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "receipt", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Receipts receipt;
  @JoinColumn(name = "taxid", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Taxes taxid;

  public Taxlines()
  {
  }

  public Taxlines(String id)
  {
    this.id = id;
  }

  public Taxlines(String id, double base, double amount, String siteguid)
  {
    this.id = id;
    this.base = base;
    this.amount = amount;
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

  public double getBase()
  {
    return base;
  }

  public void setBase(double base)
  {
    this.base = base;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
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

  public Receipts getReceipt()
  {
    return receipt;
  }

  public void setReceipt(Receipts receipt)
  {
    this.receipt = receipt;
  }

  public Taxes getTaxid()
  {
    return taxid;
  }

  public void setTaxid(Taxes taxid)
  {
    this.taxid = taxid;
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
    if (!(object instanceof Taxlines))
    {
      return false;
    }
    Taxlines other = (Taxlines) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.TempEntities.Taxlines[ id=" + id + " ]";
  }
  
}
