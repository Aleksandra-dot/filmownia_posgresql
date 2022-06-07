package com.example.filmownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/uzytkownik")
public class UzytkownikController {

    private final UzytkownikService uzytkownikService;

    @Autowired
    public UzytkownikController(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }

    @GetMapping
    public List<Uzytkownik> getUzytkownikow(){
        return uzytkownikService.getUzytkownikow();
    }

    @GetMapping("id")
    public Optional<Uzytkownik> getUserById(@RequestParam(value = "id", defaultValue = "1") Long id){ return uzytkownikService.getUserById(id);}

}