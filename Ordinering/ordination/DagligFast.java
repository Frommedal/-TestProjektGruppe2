package ordination;

import java.time.*;

public class DagligFast extends Ordination {
	
	private double morgenAntal;
	private double middagAntal;
	private double aftenAntal;
	private double natAntal;
    
	public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
	        double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		super(startDen, slutDen, patient,laegemiddel);
		this.morgenAntal = morgenAntal;
		this.middagAntal = middagAntal;
		this.aftenAntal = aftenAntal;
		this.natAntal = natAntal;
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
		return 0;
	}

	@Override
	public double doegnDosis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
