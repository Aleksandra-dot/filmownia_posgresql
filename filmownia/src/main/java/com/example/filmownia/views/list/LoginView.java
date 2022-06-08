//package com.example.filmownia.views.list;
//
//
//import com.example.filmownia.SecurityService;
//import com.example.filmownia.views.MainLayout;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.charts.model.Navigator;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.login.LoginForm;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.*;
//
//@Route("login")
//@PageTitle("Login | Vaadin CRM")
//@CssImport("./styles/login-view.css")
//public class LoginView extends VerticalLayout {
//
//
//
//    public LoginView(SecurityService securityService){
//        setId("login-view");
//        setSizeFull();
//        var login = new TextField("Login");
//        var haslo = new PasswordField("Haslo");
//        add(
//                new H1("Zaloguj się aby dodać komentarz"),
//                login,
//                haslo,
//                new Button("Zaloguj", event -> {
//                    try{
//                        securityService.authenticate(login.getValue(), haslo.getValue());
//                        UI.getCurrent().navigate("http://localhost:8080");
//                } catch (SecurityService.AuthException e) {
//                        Notification.show("Zły login lub hasło");
//                    }}));
//
//
//    }
//
//
//}
