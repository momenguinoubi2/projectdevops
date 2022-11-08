package com.esprit.examen.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.IFournisseurService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService service;
	@Test
	public void testAddFournisseur() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");

	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Fournisseur f = new Fournisseur(null,"eed","sfsdf",null,null,null,null );
		Fournisseur savedFournisseur= service.addFournisseur(f);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedFournisseur.getLibelle());
		service.deleteFournisseur(savedFournisseur.getIdFournisseur());
		
	} 
	@Test
	public void testDeleteFournisseur() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");
		Fournisseur f = new Fournisseur(null,"eed","sfsdf",null,null,null,null );
		Fournisseur savedFournisseur= service.addFournisseur(f);
		service.deleteFournisseur(savedFournisseur.getIdFournisseur());
		assertNull(service.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
	}
	@Test
	public void testRetrieveFournisseurs() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");
		List<Fournisseur> fournisseur = service.retrieveAllFournisseurs();
		int expected = fournisseur.size();
		Fournisseur f = new Fournisseur(null,"eed","sfsdf",null,null,null,null );

		Fournisseur Fournisseur = service.addFournisseur(f);
		assertEquals(expected + 1, service.retrieveAllFournisseurs().size());
		service.deleteFournisseur(Fournisseur.getIdFournisseur());

	}

}
