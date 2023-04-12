/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema_client.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kimda
 */
@Entity
@Table(name = "Coupon", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c")
    , @NamedQuery(name = "Coupon.findByCouponId", query = "SELECT c FROM Coupon c WHERE c.couponId = :couponId")
    , @NamedQuery(name = "Coupon.findByPriceDiscound", query = "SELECT c FROM Coupon c WHERE c.priceDiscound = :priceDiscound")
    , @NamedQuery(name = "Coupon.findByStatus", query = "SELECT c FROM Coupon c WHERE c.status = :status")
    , @NamedQuery(name = "Coupon.findByDateEnd", query = "SELECT c FROM Coupon c WHERE c.dateEnd = :dateEnd")})
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "couponId", nullable = false, length = 100)
    private String couponId;
    @Column(name = "priceDiscound")
    private Integer priceDiscound;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "DateEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @JoinColumn(name = "user_Email", referencedColumnName = "email")
    @ManyToOne
    private Users userEmail;

    public Coupon() {
    }

    public Coupon(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Integer getPriceDiscound() {
        return priceDiscound;
    }

    public void setPriceDiscound(Integer priceDiscound) {
        this.priceDiscound = priceDiscound;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Users getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Users userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponId != null ? couponId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coupon)) {
            return false;
        }
        Coupon other = (Coupon) object;
        if ((this.couponId == null && other.couponId != null) || (this.couponId != null && !this.couponId.equals(other.couponId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Coupon[ couponId=" + couponId + " ]";
    }
    
}
