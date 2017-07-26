/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "viewtaxlines")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Viewtaxlines.findAll", query = "SELECT v FROM Viewtaxlines v")
  , @NamedQuery(name = "Viewtaxlines.findById", query = "SELECT v FROM Viewtaxlines v WHERE v.id = :id")
  , @NamedQuery(name = "Viewtaxlines.findByReceipt", query = "SELECT v FROM Viewtaxlines v WHERE v.receipt = :receipt")
  , @NamedQuery(name = "Viewtaxlines.findByTaxid", query = "SELECT v FROM Viewtaxlines v WHERE v.taxid = :taxid")
  , @NamedQuery(name = "Viewtaxlines.findByBase", query = "SELECT v FROM Viewtaxlines v WHERE v.base = :base")
  , @NamedQuery(name = "Viewtaxlines.findByAmount", query = "SELECT v FROM Viewtaxlines v WHERE v.amount = :amount")
  , @NamedQuery(name = "Viewtaxlines.findBySiteguid", query = "SELECT v FROM Viewtaxlines v WHERE v.siteguid = :siteguid")
  , @NamedQuery(name = "Viewtaxlines.findBySflag", query = "SELECT v FROM Viewtaxlines v WHERE v.sflag = :sflag")
  , @NamedQuery(name = "Viewtaxlines.findByTaxName", query = "SELECT v FROM Viewtaxlines v WHERE v.taxName = :taxName")
})
public class Viewtaxlines implements Serializable
{

  private static final long serialVersionUID = 1L;
  @Size(max = 255)
  @Column(name = "id")
  @Id
  private String id;
  @Size(max = 255)
  @Column(name = "receipt")
  private String receipt;
  @Size(max = 255)
  @Column(name = "taxid")
  private String taxid;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "base")
  private Double base;
  @Column(name = "amount")
  private Double amount;
  @Size(max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @Size(max = 255)
  @Column(name = "tax_name")
  private String taxName;

  public Viewtaxlines()
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

  public String getReceipt()
  {
    return receipt;
  }

  public void setReceipt(String receipt)
  {
    this.receipt = receipt;
  }

  public String getTaxid()
  {
    return taxid;
  }

  public void setTaxid(String taxid)
  {
    this.taxid = taxid;
  }

  public Double getBase()
  {
    return base;
  }

  public void setBase(Double base)
  {
    this.base = base;
  }

  public Double getAmount()
  {
    return amount;
  }

  public void setAmount(Double amount)
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

  public String getTaxName()
  {
    return taxName;
  }

  public void setTaxName(String taxName)
  {
    this.taxName = taxName;
  }
  
}
