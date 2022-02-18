package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SessionService implements ISessionService{

	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Long addSession(Session session) {
		sessionRepository.save(session);
		log.info("adding a new session");
		return session.getId();
	}

	@Override
	public Long modifierSession(Session session) {
		sessionRepository.save(session);
		log.info("updating session");
		return session.getId();
	}

	@Override
	public void supprimerSession(Long sessionId) {
		sessionRepository.deleteById(sessionId);
		log.info("session deleted");
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
			/*todo*/
		
	}

	@Override
	public Optional<Session> findSession(Long id) {
	return sessionRepository.findById(id);
	}

	@Override
	public List<Session> findAllSessions() {
		return sessionRepository.findAll();
	}

	@Override
	public Long count() {
		return sessionRepository.count();
	}
	

}
