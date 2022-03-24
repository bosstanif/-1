package model;

public class FixDate {

	String FixStrat;
	String FixEnd;
	
	@Override
	public String toString() {
		return "FixDate [FixStrat=" + FixStrat + ", FixEnd=" + FixEnd + "]";
	}

	public FixDate(String fixStrat, String fixEnd) {
		super();
		FixStrat = fixStrat;
		FixEnd = fixEnd;
	}

	public String getFixStrat() {
		return FixStrat;
	}

	public void setFixStrat(String fixStrat) {
		FixStrat = fixStrat;
	}

	public String getFixEnd() {
		return FixEnd;
	}

	public void setFixEnd(String fixEnd) {
		FixEnd = fixEnd;
	}
	
}
