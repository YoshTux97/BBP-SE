import java.time.Instant;

public class Bezahlautomat implements Bezahleinrichtung {
	private Parkhaus parkhaus;
	private priceCalculator pC;
	public Bezahlautomat(Parkhaus parkhaus, priceCalculator pC) {
		this.parkhaus = parkhaus;
		this.pC = pC;
	}

	@Override
	public boolean paying(int id) {
		Ticket ticket = parkhaus.getTicket(id);
		if (ticket == null) {
			System.out.println("Ungültige Ticket-ID.");
			return false;
		}
		if (parkhaus.pruefeTicket(id)) {
			System.out.println("Diese Ticket wurde bereits bezahlt.");
			return false;
		}
		ticket.ausfahrt = Instant.now();
		ticket.preis = pC.getPrice(ticket);
		System.out.printf("Zu bezahlen: " + ticket.preis/100 + ",%02d€%n", ticket.preis % 100);
		System.out.println(id + " hat bezahlt.");
		ticket.bezahlt = true;
		return true;
	}

	@Override
	public void setPriceCalculator(priceCalculator pC) {
		this.pC = pC;
	}

}
