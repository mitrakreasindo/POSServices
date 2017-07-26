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
import javax.persistence.Lob;
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
import org.hibernate.annotations.Type;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
  , @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id")
  , @NamedQuery(name = "Products.findByReference", query = "SELECT p FROM Products p WHERE p.reference = :reference")
  , @NamedQuery(name = "Products.findByCode", query = "SELECT p FROM Products p WHERE p.code = :code")
  , @NamedQuery(name = "Products.findByCodetype", query = "SELECT p FROM Products p WHERE p.codetype = :codetype")
  , @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
  , @NamedQuery(name = "Products.findByPricebuy", query = "SELECT p FROM Products p WHERE p.pricebuy = :pricebuy")
  , @NamedQuery(name = "Products.findByPricesell", query = "SELECT p FROM Products p WHERE p.pricesell = :pricesell")
  , @NamedQuery(name = "Products.findByStockcost", query = "SELECT p FROM Products p WHERE p.stockcost = :stockcost")
  , @NamedQuery(name = "Products.findByStockvolume", query = "SELECT p FROM Products p WHERE p.stockvolume = :stockvolume")
  , @NamedQuery(name = "Products.findByIscom", query = "SELECT p FROM Products p WHERE p.iscom = :iscom")
  , @NamedQuery(name = "Products.findByIsscale", query = "SELECT p FROM Products p WHERE p.isscale = :isscale")
  , @NamedQuery(name = "Products.findByIskitchen", query = "SELECT p FROM Products p WHERE p.iskitchen = :iskitchen")
  , @NamedQuery(name = "Products.findByPrintkb", query = "SELECT p FROM Products p WHERE p.printkb = :printkb")
  , @NamedQuery(name = "Products.findBySendstatus", query = "SELECT p FROM Products p WHERE p.sendstatus = :sendstatus")
  , @NamedQuery(name = "Products.findByIsservice", query = "SELECT p FROM Products p WHERE p.isservice = :isservice")
  , @NamedQuery(name = "Products.findByDisplay", query = "SELECT p FROM Products p WHERE p.display = :display")
  , @NamedQuery(name = "Products.findByIsvprice", query = "SELECT p FROM Products p WHERE p.isvprice = :isvprice")
  , @NamedQuery(name = "Products.findByIsverpatrib", query = "SELECT p FROM Products p WHERE p.isverpatrib = :isverpatrib")
  , @NamedQuery(name = "Products.findByTexttip", query = "SELECT p FROM Products p WHERE p.texttip = :texttip")
  , @NamedQuery(name = "Products.findByWarranty", query = "SELECT p FROM Products p WHERE p.warranty = :warranty")
  , @NamedQuery(name = "Products.findByStockunits", query = "SELECT p FROM Products p WHERE p.stockunits = :stockunits")
  , @NamedQuery(name = "Products.findByAlias", query = "SELECT p FROM Products p WHERE p.alias = :alias")
  , @NamedQuery(name = "Products.findByAlwaysavailable", query = "SELECT p FROM Products p WHERE p.alwaysavailable = :alwaysavailable")
  , @NamedQuery(name = "Products.findByDiscounted", query = "SELECT p FROM Products p WHERE p.discounted = :discounted")
  , @NamedQuery(name = "Products.findByCandiscount", query = "SELECT p FROM Products p WHERE p.candiscount = :candiscount")
  , @NamedQuery(name = "Products.findByIscatalog", query = "SELECT p FROM Products p WHERE p.iscatalog = :iscatalog")
  , @NamedQuery(name = "Products.findByCatorder", query = "SELECT p FROM Products p WHERE p.catorder = :catorder")
  , @NamedQuery(name = "Products.findByIspack", query = "SELECT p FROM Products p WHERE p.ispack = :ispack")
  , @NamedQuery(name = "Products.findByPackquantity", query = "SELECT p FROM Products p WHERE p.packquantity = :packquantity")
  , @NamedQuery(name = "Products.findByAllproducts", query = "SELECT p FROM Products p WHERE p.allproducts = :allproducts")
  , @NamedQuery(name = "Products.findByManagestock", query = "SELECT p FROM Products p WHERE p.managestock = :managestock")
  , @NamedQuery(name = "Products.findBySiteguid", query = "SELECT p FROM Products p WHERE p.siteguid = :siteguid")
  , @NamedQuery(name = "Products.findBySflag", query = "SELECT p FROM Products p WHERE p.sflag = :sflag")
})
public class Products implements Serializable
{
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "attributes")
  private byte[] attributes;
  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @OneToMany(mappedBy = "product")
  private Collection<SalesItems> salesItemsCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
  private Collection<Stockdiary> stockdiaryCollection;

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
  @Column(name = "reference")
  private String reference;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "code")
  private String code;
  @Size(max = 50)
  @Column(name = "codetype")
  private String codetype;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Column(name = "pricebuy")
  private double pricebuy;
  @Basic(optional = false)
  @NotNull
  @Column(name = "pricesell")
  private double pricesell;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "stockcost")
  private Double stockcost;
  @Column(name = "stockvolume")
  private Double stockvolume;
  @Basic(optional = false)
  @NotNull
  @Column(name = "iscom")
  private boolean iscom;
  @Basic(optional = false)
  @NotNull
  @Column(name = "isscale")
  private boolean isscale;
  @Basic(optional = false)
  @NotNull
  @Column(name = "iskitchen")
  private boolean iskitchen;
  @Basic(optional = false)
  @NotNull
  @Column(name = "printkb")
  private boolean printkb;
  @Basic(optional = false)
  @NotNull
  @Column(name = "sendstatus")
  private boolean sendstatus;
  @Basic(optional = false)
  @NotNull
  @Column(name = "isservice")
  private boolean isservice;
  @Size(max = 255)
  @Column(name = "display")
  private String display;
  @Basic(optional = false)
  @NotNull
  @Column(name = "isvprice")
  private boolean isvprice;
  @Basic(optional = false)
  @NotNull
  @Column(name = "isverpatrib")
  private boolean isverpatrib;
  @Size(max = 255)
  @Column(name = "texttip")
  private String texttip;
  @Basic(optional = false)
  @NotNull
  @Column(name = "warranty")
  private boolean warranty;
  @Basic(optional = false)
  @NotNull
  @Column(name = "stockunits")
  private double stockunits;
  @Size(max = 50)
  @Column(name = "alias")
  private String alias;
  @Basic(optional = false)
  @NotNull
  @Column(name = "alwaysavailable")
  private boolean alwaysavailable;
  @Size(max = 5)
  @Column(name = "discounted")
  private String discounted;
  @Basic(optional = false)
  @NotNull
  @Column(name = "candiscount")
  private boolean candiscount;
  @Column(name = "iscatalog")
  private Boolean iscatalog;
  @Column(name = "catorder")
  private Integer catorder;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ispack")
  private boolean ispack;
  @Column(name = "packquantity")
  private Double packquantity;
  @Column(name = "allproducts")
  private Boolean allproducts;
  @Column(name = "managestock")
  private Boolean managestock;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @JoinColumn(name = "attributeset_id", referencedColumnName = "id")
  @ManyToOne
  private Attributeset attributesetId;
  @JoinColumn(name = "category", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Categories category;
  @OneToMany(mappedBy = "packproduct")
  private Collection<Products> productsCollection;
  @JoinColumn(name = "packproduct", referencedColumnName = "id")
  @ManyToOne
  private Products packproduct;
  @JoinColumn(name = "promotionid", referencedColumnName = "id")
  @ManyToOne
  private Promotions promotionid;
  @JoinColumn(name = "taxcat", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Taxcategories taxcat;

  public Products()
  {
  }

  public Products(String id)
  {
    this.id = id;
  }

  public Products(String id, String reference, String code, String name, double pricebuy, double pricesell, boolean iscom, boolean isscale, boolean iskitchen, boolean printkb, boolean sendstatus, boolean isservice, boolean isvprice, boolean isverpatrib, boolean warranty, double stockunits, boolean alwaysavailable, boolean candiscount, boolean ispack, String siteguid)
  {
    this.id = id;
    this.reference = reference;
    this.code = code;
    this.name = name;
    this.pricebuy = pricebuy;
    this.pricesell = pricesell;
    this.iscom = iscom;
    this.isscale = isscale;
    this.iskitchen = iskitchen;
    this.printkb = printkb;
    this.sendstatus = sendstatus;
    this.isservice = isservice;
    this.isvprice = isvprice;
    this.isverpatrib = isverpatrib;
    this.warranty = warranty;
    this.stockunits = stockunits;
    this.alwaysavailable = alwaysavailable;
    this.candiscount = candiscount;
    this.ispack = ispack;
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

  public String getReference()
  {
    return reference;
  }

  public void setReference(String reference)
  {
    this.reference = reference;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getCodetype()
  {
    return codetype;
  }

  public void setCodetype(String codetype)
  {
    this.codetype = codetype;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public double getPricebuy()
  {
    return pricebuy;
  }

  public void setPricebuy(double pricebuy)
  {
    this.pricebuy = pricebuy;
  }

  public double getPricesell()
  {
    return pricesell;
  }

  public void setPricesell(double pricesell)
  {
    this.pricesell = pricesell;
  }

  public Double getStockcost()
  {
    return stockcost;
  }

  public void setStockcost(Double stockcost)
  {
    this.stockcost = stockcost;
  }

  public Double getStockvolume()
  {
    return stockvolume;
  }

  public void setStockvolume(Double stockvolume)
  {
    this.stockvolume = stockvolume;
  }

  public boolean getIscom()
  {
    return iscom;
  }

  public void setIscom(boolean iscom)
  {
    this.iscom = iscom;
  }

  public boolean getIsscale()
  {
    return isscale;
  }

  public void setIsscale(boolean isscale)
  {
    this.isscale = isscale;
  }

  public boolean getIskitchen()
  {
    return iskitchen;
  }

  public void setIskitchen(boolean iskitchen)
  {
    this.iskitchen = iskitchen;
  }

  public boolean getPrintkb()
  {
    return printkb;
  }

  public void setPrintkb(boolean printkb)
  {
    this.printkb = printkb;
  }

  public boolean getSendstatus()
  {
    return sendstatus;
  }

  public void setSendstatus(boolean sendstatus)
  {
    this.sendstatus = sendstatus;
  }

  public boolean getIsservice()
  {
    return isservice;
  }

  public void setIsservice(boolean isservice)
  {
    this.isservice = isservice;
  }

  public String getDisplay()
  {
    return display;
  }

  public void setDisplay(String display)
  {
    this.display = display;
  }


  public boolean getIsvprice()
  {
    return isvprice;
  }

  public void setIsvprice(boolean isvprice)
  {
    this.isvprice = isvprice;
  }

  public boolean getIsverpatrib()
  {
    return isverpatrib;
  }

  public void setIsverpatrib(boolean isverpatrib)
  {
    this.isverpatrib = isverpatrib;
  }

  public String getTexttip()
  {
    return texttip;
  }

  public void setTexttip(String texttip)
  {
    this.texttip = texttip;
  }

  public boolean getWarranty()
  {
    return warranty;
  }

  public void setWarranty(boolean warranty)
  {
    this.warranty = warranty;
  }


  public double getStockunits()
  {
    return stockunits;
  }

  public void setStockunits(double stockunits)
  {
    this.stockunits = stockunits;
  }

  public String getAlias()
  {
    return alias;
  }

  public void setAlias(String alias)
  {
    this.alias = alias;
  }

  public boolean getAlwaysavailable()
  {
    return alwaysavailable;
  }

  public void setAlwaysavailable(boolean alwaysavailable)
  {
    this.alwaysavailable = alwaysavailable;
  }

  public String getDiscounted()
  {
    return discounted;
  }

  public void setDiscounted(String discounted)
  {
    this.discounted = discounted;
  }

  public boolean getCandiscount()
  {
    return candiscount;
  }

  public void setCandiscount(boolean candiscount)
  {
    this.candiscount = candiscount;
  }

  public Boolean getIscatalog()
  {
    return iscatalog;
  }

  public void setIscatalog(Boolean iscatalog)
  {
    this.iscatalog = iscatalog;
  }

  public Integer getCatorder()
  {
    return catorder;
  }

  public void setCatorder(Integer catorder)
  {
    this.catorder = catorder;
  }

  public boolean getIspack()
  {
    return ispack;
  }

  public void setIspack(boolean ispack)
  {
    this.ispack = ispack;
  }

  public Double getPackquantity()
  {
    return packquantity;
  }

  public void setPackquantity(Double packquantity)
  {
    this.packquantity = packquantity;
  }

  public Boolean getAllproducts()
  {
    return allproducts;
  }

  public void setAllproducts(Boolean allproducts)
  {
    this.allproducts = allproducts;
  }

  public Boolean getManagestock()
  {
    return managestock;
  }

  public void setManagestock(Boolean managestock)
  {
    this.managestock = managestock;
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

  public Attributeset getAttributesetId()
  {
    return attributesetId;
  }

  public void setAttributesetId(Attributeset attributesetId)
  {
    this.attributesetId = attributesetId;
  }

  public Categories getCategory()
  {
    return category;
  }

  public void setCategory(Categories category)
  {
    this.category = category;
  }

  @XmlTransient
  public Collection<Products> getProductsCollection()
  {
    return productsCollection;
  }

  public void setProductsCollection(Collection<Products> productsCollection)
  {
    this.productsCollection = productsCollection;
  }

  public Products getPackproduct()
  {
    return packproduct;
  }

  public void setPackproduct(Products packproduct)
  {
    this.packproduct = packproduct;
  }

  public Promotions getPromotionid()
  {
    return promotionid;
  }

  public void setPromotionid(Promotions promotionid)
  {
    this.promotionid = promotionid;
  }

  public Taxcategories getTaxcat()
  {
    return taxcat;
  }

  public void setTaxcat(Taxcategories taxcat)
  {
    this.taxcat = taxcat;
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
    if (!(object instanceof Products))
    {
      return false;
    }
    Products other = (Products) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Products[ id=" + id + " ]";
  }

  @XmlTransient
  public Collection<Stockdiary> getStockdiaryCollection()
  {
    return stockdiaryCollection;
  }

  public void setStockdiaryCollection(Collection<Stockdiary> stockdiaryCollection)
  {
    this.stockdiaryCollection = stockdiaryCollection;
  }

  public byte[] getAttributes()
  {
    return attributes;
  }

  public void setAttributes(byte[] attributes)
  {
    this.attributes = attributes;
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
  public Collection<SalesItems> getSalesItemsCollection()
  {
    return salesItemsCollection;
  }

  public void setSalesItemsCollection(Collection<SalesItems> salesItemsCollection)
  {
    this.salesItemsCollection = salesItemsCollection;
  }
  
}
