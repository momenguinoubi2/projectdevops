package com.esprit.examen.service;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.OperateurServiceImpl;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest

 class OperateurServiceImplTest {
	
	OperateurRepository operateurRepository = Mockito.mock(OperateurRepository.class);
	@InjectMocks
	private OperateurServiceImpl operateurService;
	
	private Operateur o = Operateur.builder().nom("").prenom("").password("").build();

	private List<Operateur> list = new ArrayList<Operateur>() {
		
		{
			add(Operateur.builder().nom("Rami").prenom("Trabelsi").password("Bonjour123").build());
			add(Operateur.builder().nom("Rania").prenom("Laarafa").password("Bonnenuit123").build());

		}

	};
	
	@Test
	void addOperateurTest() {
		Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).then(invocation -> {
			Operateur model = invocation.getArgument(0, Operateur.class);
			model.setIdOperateur((long) 1);
			return model;
		});
		log.info("Avant" + o.toString());
		Operateur operateur = operateurService.addOperateur(o);
		assertSame(operateur, o);
		log.info("apres" + o.toString());
	}
	@Test
	void retrieveAllOperateursTest() {
		Mockito.when(operateurRepository.findAll()).thenReturn(list);
		List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
		assertNotNull(operateurs);
		for (Operateur operateur : operateurs) {
			log.info(operateur.toString());
		}
	}
	@Test
	void retrieveOperateurTest() {
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
		Operateur operateur = operateurService.retrieveOperateur((long) 1);
		assertNotNull(operateur);
		log.info("operateurs:" + operateur.toString());
		verify(operateurRepository).findById(Mockito.anyLong());

	}
	
	/*@Test
	public void deleteOperateurTest() {
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
		
		Operateur savedOperateur= operateurService.addOperateur(o);
		operateurService.deleteOperateur(savedOperateur.getIdOperateur());
		operateurService.retrieveOperateur(savedOperateur.getIdOperateur());
		log.info("operateurs:" + operateur.toString());
		verify(operateurRepository).findById(Mockito.anyLong());
	}*/
}
