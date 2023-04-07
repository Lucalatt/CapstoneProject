package it.epicode.lucal.App.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.lucal.App.entities.Messaggio;



@Repository
public interface MessageRepo extends JpaRepository<Messaggio, Integer>{
	
	

}
