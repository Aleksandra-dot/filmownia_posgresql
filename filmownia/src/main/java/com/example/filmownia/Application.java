package com.example.filmownia;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(UzytkownikRepository uzytkownikRepository,
                                         KomentarzRepository komentarzRepository,
                                         OsobaRepository osobaRepository,
                                         FilmRepository filmRepository) {
        return args -> {

            //create new users
//            Uzytkownik u1 = new Uzytkownik ("user3", "haslo3");
//            Uzytkownik u2 = new Uzytkownik("user4", "haslo4");
//            Uzytkownik u3 = new Uzytkownik("user5", "haslo5");
//
//            uzytkownikRepository.saveAll(
//                    List.of(u1, u2, u3));
//            Film f1 = new Film("Blade Runner", 1990, 117, Film.enumGatunek.SciFi);
//            Film f2 = new Film("Legalna Blondynka", 2012, 120, Film.enumGatunek.Romans);
//            Film f3 = new Film("Fight Club", 2004, 125, Film.enumGatunek.Thriller);
//
//            filmRepository.saveAll(List.of(f1, f2, f3));
//
//            //create and save new comments
//            Komentarz k1 = new Komentarz("Gniot", Komentarz.enumOcena.Slaby, 4 , u1, f1);
//            Komentarz k2 = new Komentarz("Uwielbiam", Komentarz.enumOcena.Super, 8, u2, f1);
//            Komentarz k3 = new Komentarz("Nuuuuda", Komentarz.enumOcena.Sredni, 5, u3, f1);
//            Komentarz k4 = new Komentarz("Inspirujący", Komentarz.enumOcena.Dobry, 7.5, u1, f2);
//            Komentarz k5 = new Komentarz("Dla bab", Komentarz.enumOcena.Slaby, 3, u2, f2);
//            Komentarz k6 = new Komentarz("Dla odstresowania dobry", Komentarz.enumOcena.Sredni, 4.5, u3, f2);
//            Komentarz k7 = new Komentarz("Mindblowing", Komentarz.enumOcena.Super, 9, u1, f3);
//            Komentarz k8 = new Komentarz("Niesamowity", Komentarz.enumOcena.Super, 9, u2, f3 );
//            Komentarz k9 = new Komentarz("Przekombinowany, ale Brad Pitt robi robotę", Komentarz.enumOcena.Dobry, 7, u3, f3 );
//            komentarzRepository.saveAll(List.of(k1, k2, k3, k4, k5, k6, k7, k8, k9));
//
//
//            Osoba o1 = new Osoba("Ridley", "Scott",  "29.02.1965", 185);
//            Osoba o2 = new Osoba("Harrison", "Ford", "01.05.1975", 166);
//            Osoba o3 = new Osoba("Sean", "Young", "07.11.1962", 172);
//
//            Osoba o4 = new Osoba("Robert", "Luketic", "13.04.1986", 182);
//            Osoba o5 = new Osoba("Reese", "Witherspoon", "13.11.1992", 167);
//            Osoba o6 = new Osoba("Luke", "Wilson", "01.10.1978", 184);
//
//            Osoba o7 = new Osoba("David", "Fincher", "09.07.1982", 185);
//            Osoba o8 = new Osoba("Brad", "Pitt", "12.11.1986", 185);
//            Osoba o9 = new Osoba("Edward", "Norton", "07.03.1989", 182);
//
//
//
//            osobaRepository.saveAll(
//                    List.of(o1, o2, o3, o4, o5, o6, o7, o8, o9));
//            f1.dodajObsade(o3);
//            f1.dodajObsade(o2);
//            f1.dodaj_rezysera(o1);
//            f1.dodajKomentarz(k1);
//            f1.dodajKomentarz(k2);
//            f1.dodajKomentarz(k3);
//            o1.dodajFilm(f2);
//            o2.dodajFilm(f1);
//            o3.dodajFilm(f1);
//            u1.dodajKomentarz(k1);
//            u2.dodajKomentarz(k2);
//            u3.dodajKomentarz(k3);
//
//            f2.dodajObsade(o6);
//            f2.dodajObsade(o5);
//            f2.dodaj_rezysera(o4);
//            f2.dodajKomentarz(k4);
//            f2.dodajKomentarz(k5);
//            f2.dodajKomentarz(k6);
//            o4.dodajFilm(f2);
//            o5.dodajFilm(f2);
//            o6.dodajFilm(f2);
//            u1.dodajKomentarz(k4);
//            u2.dodajKomentarz(k5);
//            u3.dodajKomentarz(k6);
//
//            f3.dodajObsade(o9);
//            f3.dodajObsade(o8);
//            f3.dodaj_rezysera(o7);
//            f3.dodajKomentarz(k7);
//            f3.dodajKomentarz(k8);
//            f3.dodajKomentarz(k9);
//            o7.dodajFilm(f3);
//            o8.dodajFilm(f3);
//            o9.dodajFilm(f3);
//            u1.dodajKomentarz(k7);
//            u2.dodajKomentarz(k8);
//            u3.dodajKomentarz(k9);
//
//            osobaRepository.saveAll(
//                    List.of(o1, o2, o3, o4, o5, o6, o7, o8, o9));
//            filmRepository.saveAll(List.of(f1, f2, f3));


        };
    }
}
