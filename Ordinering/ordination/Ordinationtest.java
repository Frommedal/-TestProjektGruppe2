package ordination;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;

import org.junit.Test;

import Controller.Controller;
import ordination.Patient;

public class Ordinationtest {
//	private Patient janeJensen = new Patient("121256-0512", "Jane Jensen", 63.4);
//	private Laegemiddel paracetamol = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
//
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void tc1() {
//		Ordination o = new Ordination(2015-01-01, 2015-01-12, janeJensen, paracetamol);
//	}
//	
//	
//	@Test
//	public void t123c1() {
//		b.setGrundpr�mie(1000);
//		double res = b.beregnPr�mie(18, true, 0);
//		System.out.println(b.beregnPr�mie(18, true, 0));
//		assertEquals(1187.5, res, 0.001);
//	}
//	
//
//
	
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
	
	
}
