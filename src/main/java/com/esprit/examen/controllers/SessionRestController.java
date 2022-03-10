package com.esprit.examen.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.examen.entities.Session;
import com.esprit.examen.services.ISessionService;

@RequestMapping("/session")
@RestController
public class SessionRestController {

	@Autowired
	ISessionService sessionService;
	
	@PostMapping
	@ResponseBody
	public Session ajouterSession(@RequestBody Session session) {
		sessionService.addSession(session);
		return session;
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<Session> listSessions() {
		return sessionService.findAllSessions();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Session> getSession(@PathVariable("id") Long id) {
		return sessionService.findSession(id);
	}

	@PutMapping
	@ResponseBody
	public Session modifierSession(@RequestBody Session session) {
		sessionService.addSession(session);
		return session;
	}
	
	@PutMapping("/affecterFormateurASession/{formateurId}/{sessionId}")
	@ResponseBody
	public String affecterFormateurASession(@PathVariable("formateurId")  Long formateurId, @PathVariable("sessionId") Long sessionId) {
		sessionService.affecterFormateurASession(formateurId, sessionId);
		return "formateur affecté correctement";
	}

	@DeleteMapping("/{sessionId}")
	@ResponseBody
	public void supprimerSession(@PathVariable("sessionId") Long sessionId) {
		sessionService.supprimerSession(sessionId);
	}
}
