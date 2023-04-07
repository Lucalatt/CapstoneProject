package it.epicode.lucal.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.lucal.App.entities.Ruolo;



@Repository
public interface RuoloRepo extends JpaRepository<Ruolo, Integer> {

}
