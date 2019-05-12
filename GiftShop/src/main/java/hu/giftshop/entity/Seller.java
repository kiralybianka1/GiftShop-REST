package hu.giftshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@Entity
@Table(name = "seller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
    , @NamedQuery(name = "Seller.findById", query = "SELECT s FROM Seller s WHERE s.id = :id")
    , @NamedQuery(name = "Seller.findByName", query = "SELECT s FROM Seller s WHERE s.name = :name")
    , @NamedQuery(name = "Seller.findByPhone", query = "SELECT s FROM Seller s WHERE s.phone = :phone")
    , @NamedQuery(name = "Seller.findByEmail", query = "SELECT s FROM Seller s WHERE s.email = :email")
    , @NamedQuery(name = "Seller.findByAccountNumber", query = "SELECT s FROM Seller s WHERE s.accountNumber = :accountNumber")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "account_number")
    private String accountNumber;
    
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Address address;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.LAZY)
    private List<SellerProduct> sellerProductList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.LAZY)
    private List<SellerInvoice> sellerInvoiceList = new ArrayList<>();

    public Seller() {
    }

    public Seller(Integer id) {
        this.id = id;
    }

    public Seller(Integer id, String name, String phone, String email, String accountNumber) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.accountNumber = accountNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlTransient
    public List<SellerProduct> getSellerProductList() {
        return sellerProductList;
    }

    public void setSellerProductList(List<SellerProduct> sellerProductList) {
        this.sellerProductList = sellerProductList;
    }
    
    @XmlTransient
    public List<SellerInvoice> getSellerInvoiceList() {
        return sellerInvoiceList;
    }

    public void setSellerInvoiceList(List<SellerInvoice> sellerInvoiceList) {
        this.sellerInvoiceList = sellerInvoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.giftshop.entity.Seller[ id=" + id + " ]";
    }
}
