package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private ArrayList<Dosis> doser;
    
	
	public DagligSkaev(LocalDate startDen,LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,LocalTime[] klokkeSlet, double[] antalEnheder) {
		super(startDen, slutDen,patient,laegemiddel);
		
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
		// TODO Auto-generated method stub
		return false;
	}

	
}
