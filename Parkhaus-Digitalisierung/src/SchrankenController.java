
public class SchrankenController implements gateControl {
	private gate schranke;
	private Parkhaus parkhaus;
	public SchrankenController(gate Schranke, Parkhaus parkhaus) {
		this.schranke = Schranke;
		this.parkhaus = parkhaus;
	}

	@Override
	public int entrance() {
		if (parkhaus.hatPlatz()) {
			int tmp = parkhaus.ticketAusstellen();
			System.out.println("Ihr Ticket hat die Nummer: " + tmp);
			schranke.open();
			System.out.println("Auto fährt herein.");
			schranke.close();
			return tmp;
		} else {
			System.out.println("Das Parkhaus ist voll.");
			return -1;
		}
	}

	@Override
	public boolean exit(int TicketID) {
		if (parkhaus.pruefeTicket(TicketID)) {
			schranke.open();
			System.out.println("Auto "+ TicketID + " fährt heraus.");
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
