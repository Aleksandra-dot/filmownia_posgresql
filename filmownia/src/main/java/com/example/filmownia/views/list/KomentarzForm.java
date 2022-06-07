package com.example.filmownia.views.list;
import com.example.filmownia.*;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class KomentarzForm extends FormLayout{
    private final KomentarzRepository Krepo;
    private final FilmRepository Frepo;
    private final UzytkownikRepository Urepo;
    Film currentFilm;
    Uzytkownik currentUzytkownik;
    H2 naglowek = new H2("Dodaj komentarz");
    TextField modelTxt = new TextField("Komentarz");
    NumberField ocena = new NumberField("Ocena");
    ComboBox<Komentarz.enumOcena> ocenaCmb = new ComboBox<>("Ocena");
    Button zatwierdzBtn = new Button("Dodaj", this::save);
    //Button usunBtn = new Button("Usun", this::remove);
    //Button zamknijBtn = new Button("Zamknij", this::close);

    public KomentarzForm(KomentarzRepository repo, FilmRepository frepo, UzytkownikRepository urepo, Film film, Uzytkownik user){
        this.Krepo = repo;
        this.Frepo = frepo;
        this.Urepo = urepo;
        this.currentFilm = film;
        this.currentUzytkownik = user;
        ocenaCmb.setItems(Komentarz.enumOcena.values());
        VerticalLayout verticalLayout = new VerticalLayout(naglowek, modelTxt, ocena, ocenaCmb, zatwierdzBtn);
        add(verticalLayout);
    }



    private void save(ClickEvent event){
        try{
            Komentarz k = new Komentarz(modelTxt.getValue(),
                    ocenaCmb.getValue(),
                    ocena.getValue(),
                    currentUzytkownik, currentFilm);
            //currentFilm.dodajKomentarz(k);
            //currentUzytkownik.dodajKomentarz(k);
            Frepo.save(currentFilm);
            Urepo.save(currentUzytkownik);

            FilmView.listKomentarze.add(k);
            Krepo.save(k);

            FilmView.komentarzGrid.setItems(Krepo.findAll());
            Notification.show("Dodano komentarz");
        }
        catch(Exception e){
            Notification.show("Coś poszło nie tak"+ e.getMessage());
        }
    }

    private void close(ClickEvent event){
        FilmView.dialog.close();
    }
}
