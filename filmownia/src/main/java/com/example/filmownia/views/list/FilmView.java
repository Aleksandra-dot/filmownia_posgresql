package com.example.filmownia.views.list;

import com.example.filmownia.*;
import com.example.filmownia.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@Route(value = "film-view", layout = MainLayout.class)

public class FilmView extends HorizontalLayout {


    final Grid<Film> grid;
    private final FilmRepository Frepo ;
    static Dialog dialog;
    static KomentarzRepository Krepo;
    static UzytkownikRepository Urepo;
    static Uzytkownik currentUser;
    static Film currentFilm;
    static List<Komentarz> listKomentarze = new ArrayList<>();
    static List<Osoba> listObsada = new ArrayList<>();
    static Grid<Komentarz> komentarzGrid = new Grid<>(Komentarz.class);
    static Grid<Osoba> obsadaGrid = new Grid<>(Osoba.class);
    KomentarzForm kf;




    @Autowired


    public FilmView(UzytkownikRepository urepo, KomentarzRepository repo, FilmRepository frepo) {
        this.Krepo=repo;
        this.Frepo = frepo;
        this.Urepo = urepo;
        this.currentUser = new Uzytkownik("login", "haslo");
        this.grid = new Grid<>(Film.class, false);

        grid.addColumn(Film::getTytul).setHeader("Tytuł");
        grid.addColumn(Film::getRok).setHeader("Rok");
        grid.addColumn(Film::getGatunek).setHeader("Gatunek");
        grid.addColumn(Film::getCzas).setHeader("Długość");
        grid.addColumn(Film::licz_srednia).setHeader("Średnia ocen");
        grid.addColumn(Film::getRezyserowie).setHeader("Reżyser");
        add(grid);
        listFilms();
    }



    private void listFilms() {
        List<Film> allFilms = Frepo.findAll();
        grid.setItems(allFilms);
        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, film) -> {
                    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.dodajKometarz(film));
                    button.setText("Dodaj kometarz");
                })).setHeader("Komentarze");
        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, film) -> {
                    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.zobaczObsade(film));
                    button.setText("Zobacz obsadę");
                })).setHeader("Obsada");

    }

    public void zobaczObsade(Film film){
        currentFilm = film;

        dialog = new Dialog();
        dialog.add(new H1 ("Obsada"));
        dialog.add(configureObsadaGrid(film));
        dialog.setWidth("1250px");
        dialog.open();
    }

    public void dodajKometarz(Film film){
        currentFilm = film;
        dialog = new Dialog();
        dialog.add(new H1("Komentarze filmu"));
        dialog.add(configureKomentarzForm(Krepo, Frepo, Urepo, film, currentUser));        ;
        dialog.add(configureKomentarzGrid(film));
        dialog.setWidth("1250px");
        dialog.open();
    }

    public Grid<Osoba> configureObsadaGrid(Film film){
        obsadaGrid = new Grid<>(Osoba.class, false);
        obsadaGrid.setHeight("1000px");
        obsadaGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        obsadaGrid.addColumn(Osoba::getImie).setHeader("Imię");
        obsadaGrid.addColumn(Osoba::getNazwisko).setHeader("Nazwisko");
        listObsada = film.getObsada();
        obsadaGrid.setItems(listObsada);
        obsadaGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        return obsadaGrid;
    }
    public Grid<Komentarz> configureKomentarzGrid(Film film) {

        komentarzGrid = new Grid<>(Komentarz.class, false );  //resets the grid (creates new one)
        komentarzGrid.setHeight("1000px");
        komentarzGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        komentarzGrid.addColumn(Komentarz::getUzytkownik).setHeader("Użytkownik");
        komentarzGrid.addColumn(Komentarz::getOcena_kom).setHeader("Ocena");
        komentarzGrid.addColumn(Komentarz::getOcena).setHeader("Ocena");
        komentarzGrid.addColumn(Komentarz::getTresc).setHeader("Komentarz");

        List<Komentarz> coms = film.getKomentarze();
        komentarzGrid.setItems(coms);

        komentarzGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        return komentarzGrid;

    }

    public KomentarzForm configureKomentarzForm(KomentarzRepository repo, FilmRepository frepo, UzytkownikRepository urepo, Film film, Uzytkownik user){

        kf = new KomentarzForm(repo, frepo, urepo,film, user);
        kf.setWidth("200px");
        return kf;


    }


}
