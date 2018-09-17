package ordination;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;

import org.junit.Test;

import Controller.Controller;
import ordination.Patient;

public class Ordinationtest {
	
	Controller c = Controller.getTestService();
	
	@Before
	public void initialiser() {
		
		c.createSomeObjects();
	}
	
	@Test
	public void tc1() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Jane Jensen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Paracetamol")){
				l = y;
			}		
		}
		
		PN g = new PN(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 12), p, l, 123);
		
		assertEquals(true, g.equals(c.opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 12), p, l, 123)));
	}
	
	@Test
	public void tc2() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Jane Jensen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Acetylsalicylsyre")){
				l = y;
			}		
		}
		
		PN g = new PN(LocalDate.of(2015, 2, 12), LocalDate.of(2015, 2, 14), p, l, 3);
		
		assertEquals(true, g.equals(c.opretPNOrdination(LocalDate.of(2015, 2, 12), LocalDate.of(2015, 2, 14), p, l, 3)));
		
	}
	
	@Test
	public void tc3() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Ulla Nielsen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Fucidin")){
				l = y;
			}		
		}
		
		PN g = new PN(LocalDate.of(2015, 1, 20), LocalDate.of(2015, 1, 25), p, l, 5);
		
		assertEquals(true, g.equals(c.opretPNOrdination(LocalDate.of(2015, 1, 20), LocalDate.of(2015, 1, 25), p, l, 5)));
		
	}
	
	@Test
	public void tc4() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Finn Madsen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Paracetamol")){
				l = y;
			}		
		}
		
		PN g = new PN(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 1), p, l, 100);
		
		assertEquals(true, g.equals(c.opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 1), p, l, 100)));
		
	}
	
	@Test
	public void tc5() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Finn Madsen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Fucidin")){
				l = y;
			}		
		}
		
		try {			
			c.opretPNOrdination(LocalDate.of(2015, 1, 2), LocalDate.of(2015, 1, 1), p, l, 5);
			
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negativt antal dage");
		}
	}
	
	@Test
	public void tc6() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Finn Madsen")){
				p = y;
			}		
		}
		try {			
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Kodimagnyl")){
				l = y;
			}		
		}
		
		
			c.opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 1), p, l, 5);
			
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Forkert laegemiddel");
		}
	}
	
	@Test
	public void tc7() {
		Patient p = null;
		Laegemiddel l = null;
		
		for(Patient y : c.getAllPatienter()) {
			if(y.getNavn().equals("Finn Madsen")){
				p = y;
			}		
		}
		
		for(Laegemiddel y : c.getAllLaegemidler()) {
			if(y.getNavn().equals("Paracetamol")){
				l = y;
			}		
		}
		
		try {			
			c.opretDagligFastOrdination(LocalDate.of(2015, 1, 2), LocalDate.of(2015, 1, 1), p, l, 2, -1, 1, -1);
			
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negativt antal dage");
		}
	}
	
	
}
