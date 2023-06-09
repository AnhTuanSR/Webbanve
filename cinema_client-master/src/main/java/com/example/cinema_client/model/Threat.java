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
@Table(name = "Threat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Threat.findAll", query = "SELECT t FROM Threat t")
    , @NamedQuery(name = "Threat.findById", query = "SELECT t FROM Threat t WHERE t.id = :id")
    , @NamedQuery(name = "Threat.findByName", query = "SELECT t FROM Threat t WHERE t.name = :name")
    , @NamedQuery(name = "Threat.findByPhone", query = "SELECT t FROM Threat t WHERE t.phone = :phone")
    , @NamedQuery(name = "Threat.findByAddress", query = "SELECT t FROM Threat t WHERE t.address = :address")
    , @NamedQuery(name = "Threat.findByRegion", query = "SELECT t FROM Threat t WHERE t.region = :region")})
public class Threat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;
    @Size(max = 500)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "region")
    private String region;
    @OneToMany(mappedBy = "threatId")
    private Collection<RatingThreater> ratingThreaterCollection;

    public Threat() {
    }

    public Threat(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlTransient
    public Collection<RatingThreater> getRatingThreaterCollection() {
        return ratingThreaterCollection;
    }

    public void setRatingThreaterCollection(Collection<RatingThreater> ratingThreaterCollection) {
        this.ratingThreaterCollection = ratingThreaterCollection;
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
        if (!(object instanceof Threat)) {
            return false;
        }
        Threat other = (Threat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Threat[ id=" + id + " ]";
    }
    
}
