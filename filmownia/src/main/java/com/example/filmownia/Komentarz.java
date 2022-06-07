package com.example.filmownia;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;


@Entity
@Table(name="komentarz")
public class Komentarz {
    public enum enumOcena {
        Super, Dobry, Sredni, Slaby, Okropny
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tresc;
    private enumOcena ocena_kom;
    private double ocena;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "film_id")
    private Film film;



    public Komentarz() {
    }

    public Komentarz(String tresc, enumOcena ocena_kom, double ocena, Uzytkownik uzytkownik, Film film) {

        this.tresc = tresc;
        this.ocena_kom = ocena_kom;
        this.ocena = ocena;
        this.uzytkownik = uzytkownik;
        this.film = film;
    }

    public Komentarz(String tresc, enumOcena ocena_kom,double ocena, Film film) {

        this.tresc = tresc;
        this.ocena_kom = ocena_kom;
        this.ocena = ocena;
        this.film = film;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public enumOcena getOcena_kom() {
        return ocena_kom;
    }

    public void setOcena_kom(enumOcena ocena_kom) {
        this.ocena_kom = ocena_kom;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }








}
