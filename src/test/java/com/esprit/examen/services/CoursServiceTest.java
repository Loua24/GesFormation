package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import lombok.extern.slf4j.Slf4j;
//@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class CoursServiceTest {

	
@Autowired
	CoursRepository coursRepository;
	
	@Autowired
	ICoursService coursService;

	@Test
	void testAddCours() {
		Cours cours = new Cours();
		cours.setDescription("Desc");
		cours.setIntitule("Name");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		Long dataPreTest = coursRepository.count();
		coursService.addCours(cours);
		Long dataAfterTest = coursRepository.count();
		assertThat(dataPreTest).isEqualTo(dataAfterTest - 1);
		log.info("here test journalisation" + cours);
		coursRepository.delete(cours);
	}

	@Test
	void modifierCoursTest() {
		Cours cours = new Cours();
		cours.setDescription("Desc");
		cours.setIntitule("Name");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		Long Id = coursService.addCours(cours);
		log.info("test" + cours);
		cours.setTypeCours(TypeCours.MECANIQUE);
		coursRepository.save(cours);
		assertThat(cours.getTypeCours()).isEqualTo(TypeCours.MECANIQUE);
		log.info("test2" + cours);
		coursRepository.delete(cours);
	} 

	@Test
	void SupprimerCoursTest() {
		Long id;
		Cours cours = new Cours();
		cours.setDescription("Desc");
		cours.setIntitule("Name");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		//coursService=new CoursService();
		id =coursService.addCours(cours);
		Long dataPreTest = coursRepository.count();
		coursService.supprimerCours(id);; 
		Long dataAfterTest = coursRepository.count();
		assertThat(dataPreTest).isEqualTo(dataAfterTest + 1);

	}

}
