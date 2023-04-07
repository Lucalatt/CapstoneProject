package it.epicode.lucal.App.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.lucal.App.entities.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

	Optional<Utente> findByUsername(String n);
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM utenti WHERE LOWER(sport) LIKE LOWER(CONCAT('%', :fn, '%'))"
        )
    List<Utente> findBySport(@Param("fn") String sport);
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM utenti WHERE LOWER(regione) LIKE LOWER(CONCAT('%', :fn, '%'))"
        )
    List<Utente> findByRegione(@Param("fn") String regione);
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM utenti WHERE LOWER(citta) LIKE LOWER(CONCAT('%', :fn, '%'))"
        )
    List<Utente> findByCitta(@Param("fn") String citta);
	
	@Query(
            nativeQuery = true,
            value = "SELECT * FROM utenti WHERE LOWER(competizione) LIKE LOWER(CONCAT('%', :fn, '%'))"
        )
    List<Utente> findByCompetizione(@Param("fn") String competizione);

}
