package ordination;

import java.time.*;
import java.time.temporal.ChronoUnit;
import ordination.Ordination;

public class DagligFast extends Ordination {
	
	private double morgenAntal;
	private double middagAntal;
	private double aftenAntal;
	private double natAntal;
	private Dosis[] doser = new Dosis[4];
    
	public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
	        double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		super(startDen, slutDen, patient,laegemiddel);
		
		doser[0] = new Dosis(LocalTime.of(8, 00), morgenAntal);
		doser[1] = new Dosis(LocalTime.of(12, 00), middagAntal);
		doser[2] = new Dosis(LocalTime.of(18, 00), aftenAntal);
		doser[3] = new Dosis(LocalTime.of(00, 00), natAntal);
	}

	public Dosis[] getDoser() {
		return doser;
	}

	public double getMorgenAntal() {
		return morgenAntal;
	}

	public void setMorgenAntal(double morgenAntal) {
		this.morgenAntal = morgenAntal;
	}

	public double getMiddagAntal() {
		return middagAntal;
	}

	public void setMiddagAntal(double middagAntal) {
		this.middagAntal = middagAntal;
	}

	public double getAftenAntal() {
		return aftenAntal;
	}

	public void setAftenAntal(double aftenAntal) {
		this.aftenAntal = aftenAntal;
	}

	public double getNatAntal() {
		return natAntal;
	}

	public void setNatAntal(double natAntal) {
		this.natAntal = natAntal;
	}

	@Override
	public double samletDosis() {
		double dagligdosis = getMorgenAntal() + getMiddagAntal() + getAftenAntal() + getNatAntal();
		int dage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen()) + 1;
		return dagligdosis * dage;
		
	}

	@Override
	public double doegnDosis() {
		return getMorgenAntal() + getMiddagAntal() + getAftenAntal() + getNatAntal();
	}

	@Override
	public String getType() {
		return "Daglig Fast";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
