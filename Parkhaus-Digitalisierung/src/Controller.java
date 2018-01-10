
public class Controller {
	private ParkhausModell modell;
	
	public Controller(int...TicketIDs) {
		modell = new ParkhausModell("Controlled Parkhaus", 10, 5);
	}
	public int einfahrt() {
		return modell.einfahrt();
	}
	
	public boolean ausfahrt(int TicketID) {
		return modell.ausfahrt(TicketID);
	}
}
