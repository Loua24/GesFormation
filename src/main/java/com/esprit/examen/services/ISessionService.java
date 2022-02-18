package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;

import com.esprit.examen.entities.Session;

public interface ISessionService {
	Optional<Session>  findSession(Long id);
	
	Long addSession(Session session);

	Long modifierSession(Session session);

	void supprimerSession(Long sessionId);
	
	void affecterFormateurASession (Long formateurId, Long sessionId);
	
	List<Session> findAllSessions();
	
	Long count();
}
