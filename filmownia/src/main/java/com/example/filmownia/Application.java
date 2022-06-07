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
//            Uzytkownik u1 = new Uzytkownik ("user1", "haslo1");
//            Uzytkownik u2 = new Uzytkownik("user2", "haslo2");
//
//            uzytkownikRepository.saveAll(
//                    List.of(u1, u2));
//            Film f1 = new Film("Dirty Dancing", 1987, 100, Film.enumGatunek.Dramat);
//            filmRepository.save(f1);
//
//            //create and save new comments
//            Komentarz k1 = new Komentarz("Super", Komentarz.enumOcena.Super, 7 , u1, f1);
//            Komentarz k2 = new Komentarz("Uwielbiam", Komentarz.enumOcena.Dobry, 8, u2, f1);
//            komentarzRepository.saveAll(List.of(k1, k2));
//
//
//            Osoba o1 = new Osoba("Patrick", "Swayze", "29.02.1965", 185);
//            Osoba o2 = new Osoba("Jennifer", "Grey", "01.05.1975", 166);
//            Osoba o3 = new Osoba("Emilie", "Ardolino", "07.11.1962", 172);
//            osobaRepository.saveAll(
//                    List.of(o1, o2, o3));
//            f1.dodajObsade(o1);
//            f1.dodajObsade(o2);
//            f1.dodaj_rezysera(o3);
//            f1.dodajKomentarz(k1);
//            f1.dodajKomentarz(k2);
//            o1.dodajFilm(f1);
//            o2.dodajFilm(f1);
//            o3.dodajFilm(f1);
//            osobaRepository.saveAll(
//                    List.of(o1, o2, o3));
//            filmRepository.save(f1);


        };
    }
}
