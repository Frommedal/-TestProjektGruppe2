package ordination;

import java.time.*;

public class DagligFast extends Ordination {
	
	private LocalDate startDen;
	private LocalDate slutDen;
	private Patient patient;
	private Laegemiddel laegemiddel;
	private double morgenAntal;
	private double middagAntal;
	private double aftenAntal;
	private double natAntal;
    
	public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
	        double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		super(startDen, slutDen, patient);
		this.laegemiddel = laegemiddel;
		this.morgenAntal = morgenAntal;
		this.middagAntal = middagAntal;
		this.aftenAntal = aftenAntal;
		this.natAntal = natAntal;
	}

	public LocalDate getStartDen() {
		return startDen;
	}

	public void setStartDen(LocalDate startDen) {
		this.startDen = startDen;
	}

	public LocalDate getSlutDen() {
		return slutDen;
	}

	public void setSlutDen(LocalDate slutDen) {
		this.slutDen = slutDen;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Laegemiddel getLaegemiddel() {
		return laegemiddel;
	}

	public void setLaegemiddel(Laegemiddel laegemiddel) {
		this.laegemiddel = laegemiddel;
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
