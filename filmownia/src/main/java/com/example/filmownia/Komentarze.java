package com.example.filmownia;

import java.util.ArrayList;
import java.util.List;

public class Komentarze implements KomentarzInterface {

    List<Komentarz> komentarzeList;

    public List<Komentarz> getKometarzeList() {
        return komentarzeList;
    }

    public void setKometarzeList(List<Komentarz> kometarzeList) {
        this.komentarzeList = kometarzeList;
    }

    public Komentarze() {
        this.komentarzeList = new ArrayList<>();
    }

    public Komentarze(List<Komentarz> kometarzeList) {
        this.komentarzeList = kometarzeList;
    }

    //metody

    public void dodajKomentarz(Komentarz komentarz){
        komentarzeList.add(komentarz);
    }

    public void usunKomentarz(Komentarz komentarz){
        komentarzeList.remove(komentarz);
    }
}
