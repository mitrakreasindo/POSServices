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
import org.hibernate.annotations.Type;

/**
 *
 * @author Asun
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
  , @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id")
  , @NamedQuery(name = "People.findByName", query = "SELECT p FROM People p WHERE p.name = :name")
  , @NamedQuery(name = "People.findByCard", query = "SELECT p FROM People p WHERE p.card = :card")
  , @NamedQuery(name = "People.findByVisible", query = "SELECT p FROM People p WHERE p.visible = :visible")
  , @NamedQuery(name = "People.findBySiteguid", query = "SELECT p FROM People p WHERE p.siteguid = :siteguid")
  , @NamedQuery(name = "People.findBySflag", query = "SELECT p FROM People p WHERE p.sflag = :sflag")
  , @NamedQuery(name = "People.findByEmail", query = "SELECT p FROM People p WHERE p.email = :email")
})
public class People implements Serializable
{

  @Type(type="org.hibernate.type.BinaryType")
  @Column(name = "image")
  private byte[] image;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
  private Collection<Tickets> ticketsCollection;

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "id")
  private String id;
  @Size(max = 255)
  @Column(name = "name")
  private String name;
  @Size(max = 255)
  @Column(name = "apppassword")
  private transient String apppassword;
  @Size(max = 255)
  @Column(name = "card")
  private String card;
  @Basic(optional = false)
  @NotNull
  @Column(name = "visible")
  private boolean visible;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "siteguid")
  private String siteguid;
  @Column(name = "sflag")
  private Boolean sflag;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "email")
  private String email;
  @JoinColumn(name = "role", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Roles role;

  public People()
  {
  }

  public People(String id)
  {
    this.id = id;
  }

  public People(String id, boolean visible, String siteguid)
  {
    this.id = id;
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

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getApppassword()
  {
    return apppassword;
  }

  public void setApppassword(String apppassword)
  {
    this.apppassword = apppassword;
  }

  public String getCard()
  {
    return card;
  }

  public void setCard(String card)
  {
    this.card = card;
  }

  public boolean getVisible()
  {
    return visible;
  }

  public void setVisible(boolean visible)
  {
    this.visible = visible;
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

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public Roles getRole()
  {
    return role;
  }

  public void setRole(Roles role)
  {
    this.role = role;
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
    if (!(object instanceof People))
    {
      return false;
    }
    People other = (People) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.People[ id=" + id + " ]";
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
  public Collection<Tickets> getTicketsCollection()
  {
    return ticketsCollection;
  }

  public void setTicketsCollection(Collection<Tickets> ticketsCollection)
  {
    this.ticketsCollection = ticketsCollection;
  }

}
