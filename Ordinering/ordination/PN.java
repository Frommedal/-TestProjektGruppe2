package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination{
    private double antal;
    private ArrayList<LocalDate> dosisGivetDag = new ArrayList<>();
    
    public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antal) {
    	super(startDen, slutDen, patient, laegemiddel);
    	this.antal = antal;
    	
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if(givesDen.isEqual(getStartDen()) || givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen()) || givesDen.isEqual(getSlutDen())) {
        	try {
        		dosisGivetDag.add(givesDen);
        		return true;
        	} catch(IllegalArgumentException e) {
        		e.printStackTrace();
        	}
        }
        return false;   
    }
    
    

    public int getAntalEnheder() {
		return dosisGivetDag.size();
	}

	public double doegnDosis() {
        return (dosisGivetDag.size() * antal) / (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
    }


    public double samletDosis() {
        
    	
        return dosisGivetDag.size() * antal;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return dosisGivetDag.size();
    }

    public double getAntal() {
        return antal;
    }
    
	@Override
	public String getType() {
		return "PN";
	}

}
