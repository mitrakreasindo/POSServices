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

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
  , @NamedQuery(name = "Categories.findById", query = "SELECT c FROM Categories c WHERE c.id = :id")
  , @NamedQuery(name = "Categories.findByName", query = "SELECT c FROM Categories c WHERE c.name = :name")
  , @NamedQuery(name = "Categories.findByTexttip", query = "SELECT c FROM Categories c WHERE c.texttip = :texttip")
  , @NamedQuery(name = "Categories.findByCatshowname", query = "SELECT c FROM Categories c WHERE c.catshowname = :catshowname")
  , @NamedQuery(name = "Categories.findByColour", query = "SELECT c FROM Categories c WHERE c.colour = :colour")
  , @NamedQuery(name = "Categories.findByCatorder", query = "SELECT c FROM Categories c WHERE c.catorder = :catorder")
  , @NamedQuery(name = "Categories.findBySiteguid", query = "SELECT c FROM Categories c WHERE c.siteguid = :siteguid")
  , @NamedQuery(name = "Categories.findBySflag", query = "SELECT c FROM Categories c WHERE c.sflag = :sflag")
})
public class Categories implements Serializable
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
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Size(max = 255)
  @Column(name = "texttip")
  private String texttip;
  @Basic(optional = false)
  @NotNull
  @Column(name = "catshowname")
  private boolean catshowname;
  @Lob
  @Column(name = "image")
  private byte[] image;
  @Size(max = 50)
  @Column(name = "colour")
  private String colour;
  @Column(name = "catorder")
  private Integer catorder;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  @OneToMany(mappedBy = "parentid")
  private Collection<Categories> categoriesCollection;
  @JoinColumn(name = "parentid", referencedColumnName = "id")
  @ManyToOne
  private Categories parentid;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private Collection<Products> productsCollection;

  public Categories()
  {
  }

  public Categories(String id)
  {
    this.id = id;
  }

  public Categories(String id, String name, boolean catshowname, String siteguid)
  {
    this.id = id;
    this.name = name;
    this.catshowname = catshowname;
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

  public String getTexttip()
  {
    return texttip;
  }

  public void setTexttip(String texttip)
  {
    this.texttip = texttip;
  }

  public boolean getCatshowname()
  {
    return catshowname;
  }

  public void setCatshowname(boolean catshowname)
  {
    this.catshowname = catshowname;
  }

  public byte[] getImage()
  {
    return image;
  }

  public void setImage(byte[] image)
  {
    this.image = image;
  }

  public String getColour()
  {
    return colour;
  }

  public void setColour(String colour)
  {
    this.colour = colour;
  }

  public Integer getCatorder()
  {
    return catorder;
  }

  public void setCatorder(Integer catorder)
  {
    this.catorder = catorder;
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

  @XmlTransient
  public Collection<Categories> getCategoriesCollection()
  {
    return categoriesCollection;
  }

  public void setCategoriesCollection(Collection<Categories> categoriesCollection)
  {
    this.categoriesCollection = categoriesCollection;
  }

  public Categories getParentid()
  {
    return parentid;
  }

  public void setParentid(Categories parentid)
  {
    this.parentid = parentid;
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
    if (!(object instanceof Categories))
    {
      return false;
    }
    Categories other = (Categories) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.Categories[ id=" + id + " ]";
  }
  
}
