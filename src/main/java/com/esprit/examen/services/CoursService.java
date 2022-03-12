package com.esprit.examen.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	SessionRepository sessionRepository;

	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		log.info("shawty");
		return cours.getId();
	}

	@Override
	public Long modifierCours(Long coursId, Cours cours) {
		Cours c;
		Optional<Cours> optCours = coursRepository.findById(coursId);
		if (optCours.isPresent()) {
			c = optCours.get();

			c.setDescription(cours.getDescription());
			c.setIntitule(cours.getIntitule());
			c.setTypeCours(cours.getTypeCours());
			coursRepository.save(c);
		}
		return cours.getId();

	}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);

	}

	@Override
	public List<Cours> getCours() {

		return coursRepository.findAll();
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId) {
		Cours cours = new Cours();
		Session session = null;
		Optional<Cours> optCours = coursRepository.findById(coursId);
		if (optCours.isPresent()) {
			cours = optCours.get();
		}
		Optional<Session> optSession = sessionRepository.findById(sessionId);
		if (optSession.isPresent()) {
			session = optSession.get();

			Set<Session> set = new HashSet<>();
			set.add(session);
			cours.setSessions(set);
			coursRepository.save(cours);
		}                                 
	}

}
