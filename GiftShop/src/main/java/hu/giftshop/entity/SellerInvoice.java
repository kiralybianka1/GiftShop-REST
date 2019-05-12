package hu.giftshop.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "seller_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerInvoice.findAll", query = "SELECT s FROM SellerInvoice s")
    , @NamedQuery(name = "SellerInvoice.findById", query = "SELECT s FROM SellerInvoice s WHERE s.id = :id")
    , @NamedQuery(name = "SellerInvoice.findByInvoiceDate", query = "SELECT s FROM SellerInvoice s WHERE s.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "SellerProduct.findByTotalPrice", query = "SELECT s FROM SellerInvoice s WHERE s.totalPrice = :totalPrice")})
public class SellerInvoice implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seller seller;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Calendar invoiceDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private double totalPrice;
    
    public SellerInvoice() {
    }
    
    public SellerInvoice(Integer id) {
         this.id = id;
    }
    
    public SellerInvoice(Integer id, Calendar invoiceDate, double totalPrice) {
         this.id = id;
         this.invoiceDate = invoiceDate;
         this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Calendar getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Calendar invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
     @Override
    public boolean equals(Object object) {
        if (!(object instanceof SellerInvoice)) {
            return false;
        }
        SellerInvoice other = (SellerInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "hu.giftshop.entity.SellerInvoice[ id=" + id + " ]";
    }

}
