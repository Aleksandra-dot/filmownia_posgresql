package com.example.filmownia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {
    Uzytkownik getByLogin(String login);
}
