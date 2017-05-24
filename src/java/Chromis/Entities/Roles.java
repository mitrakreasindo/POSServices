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
import javax.persistence.Lob;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id")
    , @NamedQuery(name = "Roles.findByName", query = "SELECT r FROM Roles r WHERE r.name = :name")
    , @NamedQuery(name = "Roles.findByRightslevel", query = "SELECT r FROM Roles r WHERE r.rightslevel = :rightslevel")
    , @NamedQuery(name = "Roles.findBySiteguid", query = "SELECT r FROM Roles r WHERE r.siteguid = :siteguid")
    , @NamedQuery(name = "Roles.findBySflag", query = "SELECT r FROM Roles r WHERE r.sflag = :sflag")})
public class Roles implements Serializable {

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
    //@Lob
    @Column(name = "permissions")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] permissions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rightslevel")
    private int rightslevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "siteguid")
    private String siteguid;
    @Column(name = "sflag")
    private Boolean sflag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<People> peopleCollection;

    public Roles() {
    }

    public Roles(String id) {
        this.id = id;
    }

    public Roles(String id, String name, int rightslevel, String siteguid) {
        this.id = id;
        this.name = name;
        this.rightslevel = rightslevel;
        this.siteguid = siteguid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPermissions() {
        return permissions;
    }

    public void setPermissions(byte[] permissions) {
        this.permissions = permissions;
    }

    public int getRightslevel() {
        return rightslevel;
    }

    public void setRightslevel(int rightslevel) {
        this.rightslevel = rightslevel;
    }

    public String getSiteguid() {
        return siteguid;
    }

    public void setSiteguid(String siteguid) {
        this.siteguid = siteguid;
    }

    public Boolean getSflag() {
        return sflag;
    }

    public void setSflag(Boolean sflag) {
        this.sflag = sflag;
    }

    @XmlTransient
    public Collection<People> getPeopleCollection() {
        return peopleCollection;
    }

    public void setPeopleCollection(Collection<People> peopleCollection) {
        this.peopleCollection = peopleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chromis.Roles[ id=" + id + " ]";
    }
    
}
