package Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.util.List;

import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import storage.Storage;

public class Controller {
    private Storage storage;
    private static Controller service;
    
    private Controller() {
        storage = new Storage();
    }
    
    public static Controller getService() {
        if (service == null) {
            service = new Controller();
        }
        return service;
    }
    
    public static Controller getTestService() {
        return new Controller();
    }
    
    /**
     * Hvis startDato er efter slutDato kastes en IllegalArgumentException og
     * ordinationen oprettes ikke
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     *
     * @return opretter og returnerer en PN ordination.
     * @throws Exception 
     */
    public PN opretPNOrdination(LocalDate startDen, LocalDate slutDen,
    		Patient patient, Laegemiddel laegemiddel, double antal) throws IllegalArgumentException {

    	if(!startDen.equals(null) && !slutDen.equals(null) && !patient.equals(null) && !laegemiddel.equals(null)) {


    		Period p = Period.between(startDen, slutDen);
    		int days = p.getDays() + 1;

    		if(days < 0) {
    			throw new IllegalArgumentException("Negativt antal dage");
    		}
    		PN pn = new PN(startDen, slutDen, patient, laegemiddel, antal);

    		return pn;
    	}
    	else {
    		throw new IllegalArgumentException("Du mangler noget information");
    	}
    }
    
    /**
     * Opretter og returnerer en DagligFast ordination. Hvis startDato er efter
     * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     */
    public DagligFast opretDagligFastOrdination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal,double natAntal) {
    	
    	DagligFast dagligFast = new DagligFast(startDen, slutDen, patient, laegemiddel, morgenAntal, middagAntal, aftenAntal, natAntal);
        
    	int daysBetween = (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    	
    	if (daysBetween < 1) {
    		throw new IllegalArgumentException("Slutdato kan ikke være efter start");
    	} else {
    		
    		
    		return dagligFast;
    	}
    	
        
    }
    
    /**
     * Opretter og returnerer en DagligSkæv ordination. Hvis startDato er efter
     * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke.
     * Hvis antallet af elementer i klokkeSlet og antalEnheder er forskellige kastes også en IllegalArgumentException.
     *
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     * @throws Exception 
     */
    public DagligSkaev opretDagligSkaevOrdination(LocalDate startDen,LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,LocalTime[] klokkeSlet, double[] antalEnheder) throws IllegalArgumentException {
        
    	if(!startDen.equals(null) && !slutDen.equals(null) && !patient.equals(null) && !laegemiddel.equals(null)) {


    		Period p = Period.between(startDen, slutDen);
    		int days = p.getDays() + 1;

    		if(days < 0) {
    			throw new IllegalArgumentException("Negativt antal dage");
    		}
    		DagligSkaev d = new DagligSkaev(startDen, slutDen, patient, laegemiddel, klokkeSlet, antalEnheder);
        	
            return d;
    	}
    	else {
    		throw new IllegalArgumentException("Du mangler noget information");
    	}
    	
    	
    	
    }
    
    /**
     * En dato for hvornår ordinationen anvendes tilføjes ordinationen. Hvis
     * datoen ikke er indenfor ordinationens gyldighedsperiode kastes en
     * IllegalArgumentException
     * Pre: ordination og dato er ikke null
     */
    public void ordinationPNAnvendt(PN ordination, LocalDate dato) throws IllegalArgumentException {
        if(!ordination.equals(null) && !dato.equals(null)) {
        	if(checkStartFoerSlut(dato, ordination.getSlutDen())) {
        		ordination.givDosis(dato);
        	}
        	else {
        		throw new IllegalArgumentException("Datoen er ikke inden for den ordinerede tid");
        	}
        	
        }
    }
    
    /**
     * Den anbefalede dosis for den pågældende patient (der skal tages hensyn
     * til patientens vægt). Det er en forskellig enheds faktor der skal
     * anvendes, og den er afhængig af patientens vægt.
     * Pre: patient og lægemiddel er ikke null
     */
    public double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
        double result;
        if (patient.getVaegt() < 25) {
            result = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnLet();
        }
        else if (patient.getVaegt() > 120) {
            result = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnTung();
        }
        else {
            result = patient.getVaegt()
                * laegemiddel.getEnhedPrKgPrDoegnNormal();
        }
        return result;
    }
    
    /**
     * For et givent vægtinterval og et givent lægemiddel, hentes antallet af
     * ordinationer.
     * Pre: laegemiddel er ikke null
     */
    public int antalOrdinationerPrVægtPrLægemiddel(double vægtStart,
        double vægtSlut, Laegemiddel laegemiddel) {
        
    	int ordinationer = 0;

    	for(Patient p : Controller.getService().getAllPatienter()) {
    		if((p.getVaegt() >= vægtStart && p.getVaegt() < vægtSlut) || (p.getVaegt() > vægtStart && p.getVaegt() <= vægtSlut)) {
    			
    			for(Ordination o : p.getOrdinationer()) {
    				if(o.getLaegemiddel().equals(laegemiddel)) {
    					ordinationer++;
    				}
    			}
    			
    		}
    	}
    	
    	
        return ordinationer;
    }
    
    public List<Patient> getAllPatienter() {
        return storage.getAllPatienter();
    }
    
    public List<Laegemiddel> getAllLaegemidler() {
        return storage.getAllLaegemidler();
    }
    
    /**
     * Metode der kan bruges til at checke at en startDato ligger før en
     * slutDato.
     *
     * @return true hvis startDato er før slutDato, false ellers.
     */
    private boolean checkStartFoerSlut(LocalDate startDato, LocalDate slutDato) {
        boolean result = true;
        if (slutDato.compareTo(startDato) < 0) {
            result = false;
        }
        return result;
    }
    
    public Patient opretPatient(String cpr, String navn, double vaegt) {
        Patient p = new Patient(cpr, navn, vaegt);
        storage.addPatient(p);
        return p;
    }
    
    public Laegemiddel opretLaegemiddel(String navn,
        double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
        double enhedPrKgPrDoegnTung, String enhed) {
        Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet,
            enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung, enhed);
        storage.addLaegemiddel(lm);
        return lm;
    }
    
    public void createSomeObjects() {
        opretPatient("121256-0512", "Jane Jensen", 63.4);
        opretPatient("070985-1153", "Finn Madsen", 83.2);
        opretPatient("050972-1233", "Hans Jørgensen", 89.4);
        opretPatient("011064-1522", "Ulla Nielsen", 59.9);
        opretPatient("090149-2529", "Ib Hansen", 87.7);
        opretPatient("020292-1275", "Fido Lassen", 25.0);
        opretPatient("111182-1231", "Dorit Svendsen", 121.0);
        opretPatient("123259-2211", "Kennet Najbjerg", -1.0);
        
        opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
        opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");
        
        opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 12),
            storage.getAllPatienter().get(0), storage.getAllLaegemidler().get(1), 123);
        
        opretPNOrdination(LocalDate.of(2015, 2, 12), LocalDate.of(2015, 2, 14),
            storage.getAllPatienter().get(0), storage.getAllLaegemidler().get(0), 3);
        
        opretPNOrdination(LocalDate.of(2015, 1, 20), LocalDate.of(2015, 1, 25),
            storage.getAllPatienter().get(3), storage.getAllLaegemidler().get(2), 5);
        
        opretPNOrdination(LocalDate.of(2015, 1, 1), LocalDate.of(2015, 1, 12),
            storage.getAllPatienter().get(0), storage.getAllLaegemidler().get(1), 123);
        
        opretDagligFastOrdination(LocalDate.of(2015, 1, 10),
            LocalDate.of(2015, 1, 12), storage.getAllPatienter().get(1),
            storage.getAllLaegemidler().get(1), 2, -1, 1, -1);
        
        opretDagligFastOrdination(LocalDate.of(2015, 1, 5), LocalDate.of(2015, 2, 5), 
        		storage.getAllPatienter().get(2), storage.getAllLaegemidler().get(3), 2, 3, 1, 1);
        
        LocalTime[] kl = { LocalTime.of(12, 0), LocalTime.of(12, 40),
            LocalTime.of(16, 0), LocalTime.of(18, 45) };
        double[] an = { 0.5, 1, 2.5, 3 };
        
        opretDagligSkaevOrdination(LocalDate.of(2015, 1, 23),
            LocalDate.of(2015, 1, 24), storage.getAllPatienter().get(1),
            storage.getAllLaegemidler().get(2), kl, an);
    }
    
    public Laegemiddel getLaegemiddel(String navn) {
    	return this.storage.getLaegemmiddel(navn);
    }
    
}
