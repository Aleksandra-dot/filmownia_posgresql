package com.example.filmownia;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private int wzrost;
    ArrayList<String> nagrody = new ArrayList<>();


    @ManyToMany(fetch = FetchType.EAGER)
    List<Film> filmy = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Osoba() {
    }

    public Osoba(String imie, String nazwisko, String data_urodzenia, int wzrost) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.wzrost = wzrost;

    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public List getNagrody() {
        return nagrody;
    }


    public List<Film> getFilmy() {
        return filmy;
    }


    public void dodajNagrode(String nagroda){
        this.nagrody.add(nagroda);
    }
    public void dodajFilm(Film film){
        this.filmy.add(film);
    }


    @Override
    public String toString() {
        return imie + nazwisko;
    }
}


