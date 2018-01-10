import java.time.*;
class Ticket {
	LocalDateTime einfahrt;
	LocalDateTime ausfahrt;
	boolean bezahlt;
	long preis;
	public Ticket() {
		einfahrt = LocalDateTime.now();
	}
	public Ticket(LocalDateTime einfahrt, LocalDateTime ausfahrt, boolean bezahlt, long preis) {
		this.einfahrt = einfahrt;
		this.ausfahrt = ausfahrt;
		this.bezahlt = bezahlt;
		this.preis = preis;
	}
	Duration bestimmeParkzeit() {
		if (ausfahrt != null)
			return Duration.between(einfahrt, ausfahrt).abs();
		else
			return Duration.between(einfahrt, LocalDateTime.now()).abs();
	}
	
	@Override
	public boolean equals(Object o2) {
		if(o2 == null)
			return false;
		if (o2.getClass().equals(getClass())) {
			Ticket t2 = (Ticket) o2;
			return einfahrt.equals(t2.einfahrt) && (ausfahrt == t2.ausfahrt || ausfahrt.equals(t2.ausfahrt)) && bezahlt == t2.bezahlt && preis == t2.preis;
		} else {
			return false;
		}
	}
}
