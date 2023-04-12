/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema_client.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author kimda
 */
@Entity
@Table(name = "Seat", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
    , @NamedQuery(name = "Seat.findBySeatId", query = "SELECT s FROM Seat s WHERE s.seatId = :seatId")
    , @NamedQuery(name = "Seat.findBySeatNo", query = "SELECT s FROM Seat s WHERE s.seatNo = :seatNo")
    , @NamedQuery(name = "Seat.findByType", query = "SELECT s FROM Seat s WHERE s.type = :type")
    , @NamedQuery(name = "Seat.findByPrice", query = "SELECT s FROM Seat s WHERE s.price = :price")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seatId", nullable = false)
    private Integer seatId;
    @Column(name = "seatNo")
    private Integer seatNo;
    @Column(name = "type")
    private Integer type;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "rowId", referencedColumnName = "rowId")
    @ManyToOne
    private RowOfSeats rowId;
    @OneToMany(mappedBy = "seatId")
    private Collection<TicketDetailsSeat> ticketDetailsSeatCollection;

    public Seat() {
    }

    public Seat(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public RowOfSeats getRowId() {
        return rowId;
    }

    public void setRowId(RowOfSeats rowId) {
        this.rowId = rowId;
    }

    @XmlTransient
    public Collection<TicketDetailsSeat> getTicketDetailsSeatCollection() {
        return ticketDetailsSeatCollection;
    }

    public void setTicketDetailsSeatCollection(Collection<TicketDetailsSeat> ticketDetailsSeatCollection) {
        this.ticketDetailsSeatCollection = ticketDetailsSeatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Seat[ seatId=" + seatId + " ]";
    }
    
}
