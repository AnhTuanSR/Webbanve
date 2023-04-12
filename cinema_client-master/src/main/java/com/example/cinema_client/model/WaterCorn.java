/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema_client.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author kimda
 */
@Entity
@Table(name = "WaterCorn", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaterCorn.findAll", query = "SELECT w FROM WaterCorn w")
    , @NamedQuery(name = "WaterCorn.findByIdWaterCorn", query = "SELECT w FROM WaterCorn w WHERE w.idWaterCorn = :idWaterCorn")
    , @NamedQuery(name = "WaterCorn.findByNameWaterCorn", query = "SELECT w FROM WaterCorn w WHERE w.nameWaterCorn = :nameWaterCorn")
    , @NamedQuery(name = "WaterCorn.findByContentWaterCorn", query = "SELECT w FROM WaterCorn w WHERE w.contentWaterCorn = :contentWaterCorn")
    , @NamedQuery(name = "WaterCorn.findByImageWaterCorn", query = "SELECT w FROM WaterCorn w WHERE w.imageWaterCorn = :imageWaterCorn")
    , @NamedQuery(name = "WaterCorn.findByPrice", query = "SELECT w FROM WaterCorn w WHERE w.price = :price")})
public class WaterCorn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWaterCorn", nullable = false)
    private Integer idWaterCorn;
    @Size(max = 50)
    @Column(name = "nameWaterCorn", length = 50)
    private String nameWaterCorn;
    @Size(max = 500)
    @Column(name = "contentWaterCorn", length = 500)
    private String contentWaterCorn;
    @Size(max = 250)
    @Column(name = "imageWaterCorn", length = 250)
    private String imageWaterCorn;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy = "idWaterCorn")
    private Collection<TicketDetailsWaterCorn> ticketDetailsWaterCornCollection;

    public WaterCorn() {
    }

    public WaterCorn(Integer idWaterCorn) {
        this.idWaterCorn = idWaterCorn;
    }

    public Integer getIdWaterCorn() {
        return idWaterCorn;
    }

    public void setIdWaterCorn(Integer idWaterCorn) {
        this.idWaterCorn = idWaterCorn;
    }

    public String getNameWaterCorn() {
        return nameWaterCorn;
    }

    public void setNameWaterCorn(String nameWaterCorn) {
        this.nameWaterCorn = nameWaterCorn;
    }

    public String getContentWaterCorn() {
        return contentWaterCorn;
    }

    public void setContentWaterCorn(String contentWaterCorn) {
        this.contentWaterCorn = contentWaterCorn;
    }

    public String getImageWaterCorn() {
        return imageWaterCorn;
    }

    public void setImageWaterCorn(String imageWaterCorn) {
        this.imageWaterCorn = imageWaterCorn;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<TicketDetailsWaterCorn> getTicketDetailsWaterCornCollection() {
        return ticketDetailsWaterCornCollection;
    }

    public void setTicketDetailsWaterCornCollection(Collection<TicketDetailsWaterCorn> ticketDetailsWaterCornCollection) {
        this.ticketDetailsWaterCornCollection = ticketDetailsWaterCornCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWaterCorn != null ? idWaterCorn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaterCorn)) {
            return false;
        }
        WaterCorn other = (WaterCorn) object;
        if ((this.idWaterCorn == null && other.idWaterCorn != null) || (this.idWaterCorn != null && !this.idWaterCorn.equals(other.idWaterCorn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.WaterCorn[ idWaterCorn=" + idWaterCorn + " ]";
    }
    
}
