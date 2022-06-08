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

import javax.annotation.security.PermitAll;
import java.util.List;

@Route(value = "osoba-view", layout = MainLayout.class)
@PermitAll()
public class OsobaView extends HorizontalLayout {
    final Grid<Osoba> grid;
    static Dialog dialog;
    static OsobaRepository repo;
    static Grid<Film> filmGrid = new Grid<>(Film.class);





    @Autowired
    public OsobaView( OsobaRepository repo) {
        this.repo=repo;
        this.grid = new Grid<>(Osoba.class, false);
        grid.addColumn(Osoba::getImie).setHeader("Imię");
        grid.addColumn(Osoba::getNazwisko).setHeader("Nazwisko");
        grid.addColumn(Osoba::getData_urodzenia).setHeader("Data urodzenia");
        grid.addColumn(Osoba::getWzrost).setHeader("Wzrost");
        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, film) -> {
                    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.zobaczFilmy(film));
                    button.setText("Zobacz filmy");
                })).setHeader("Filmy");
        add(grid);
        listOsoby();
    }
    public void zobaczFilmy(Osoba osoba){
        dialog = new Dialog();
        dialog.add(new H1("Obsada"));
        dialog.add(configureFilmGrid(osoba));
        dialog.setWidth("1250px");
        dialog.open();
    }

    public Grid<Film> configureFilmGrid(Osoba osoba){
        filmGrid = new Grid<>(Film.class, false );  //resets the grid (creates new one)
        filmGrid.setHeight("1000px");
        filmGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        filmGrid.addColumn(Film::getTytul).setHeader("Tytuł");
        filmGrid.addColumn(Film::getRok).setHeader("Rok");
        filmGrid.addColumn(Film::getGatunek).setHeader("Gatunek");
        filmGrid.addColumn(Film::licz_srednia).setHeader("Średnia ocen");
        filmGrid.addColumn(Film::getRezyserowie).setHeader("Reżyser");

        List<Film> filmy = osoba.getFilmy();
        filmGrid.setItems(filmy);

        filmGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        return filmGrid;
    }



    private void listOsoby() {
        List<Osoba> osoby = repo.findAll();
        grid.setItems( osoby);

    }
}
