package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligSkaev extends Ordination {
    // TODO

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
        // TODO
    }

	@Override
	public double samletDosis() {
		// TODO Auto-generated method stub
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
