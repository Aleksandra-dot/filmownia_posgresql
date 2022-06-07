
package com.example.filmownia.views.list;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.textfield.TextField;

public class UzytkownikForm extends FormLayout {

    H2 naglowek = new H2("Dodaj Uzytkownika");
    TextField loginTxt = new TextField("Login");
    TextField hasloTxt = new TextField("Haslo");
    Button saveBtn = new Button("Dodaj", this::save);

    private void save(ClickEvent event){

    }
}
