package hu.giftshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
    , @NamedQuery(name = "Address.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = :zipCode")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByHouseNumber", query = "SELECT a FROM Address a WHERE a.houseNumber = :houseNumber")
    , @NamedQuery(name = "Address.findByFloor", query = "SELECT a FROM Address a WHERE a.floor = :floor")
    , @NamedQuery(name = "Address.findByDoor", query = "SELECT a FROM Address a WHERE a.door = :door")
    , @NamedQuery(name = "Address.findByDoorbell", query = "SELECT a FROM Address a WHERE a.doorbell = :doorbell")
    , @NamedQuery(name = "Address.findByAllDetails", query = "SELECT a FROM Address a "
            + "WHERE a.country= :country AND a.zipCode = :zipCode AND "
            + "a.city = :city AND a.street = :street AND "
            + "a.houseNumber = :houseNumber AND "
            + "a.floor = :floor AND a.door = :door AND a.doorbell = :doorbell")
})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zip_code")
    private String zipCode;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "street")
    private String street;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "house_number")
    private String houseNumber;
    
    @Column(name = "floor")
    private Integer floor;
    
    @Column(name = "door")
    private Integer door;
    
    @Column(name = "doorbell")
    private Integer doorbell;
    
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "address", fetch = FetchType.LAZY)
    private List<Customer> customerList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private List<Seller> sellerList = new ArrayList<>();
    
    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String country, String zipCode, String city, String street, String houseNumber) {
        this.id = id;
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getDoor() {
        return door;
    }

    public void setDoor(Integer door) {
        this.door = door;
    }

    public Integer getDoorbell() {
        return doorbell;
    }

    public void setDoorbell(Integer doorbell) {
        this.doorbell = doorbell;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    @XmlTransient
    public List<Seller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<Seller> sellerList) {
        this.sellerList = sellerList;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "hu.giftshop.entity.Address[ id=" + id + " ]";
    }

}
