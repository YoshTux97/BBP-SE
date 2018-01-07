import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class ParkhausModell {
	private Bezahleinrichtung pay;
	private gate gate;
	private gateControl gC;
	private Parkhaus parkhaus;
	private priceCalculator pC;
	private List<View> views;
	
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
	public ParkhausModell(List<View> views) {
		this();
		this.views = views;
	}
	public ParkhausModell(String parkhausName, int anzParkPlaetze, int pricePerMinuteInCents, List<View> views) {
		this(parkhausName, anzParkPlaetze, pricePerMinuteInCents);
		this.views = views;
	}
	
	public void setPriceCalculator(priceCalculator pC) {
		this.pC = pC;
		pay.setPriceCalculator(pC);
		updateViews();
	}
	public long getPrice(Ticket ticket) { return pC.getPrice(ticket); }
	//gateControl
	public boolean einfahrt() {
		boolean tmp = gC.entrance();
		updateViews();
		return tmp;
	}
	public boolean ausfahrt(int ticketID) {
		boolean tmp = gC.exit(ticketID);
		updateViews();
		return tmp;
	}
	public void notfall() {	gC.emergency();	}
	public boolean pay(int ticketID) {
		boolean tmp = pay.paying(ticketID);
		updateViews();
		return tmp;
	}
	//gate
	void openGate() { gate.open(); }
	void closeGate() { gate.close(); }
	boolean gateIsClosed() { return gate.isClosed(); }
	//Parkhaus
	public boolean parkhausHatPlatz() {	return parkhaus.hatPlatz();	}
	public String getName() { return parkhaus.getName(); }
	public int getCapacity() { return parkhaus.getAnzPlaetze();	}
	public boolean pruefeTicket(int ticketID) {	return parkhaus.pruefeTicket(ticketID);	}
	/**
	 * @param ticketID
	 * @return a copy of the corresponding Ticket or null
	 */
	public Ticket getTicket(int ticketID) { 
		Ticket tmp = parkhaus.getTicket(ticketID);
		return tmp == null ? null : new Ticket(tmp.einfahrt, tmp.ausfahrt, tmp.bezahlt, tmp.preis);
	}
	public void parkhausZustandSpeichern() throws IOException{ parkhaus.zustandSpeichern();	}
	public void parkhausZustandSpeichern(String fileName) throws IOException{ parkhaus.zustandSpeichern(fileName); }
	public void parkhausZustandEinlesen() throws IOException { parkhaus.zustandEinlesen(); }
	public void parkhausZustandEinlesen(String fileName) throws IOException { parkhaus.zustandEinlesen(fileName); }
	public void updateViews() {	views.forEach(view -> view.update()); }
	public Stream<Ticket> getTicketsStream() { return parkhaus.getTicketsStream(); }
}