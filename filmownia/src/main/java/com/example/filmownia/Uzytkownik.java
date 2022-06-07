package com.example.filmownia;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table
@Transactional
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String login;
    private String haslo;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Komentarz> komentarze = new ArrayList<>();

    public Uzytkownik() {
    }

    public Uzytkownik(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws NiepoprawnyLoginException {
        if (sprawdźlogin(login))
            this.login = login;
        else
            throw new NiepoprawnyLoginException();
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) throws NiepoprawneHasloException {
        if (sprawdźhaslo(haslo))
            this.haslo = haslo;
        else
            throw new NiepoprawneHasloException();
    }

    public void setKomentarze(List<Komentarz> komentarze) {
        this.komentarze = komentarze;
    }

    public List<Komentarz> getKomentarze(){
        return komentarze;
    }

    private boolean sprawdźlogin(String login){
        return !Pattern.compile("^[a-zA-Z_0-9]$").matcher(login).find();
    }
    private boolean sprawdźhaslo(String haslo){
        return !Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$").matcher(haslo).find();
    }

    public void dodajKomentarz(Komentarz komentarz){
        komentarze.add(komentarz);
    }

    @Override
    public String toString() {
        return login;
    }



}

