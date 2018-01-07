import java.io.IOException;

public class ParkhausModell {
	private Bezahleinrichtung pay;
	private gate gate;
	private gateControl gC;
	private Parkhaus parkhaus;
	private priceCalculator pC;
	
	public ParkhausModell() {
		this("Parkhaus", 100, 5);
	}
	public ParkhausModell(String parkhausName, int anzParkPlaetze, int pricePerMinuteInCents) {
		parkhaus = new Parkhaus(parkhausName, anzParkPlaetze);
		gate = new gateKonkret();
		gC = new SchrankenController(gate, parkhaus);
		pC = new pricePerMinute(pricePerMinuteInCents);
		pay = new Bezahlautomat(parkhaus, pC);
	}
	
	public void setPriceCalculator(priceCalculator pC) {
		this.pC = pC;
		pay.setPriceCalculator(pC);
	}
	//gateControl
	public boolean einfahrt() {
		return gC.entrance();
	}
	public boolean ausfahrt(int ticketID) {
		return gC.exit(ticketID);
	}
	public void notfall() {
		gC.emergency();
	}
	public boolean pay(int ticketID) {
		return pay.paying(ticketID);
	}
	//gate
	void openGate() {
		gate.open();
	}
	void closeGate() {
		gate.close();
	}
	boolean gateIsClosed() {
		return gate.isClosed();
	}
	public long getPrice(Ticket ticket) {
		return pC.getPrice(ticket);
	}
	//Parkhaus
	public boolean parkhausHatPlatz() {
		return parkhaus.hatPlatz();
	}
	public String getName() { return parkhaus.getName(); }
	public int getCapacity() { return parkhaus.getAnzPlaetze(); }
	public boolean pruefeTicket(int ticketID) { return parkhaus.pruefeTicket(ticketID); }
	public Ticket getTicket(int ticketID) { 
		Ticket tmp = parkhaus.getTicket(ticketID);
		return tmp == null ? null : new Ticket(tmp.einfahrt, tmp.ausfahrt, tmp.bezahlt, tmp.preis);
	}
	public void parkhausZustandSpeichern() throws IOException{
		parkhaus.zustandSpeichern();
	}
	public void parkhausZustandSpeichern(String fileName) throws IOException{
		parkhaus.zustandSpeichern(fileName);
	}
	public void parkhausZustandEinlesen() throws IOException {
		parkhaus.zustandEinlesen();
	}
	public void parkhausZustandEinlesen(String fileName) throws IOException {
		parkhaus.zustandEinlesen(fileName);
	}
}
