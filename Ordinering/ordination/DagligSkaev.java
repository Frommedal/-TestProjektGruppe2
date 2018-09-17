package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private ArrayList<Dosis> doser;
    private LocalTime[] klokkeSlet;
    private double[] antalEnheder;
    
	
	public DagligSkaev(LocalDate startDen,LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,LocalTime[] klokkeSlet, double[] antalEnheder) {
		super(startDen, slutDen,patient,laegemiddel);
		this.klokkeSlet = klokkeSlet;
		this.antalEnheder = antalEnheder;
	}
	
	public LocalTime[] getKlokkeSlet() {
		return klokkeSlet;
	}
	
	public double[] getAntalEnheder() {
		return antalEnheder;
	}
	
	

	public void opretDosis(LocalTime tid, double antal) {
        Dosis d = new Dosis(tid,antal);
        doser.add(d);
        
    }

	
	public ArrayList<Dosis> getDoser() {
		return doser;
	}

	@Override
	public double samletDosis() {
		
		int samlet = 0;
		for (Dosis d : doser) {
			samlet += d.getAntal();
		}
		
		return samlet;
	}

	@Override
	public double doegnDosis() {
		
		int samlet = 0;
		for (Dosis d : doser) {
			samlet += d.getAntal();
		}
		
		return samlet / (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen() ) + 1;	
	}

	@Override
	public String getType() {
		return "Daglig Skæv";
	}

	@Override
	public boolean equals(Object obj) {
		DagligSkaev ds = (DagligSkaev) obj;
		
		if(ds.getStartDen().equals(this.getStartDen()) && ds.getSlutDen().equals(this.getSlutDen()) && ds.getPatient().equals(this.getPatient()) && this.getLaegemiddel().equals(this.getLaegemiddel())) {
			if(ds.getKlokkeSlet().equals(this.getKlokkeSlet())) {
					if (ds.getAntalEnheder().equals(this.getAntalEnheder())) {
							return true;
					}
				
			}
				
			}
		return false;
		}
}

