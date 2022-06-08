//package com.example.filmownia;


import com.example.filmownia.views.MainLayout;
import com.example.filmownia.views.list.FilmView;
import com.example.filmownia.views.list.OsobaView;
import com.example.filmownia.views.list.UzytkownikView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//@Service
//public class SecurityService {
//    public record AuthorizedRoute(String route, String name, Class<? > view ) {}
//    public Uzytkownik currentUser;
//    public class AuthException extends Exception{
//
//    }
//
//    //private static final String LOGOUT_SUCCESS_URL = "/";
//    private final UzytkownikRepository uzytkownikRepository;
//
//    public SecurityService(UzytkownikRepository uzytkownikRepository){
//        this.uzytkownikRepository= uzytkownikRepository;
//    }
//
//    public void authenticate(String login, String haslo) throws AuthException {
//        Uzytkownik uzytkownik = uzytkownikRepository.getByLogin(login);
//        if(uzytkownik != null && uzytkownik.sprawdzHaslo(haslo)){
//            Notification.show("zalogowano");
//            currentUser = uzytkownik;
//            createRoutes(uzytkownik);
//        }else {
//            throw new AuthException();
//        }
//    }
//    private void createRoutes(Uzytkownik currentUser) {
//        getAuthorizedRoutes(currentUser);
//    }
//
//    public List<AuthorizedRoute> getAuthorizedRoutes(Uzytkownik currentUser) {
//        var routes = new ArrayList<AuthorizedRoute>();
//
//        if (this.currentUser != null) {
//            routes.add(new AuthorizedRoute("film-view-user", "Filmy", FilmView.class));
//            routes.add(new AuthorizedRoute("osoba-view", "Aktorzy i reżyserowie", OsobaView.class));
//            routes.add(new AuthorizedRoute("uzytkownik-view", "Inni użytkownicy", UzytkownikView.class));
//
//        } else  {
//            routes.add(new AuthorizedRoute("film-view-regular", "Filmy", FilmViewRegular.class));
//            routes.add(new AuthorizedRoute("osoba-view", "Aktorzy i reżyserowie", OsobaView.class));
//        }
//
//        return routes;
//    }
//
//
//
////    public void logout() {
////        UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
////        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
////        logoutHandler.logout(
////                VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
////                null);
////    }
//}
