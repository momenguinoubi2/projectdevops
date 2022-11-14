package com.esprit.examen.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.IProduitService;
import com.esprit.examen.services.ProduitServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ProduitServiceImplTest {
	@Autowired
	IProduitService service;
	ProduitRepository produitRepository = Mockito.mock(ProduitRepository.class);
	@InjectMocks
	private ProduitServiceImpl produitServiceImpl;
	private Produit p = Produit.builder().libelleProduit("").codeProduit("").build();
	private ArrayList<Produit> list = new ArrayList<Produit>() {

		{
			add(Produit.builder().libelleProduit("").codeProduit("").build());
			add(Produit.builder().libelleProduit("eedfdf").codeProduit("").build());

		}
	};

	
	@Test
	void testAddProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");

	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Mockito.when(produitRepository.save(Mockito.any(Produit.class))).then(invocation -> {
			Produit model = invocation.getArgument(0, Produit.class);
			model.setIdProduit((long) 1);
			return model;
		});
		log.info("Avant" + p.toString());
		Produit produit = produitServiceImpl.addProduit(p);
		assertSame(produit,p);
		log.info("apres" + p.toString());
		
	
		
	} 
	@Test
	void testDeleteProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");
		Produit p = new Produit(null, "322","ezzeze",4, datecreation, datemodif, null, null, null );
		Produit produit = service.addProduit(p);
		service.deleteProduit(produit.getIdProduit());
		assertNull(service.retrieveProduit(produit.getIdProduit()));
	}
	@Test
	void testRetrieveAllProduits() throws ParseException {
		Mockito.when(produitRepository.findAll()).thenReturn(list);
		List<Produit> produits = produitServiceImpl.retrieveAllProduits();
		assertNotNull(produits);
		for (Produit produit : produits) {
			log.info(produits.toString());
		}
		
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date datecreation = dateFormat.parse("30/09/2000");
//		Date datemodif = dateFormat.parse("30/09/2000");
//		List<Produit> produits = service.retrieveAllProduits();
//		int expected = produits.size();
//		Produit p = new Produit(null, "322","ezzeze",4, datecreation, datemodif, null, null, null );
//
//		Produit produit = service.addProduit(p);
//		assertEquals(expected + 1, service.retrieveAllProduits().size());
//		service.deleteProduit(produit.getIdProduit());

	}
}
