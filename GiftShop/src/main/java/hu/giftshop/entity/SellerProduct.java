package hu.giftshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "seller_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerProduct.findAll", query = "SELECT s FROM SellerProduct s")
    , @NamedQuery(name = "SellerProduct.findById", query = "SELECT s FROM SellerProduct s WHERE s.id = :id")
    , @NamedQuery(name = "SellerProduct.findByName", query = "SELECT s FROM SellerProduct s WHERE s.name = :name")
    , @NamedQuery(name = "SellerProduct.findByDescription", query = "SELECT s FROM SellerProduct s WHERE s.description = :description")
    , @NamedQuery(name = "SellerProduct.findByPrice", query = "SELECT s FROM SellerProduct s WHERE s.price = :price")})
public class SellerProduct implements Serializable {

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
   
    @Size(max = 45)
    @Column(name = "description")
    private String description;
 
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;

    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seller seller;

    public SellerProduct() {
    }

    public SellerProduct(Integer id) {
        this.id = id;
    }

    public SellerProduct(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SellerProduct)) {
            return false;
        }
        SellerProduct other = (SellerProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.giftshop.entity.SellerProduct[ id=" + id + " ]";
    }
    
}
