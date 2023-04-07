package it.epicode.lucal.App.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.lucal.App.entities.Messaggio;
import it.epicode.lucal.App.entities.Utente;
import it.epicode.lucal.App.repositories.MessageRepo;

@Service
public class MessaggioService {
	
	@Autowired
	private MessageRepo mr;
	
	public Messaggio save(Messaggio m) {
		return mr.save(m);
	}
	
	public List<Messaggio> getAll() {
		return mr.findAll();
	}
	
	public Optional<Messaggio> getById(int id) {
		return mr.findById(id);
	}
	
	
	public Page<Messaggio> getAll_page(Pageable pageable) {
		return mr.findAll(pageable);
	}
	
	public void delete(Messaggio m) {
		mr.delete(m);
	}

}
