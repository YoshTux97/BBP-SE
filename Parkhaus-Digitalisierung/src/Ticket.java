import java.time.*;
class Ticket {
	Instant einfahrt;
	Instant ausfahrt;
	boolean bezahlt;
	long preis;
	public Ticket() {
		einfahrt = Instant.now();
	}
	public Ticket(Instant einfahrt, Instant ausfahrt, boolean bezahlt) {
		this.einfahrt = einfahrt;
		this.ausfahrt = ausfahrt;
		this.bezahlt = bezahlt;
	}
	Duration bestimmeParkzeit() {
		if (ausfahrt != null)
			return Duration.between(einfahrt, ausfahrt).abs();
		else
			return Duration.between(einfahrt, Instant.now()).abs();
	}
}
