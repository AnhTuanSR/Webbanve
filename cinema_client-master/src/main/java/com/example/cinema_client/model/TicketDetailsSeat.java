/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cinema_client.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author kimda
 */
@Entity
@Table(name = "TicketDetailsSeat", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketDetailsSeat.findAll", query = "SELECT t FROM TicketDetailsSeat t")
    , @NamedQuery(name = "TicketDetailsSeat.findByTicketDetailsId", query = "SELECT t FROM TicketDetailsSeat t WHERE t.ticketDetailsId = :ticketDetailsId")
    , @NamedQuery(name = "TicketDetailsSeat.findByPrice", query = "SELECT t FROM TicketDetailsSeat t WHERE t.price = :price")})
public class TicketDetailsSeat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticketDetailsId", nullable = false)
    private Integer ticketDetailsId;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "seatId", referencedColumnName = "seatId")
    @ManyToOne
    private Seat seatId;
    @JoinColumn(name = "ticketId", referencedColumnName = "ticketId")
    @ManyToOne
    private Ticket ticketId;

    public TicketDetailsSeat() {
    }

    public TicketDetailsSeat(Integer ticketDetailsId) {
        this.ticketDetailsId = ticketDetailsId;
    }

    public Integer getTicketDetailsId() {
        return ticketDetailsId;
    }

    public void setTicketDetailsId(Integer ticketDetailsId) {
        this.ticketDetailsId = ticketDetailsId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketDetailsId != null ? ticketDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketDetailsSeat)) {
            return false;
        }
        TicketDetailsSeat other = (TicketDetailsSeat) object;
        if ((this.ticketDetailsId == null && other.ticketDetailsId != null) || (this.ticketDetailsId != null && !this.ticketDetailsId.equals(other.ticketDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.TicketDetailsSeat[ ticketDetailsId=" + ticketDetailsId + " ]";
    }
    
}
