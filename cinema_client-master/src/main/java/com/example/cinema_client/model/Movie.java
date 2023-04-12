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
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author kimda
 */
@Entity
@Table(name = "Movie", catalog = "CinestarDatabase", schema = "dbo")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
        , @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId")
        , @NamedQuery(name = "Movie.findByMovieTitle", query = "SELECT m FROM Movie m WHERE m.movieTitle = :movieTitle")
        , @NamedQuery(name = "Movie.findByMovieCategory", query = "SELECT m FROM Movie m WHERE m.movieCategory = :movieCategory")
        , @NamedQuery(name = "Movie.findByPerformer", query = "SELECT m FROM Movie m WHERE m.performer = :performer")
        , @NamedQuery(name = "Movie.findByFilmDirector", query = "SELECT m FROM Movie m WHERE m.filmDirector = :filmDirector")
        , @NamedQuery(name = "Movie.findByMovieContent", query = "SELECT m FROM Movie m WHERE m.movieContent = :movieContent")
        , @NamedQuery(name = "Movie.findByImage", query = "SELECT m FROM Movie m WHERE m.image = :image")
        , @NamedQuery(name = "Movie.findByTrailer", query = "SELECT m FROM Movie m WHERE m.trailer = :trailer")
        , @NamedQuery(name = "Movie.findByStartMovie", query = "SELECT m FROM Movie m WHERE m.startMovie = :startMovie")
        , @NamedQuery(name = "Movie.findByEndMovie", query = "SELECT m FROM Movie m WHERE m.endMovie = :endMovie")
        , @NamedQuery(name = "Movie.findByStatus", query = "SELECT m FROM Movie m WHERE m.status = :status")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "movieId", nullable = false, length = 10)
    private String movieId;
    @Size(max = 50)
    @Column(name = "movieTitle", length = 50)
    private String movieTitle;
    @Size(max = 50)
    @Column(name = "movieCategory", length = 50)
    private String movieCategory;
    @Size(max = 100)
    @Column(name = "performer", length = 100)
    private String performer;
    @Size(max = 30)
    @Column(name = "filmDirector", length = 30)
    private String filmDirector;
    @Size(max = 2000)
    @Column(name = "movieContent", length = 2000)
    private String movieContent;
    @Size(max = 250)
    @Column(name = "image", length = 250)
    private String image;
    @Size(max = 250)
    @Column(name = "trailer", length = 250)
    private String trailer;
    @Column(name = "startMovie")
    @Temporal(TemporalType.DATE)
    private Date startMovie;
    @Column(name = "endMovie")
    @Temporal(TemporalType.DATE)
    private Date endMovie;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "movieId")
    private Collection<RatingMovie> ratingMovieCollection;
    @OneToMany(mappedBy = "movieId")
    private Collection<Showtimes> showtimesCollection;
    @OneToMany(mappedBy = "idMovie")
    private Collection<MovieLanguage> movieLanguageCollection;
    @OneToMany(mappedBy = "movieId")
    private Collection<Wishlist> wishlistCollection;

    public Movie() {
    }

    public Movie(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public String getMovieContent() {
        return movieContent;
    }

    public void setMovieContent(String movieContent) {
        this.movieContent = movieContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Date getStartMovie() {
        return startMovie;
    }

    public void setStartMovie(Date startMovie) {
        this.startMovie = startMovie;
    }

    public Date getEndMovie() {
        return endMovie;
    }

    public void setEndMovie(Date endMovie) {
        this.endMovie = endMovie;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<RatingMovie> getRatingMovieCollection() {
        return ratingMovieCollection;
    }

    public void setRatingMovieCollection(Collection<RatingMovie> ratingMovieCollection) {
        this.ratingMovieCollection = ratingMovieCollection;
    }

    @XmlTransient
    public Collection<Showtimes> getShowtimesCollection() {
        return showtimesCollection;
    }

    public void setShowtimesCollection(Collection<Showtimes> showtimesCollection) {
        this.showtimesCollection = showtimesCollection;
    }

    @XmlTransient
    public Collection<MovieLanguage> getMovieLanguageCollection() {
        return movieLanguageCollection;
    }

    public void setMovieLanguageCollection(Collection<MovieLanguage> movieLanguageCollection) {
        this.movieLanguageCollection = movieLanguageCollection;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Movie[ movieId=" + movieId + " ]";
    }

}
