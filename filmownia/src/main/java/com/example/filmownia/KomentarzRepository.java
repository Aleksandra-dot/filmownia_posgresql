package com.example.filmownia;

import org.hibernate.collection.internal.PersistentBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KomentarzRepository extends JpaRepository<Komentarz, Long> {





}
