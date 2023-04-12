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
@Table(name = "RowOfSeats", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowOfSeats.findAll", query = "SELECT r FROM RowOfSeats r")
    , @NamedQuery(name = "RowOfSeats.findByRowId", query = "SELECT r FROM RowOfSeats r WHERE r.rowId = :rowId")
    , @NamedQuery(name = "RowOfSeats.findByRowNo", query = "SELECT r FROM RowOfSeats r WHERE r.rowNo = :rowNo")})
public class RowOfSeats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rowId", nullable = false)
    private Integer rowId;
    @Size(max = 10)
    @Column(name = "rowNo", length = 10)
    private String rowNo;
    @OneToMany(mappedBy = "rowId")
    private Collection<Seat> seatCollection;
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    @ManyToOne
    private Room roomId;

    public RowOfSeats() {
    }

    public RowOfSeats(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    @XmlTransient
    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
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
        hash += (rowId != null ? rowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RowOfSeats)) {
            return false;
        }
        RowOfSeats other = (RowOfSeats) object;
        if ((this.rowId == null && other.rowId != null) || (this.rowId != null && !this.rowId.equals(other.rowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RowOfSeats[ rowId=" + rowId + " ]";
    }
    
}
