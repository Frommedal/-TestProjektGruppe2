package ordination;

import java.time.*;
import java.time.temporal.ChronoUnit;
import ordination.Ordination;

public class DagligFast extends Ordination {
	
	private double morgenAntal;
	private double middagAntal;
	private double aftenAntal;
	private double natAntal;
	private double[] doser = new double[4];
    
	public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
	        double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		super(startDen, slutDen, patient,laegemiddel);
		this.doser[0] = morgenAntal;
		this.doser[1] = middagAntal;
		this.doser[2] = aftenAntal;
		this.doser[3] = natAntal;
	}

	public double[] getDoser() {
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
	
	
}
