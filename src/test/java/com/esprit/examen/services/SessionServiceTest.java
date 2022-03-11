package com.esprit.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.slf4j.Slf4j;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class SessionServiceTest {
	@Autowired
	private SessionRepository ss;

	@Test
	public void testAddSession() throws ParseException {

		log.info("testing session add");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateD = dateFormat.parse("2015-03-23");
		Date dateF = dateFormat.parse("2016-03-23");
		String desc = "my test session";
		Session se = new Session(88L, dateD, dateF, 10L, desc);
		Long dataBeforeTest = ss.count();
		ss.save(se);
		Long dataAfterTest = ss.count();
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest - 1);
		ss.delete(se);
	}

}
