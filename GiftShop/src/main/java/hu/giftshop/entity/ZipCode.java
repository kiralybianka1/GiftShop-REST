package hu.giftshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "zip_code")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZipCode.findAll", query = "SELECT z FROM ZipCode z")
    , @NamedQuery(name = "ZipCode.findByZipCode", query = "SELECT z FROM ZipCode z WHERE z.zipCode = :zipCode")
    , @NamedQuery(name = "ZipCode.findByLocation", query = "SELECT z FROM ZipCode z WHERE z.location = :location")
    , @NamedQuery(name = "ZipCode.findByRegion", query = "SELECT z FROM ZipCode z WHERE z.region = :region")})
public class ZipCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "zip_code")
    private String zipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "region")
    private String region;

    public ZipCode() {
    }

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ZipCode(String zipCode, String location, String region) {
        this.zipCode = zipCode;
        this.location = location;
        this.region = region;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipCode != null ? zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ZipCode)) {
            return false;
        }
        ZipCode other = (ZipCode) object;
        if ((this.zipCode == null && other.zipCode != null) || (this.zipCode != null && !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.giftshop.entity.ZipCode[ zipCode=" + zipCode + " ]";
    }
    
}
