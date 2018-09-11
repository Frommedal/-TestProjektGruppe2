package ordination;

import java.time.LocalDate;

public class PN extends Ordination{
    private Laegemiddel laegmiddel;
    private double antal;

    
    public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antal) {
    	super(startDen, slutDen, patient);
    	
    	this.antal = antal;
    	this.laegmiddel = laegemiddel;
    	
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        return false;   
    }

    public double doegnDosis() {
        // TODO
        return 0.0;
    }


    public double samletDosis() {
        // TODO
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public double getAntal() {
        return antal;
    }
    
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
