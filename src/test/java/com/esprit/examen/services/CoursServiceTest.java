package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class CoursServiceTest {


	@Autowired
	CoursRepository coursRepository;
	
	@Test
	void testAddCours() {
		Cours cours = new Cours();
		cours.setDescription("Desc");
		cours.setIntitule("Name");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		Long dataPreTest = coursRepository.count();
		coursRepository.save(cours);
		Long dataAfterTest = coursRepository.count();
		assertThat(dataPreTest).isEqualTo(dataAfterTest -1);
		log.info("here test journalisation"+ cours);
		coursRepository.delete(cours); }
	

}
