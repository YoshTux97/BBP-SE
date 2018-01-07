
public class ParkhausModell {
	private Bezahleinrichtung pay;
	private gate gate;
	private gateControl gC;
	private Parkhaus parkhaus;
	private priceCalculator pC;
	
	public ParkhausModell(String parkhausName, int anzParkPlaetze, int pricePerMinuteInCents) {
		parkhaus = new Parkhaus(parkhausName, anzParkPlaetze);
		gate = new gateKonkret();
		gC = new SchrankenController(gate, parkhaus);
		pC = new pricePerMinute(pricePerMinuteInCents);
		pay = new Bezahlautomat(parkhaus, pC);
	}
	
	public setPriceCalculator(priceCalculator pC) {
		this.pC = pC;
		gC.
	}
}
