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

import java.util.List;

import static java.lang.Long.parseLong;

@Route(value = "uzytkownik-view", layout = MainLayout.class)
public class UzytkownikView extends HorizontalLayout {


    final Grid<Uzytkownik> grid;
    static Dialog dialog;
    private final UzytkownikService uzytkownikService;
    static Grid<Komentarz> komentarzGrid = new Grid<>(Komentarz.class);
    static Uzytkownik user;

    @Autowired


    public UzytkownikView(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
        this.grid = new Grid<>(Uzytkownik.class, false);
        grid.addColumn(Uzytkownik::getLogin).setHeader("Login");
        add(grid);
        listUsers();
    }

    private void listUsers(){
        List<Uzytkownik> allUsers = (List<Uzytkownik>) uzytkownikService.getUzytkownikow();
        grid.setItems(allUsers);

        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, film) -> {
                    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> this.zobaczKometarze(film));
                    button.setText("Zobacz komentarze");
                })).setHeader("Komentarze");

    }

    public void zobaczKometarze(Uzytkownik user){
        this.user = user;
        dialog = new Dialog();
        dialog.add(new H1("Komentarze filmu"));     ;
        dialog.add(configureKomentarzGrid(user));
        dialog.setWidth("1250px");
        dialog.open();
    }

    public Grid<Komentarz> configureKomentarzGrid(Uzytkownik user) {

        komentarzGrid = new Grid<>(Komentarz.class, false );  //resets the grid (creates new one)
        komentarzGrid.setHeight("1000px");
        komentarzGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        komentarzGrid.addColumn(Komentarz::getFilm).setHeader("Film");
        komentarzGrid.addColumn(Komentarz::getOcena_kom).setHeader("Ocena");
        komentarzGrid.addColumn(Komentarz::getOcena).setHeader("Ocena");
        komentarzGrid.addColumn(Komentarz::getTresc).setHeader("Komentarz");

        List<Komentarz> coms = user.getKomentarze();
        komentarzGrid.setItems(coms);

        komentarzGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        return komentarzGrid;

    }








}
