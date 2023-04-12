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
import java.util.Date;

/**
 *
 * @author kimda
 */
@Entity
@Table(name = "Showtimes", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showtimes.findAll", query = "SELECT s FROM Showtimes s")
    , @NamedQuery(name = "Showtimes.findByShowtimesId", query = "SELECT s FROM Showtimes s WHERE s.showtimesId = :showtimesId")
    , @NamedQuery(name = "Showtimes.findByTime", query = "SELECT s FROM Showtimes s WHERE s.time = :time")
    , @NamedQuery(name = "Showtimes.findByDate", query = "SELECT s FROM Showtimes s WHERE s.date = :date")})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "showtimesId", nullable = false)
    private Integer showtimesId;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "showtimeId")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "movieId", referencedColumnName = "movieId")
    @ManyToOne
    private Movie movieId;
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    @ManyToOne
    private Room roomId;

    public Showtimes() {
    }

    public Showtimes(Integer showtimesId) {
        this.showtimesId = showtimesId;
    }

    public Integer getShowtimesId() {
        return showtimesId;
    }

    public void setShowtimesId(Integer showtimesId) {
        this.showtimesId = showtimesId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showtimesId != null ? showtimesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtimes)) {
            return false;
        }
        Showtimes other = (Showtimes) object;
        if ((this.showtimesId == null && other.showtimesId != null) || (this.showtimesId != null && !this.showtimesId.equals(other.showtimesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Showtimes[ showtimesId=" + showtimesId + " ]";
    }
    
}
