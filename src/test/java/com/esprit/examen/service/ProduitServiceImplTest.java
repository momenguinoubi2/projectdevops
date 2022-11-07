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

import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
	@Autowired
	IProduitService service;
	
	@Test
	public void testAddProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");

	//	List<Stock> stocks = stockService.retrieveAllStocks();
	//	int expected=stocks.size();
		Produit p = new Produit(null, "322","ezzeze",4, datecreation, datemodif, null, null, null );
		Produit savedProduit= service.addProduit(p);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedProduit.getIdProduit());
		service.deleteProduit(savedProduit.getIdProduit());
		
	} 
	@Test
	public void testDeleteProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");
		Produit p = new Produit(null, "322","ezzeze",4, datecreation, datemodif, null, null, null );
		Produit produit = service.addProduit(p);
		service.deleteProduit(produit.getIdProduit());
		assertNull(service.retrieveProduit(produit.getIdProduit()));
	}
	@Test
	public void testRetrieveAllProduits() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datecreation = dateFormat.parse("30/09/2000");
		Date datemodif = dateFormat.parse("30/09/2000");
		List<Produit> produits = service.retrieveAllProduits();
		int expected = produits.size();
		Produit p = new Produit(null, "322","ezzeze",4, datecreation, datemodif, null, null, null );

		Produit produit = service.addProduit(p);
		assertEquals(expected + 1, service.retrieveAllProduits().size());
		service.deleteProduit(produit.getIdProduit());

	}
}
