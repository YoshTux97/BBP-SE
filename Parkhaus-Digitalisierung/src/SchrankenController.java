
public class SchrankenController implements gateControl {
	private gate schranke;
	private Parkhaus parkhaus;
	public SchrankenController(gate Schranke, Parkhaus parkhaus) {
		this.schranke = Schranke;
		this.parkhaus = parkhaus;
	}

	@Override
	public boolean entrance() {
		if (parkhaus.hatPlatz()) {
			System.out.println("Ihr Ticket hat die Nummer: " + parkhaus.ticketAusstellen());
			schranke.open();
			System.out.println("Auto fährt herein.");
			schranke.close();
			return true;
		} else {
			System.out.println("Das Parkhaus ist voll.");
			return false;
		}
	}

	@Override
	public boolean exit(int TicketID) {
		if (parkhaus.pruefeTicket(TicketID)) {
			schranke.open();
			System.out.println("Auto "+ TicketID + "fährt heraus.");
			schranke.close();
			parkhaus.freeSpot();
			return true;
		} else {
			System.out.println("Sie haben nicht bezahlt.");
			return false;
		}
	}

	@Override
	public void emergency() {
		schranke.open();
		System.out.println("Auto fährt herein.");
		schranke.close();
	}
}
