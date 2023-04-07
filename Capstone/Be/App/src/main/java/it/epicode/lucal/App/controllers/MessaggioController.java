package it.epicode.lucal.App.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.lucal.App.entities.Messaggio;
import it.epicode.lucal.App.entities.Utente;
import it.epicode.lucal.App.services.MessaggioService;

@RestController
@RequestMapping("/")
public class MessaggioController {
	
	@Autowired MessaggioService ms;
	
	@GetMapping("messaggi")
	public ResponseEntity<Object> getMessaggi() {
		List<Messaggio> messaggio = ms.getAll();
		
		if(messaggio.isEmpty()) {
			return new ResponseEntity<>("Messaggi non trovati", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(messaggio, HttpStatus.CREATED);
	}
	
	@GetMapping("messaggi_page")
	public ResponseEntity<Object> getMessaggiInPages(Pageable pageable) {
		Page<Messaggio> messaggio = ms.getAll_page(pageable);
		
		if(messaggio.isEmpty()) {
			return new ResponseEntity<>("Messaggi non trovati", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(messaggio, HttpStatus.OK);
	}
	
	@GetMapping("messaggi/{id}")
	public ResponseEntity<Object> getMessaggioById(@PathVariable int id) {
		Optional<Messaggio> messaggiObj = ms.getById(id);
		
		if(messaggiObj.isEmpty()) {
			return new ResponseEntity<>("Messaggi non trovati", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(messaggiObj.get(), HttpStatus.OK);
	}
	
	@PostMapping("messaggi")
	public ResponseEntity<Object> createMessaggio(@RequestBody Messaggio m) {
		Messaggio messaggio = ms.save(m);
		
		return new ResponseEntity<Object>(messaggio, HttpStatus.CREATED);
	}
	
	@PutMapping("messaggi/{id}")
	public ResponseEntity<Object> updateMessaggio(@PathVariable int id, @RequestBody Messaggio _messaggio) {
		Optional<Messaggio> messaggiObj = ms.getById(id);
		
		if(messaggiObj.isEmpty()) {
			return new ResponseEntity<Object>("Messaggio non trovato", HttpStatus.NOT_FOUND);
		}
		
		Messaggio messaggio = messaggiObj.get();
		
		messaggio.setMessaggio(_messaggio.getMessaggio());
		
		ms.save(messaggio);
		
		return new ResponseEntity<Object>(messaggio, HttpStatus.CREATED);
	}
	
	@DeleteMapping("messaggi/{id}")
	public ResponseEntity<Object> deleteMessaggio(@PathVariable int id) {
		Optional<Messaggio> messaggiObj = ms.getById(id);
		
		if(messaggiObj.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		
		ms.delete(messaggiObj.get());
		
		return new ResponseEntity<>(String.format("Messaggio con id %d eliminat0", id), HttpStatus.OK);
	}
}
