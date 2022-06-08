package com.example.filmownia.views;


import com.example.filmownia.views.list.FilmView;
import com.example.filmownia.views.list.OsobaView;
import com.example.filmownia.views.list.UzytkownikView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@PageTitle("Main")
@Route(value="")
public class MainLayout extends AppLayout {

    //private final SecurityService securityService;

public MainLayout(){

        createHeader();
        createDrawer();

    }
    private void createHeader(){
        H1 logo = new H1("Filmownia");
        logo.addClassNames("text-l", "m-m");
        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo
        );
        //Button logout = new Button("Log out", e -> securityService.logout());
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }
    private void createDrawer() {
        RouterLink uzytkownikLink = new RouterLink("Użytkownicy", UzytkownikView.class);
        RouterLink filmLink = new RouterLink("Filmy", FilmView.class);
        RouterLink osobaLink = new RouterLink("Aktorzy i reżyserowie", OsobaView.class);
        addToDrawer(new VerticalLayout(
                uzytkownikLink,
                filmLink,
                osobaLink
        ));

    }




}
