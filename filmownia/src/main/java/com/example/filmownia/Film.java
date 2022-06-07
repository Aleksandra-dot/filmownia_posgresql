package com.example.filmownia;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table
public class Film {

    public enum enumGatunek {
        Dramat, Komedia, Horror, Thriller, SciFi, Romans, Musical, Krótkometrażowy, Fantasy, Familijny, Dokumentalny
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String tytul;
    private  int rok;
    private int czas;
    private double sredniaOcena=0;
    private enumGatunek gatunek;

    @OneToMany (fetch=FetchType.EAGER)
    List<Komentarz> komentarze = new ArrayList<>();
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Osoba> obsada = new ArrayList<>();
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Osoba> rezyserowie = new ArrayList<>();


    public Film() {
    }

    public Film(String tytul, int rok, int czas, enumGatunek gatunek) {
        this.tytul = tytul;
        this.rok = rok;
        this.czas = czas;
        this.gatunek = gatunek;

    }

    public double licz_srednia(){
        double suma=0;
        int licznik=0;
        for(Komentarz komentarz: komentarze){
            suma+=komentarz.getOcena();
            licznik++;
        }
        return suma/licznik;
    }

    public long getId() {
        return id;
    }

    public void dodajObsade(Osoba osoba){
        obsada.add(osoba);
    }
    public void dodaj_rezysera(Osoba rezyser){
        this.rezyserowie.add(rezyser);
    }


    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }


    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }

    public List<Komentarz> getKomentarze() {
        return komentarze;
    }

    public void setKomentarze(ArrayList<Komentarz> komentarze) {
        this.komentarze = komentarze;
    }

    public void setRezyserowie(ArrayList<Osoba> rezyserowie) {
        this.rezyserowie = rezyserowie;
    }

    public double getSredniaOcena() {
        return sredniaOcena;
    }

    public void setSredniaOcena(double ocena) {
        this.sredniaOcena = sredniaOcena;
    }

    public enumGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(enumGatunek gatunek) {
        this.gatunek = gatunek;
    }

    public List<Osoba> getObsada() {
        return obsada;
    }

    public void setObsada(List<Osoba> obsada) {
        this.obsada = obsada;
    }
    public List<Osoba> getRezyserowie() {
        return rezyserowie;
    }

    public void dodajKomentarz(Komentarz komentarz){
        komentarze.add(komentarz);
    }

    @Override
    public String toString() {
        return tytul;
    }




}

