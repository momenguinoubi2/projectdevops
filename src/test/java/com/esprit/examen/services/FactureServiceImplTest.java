package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {
	@Autowired
	IFactureService factureService;
	
@Test	
public void addFacture() {
	float mRemise=100;
	float montant=200;
	Facture f = new Facture();
	Facture savedFacture= factureService.addFacture(f);
	assertNotNull(savedFacture.getIdFacture());
}
}
