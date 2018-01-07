import java.time.Instant;
import java.time.LocalDate;

public class View1 implements ViewManager {
	private ParkhausModell modell;
	private long Tageseinnahmen;
	
	public View1(ParkhausModell modell) {
		this.modell = modell;
		update();
	}

	@Override
	public void update() {
		Tageseinnahmen = modell.getTicketsStream()
				.filter(ticket -> ticket.bezahlt)
				.filter(ticket -> null != ticket.ausfahrt && Instant.from(LocalDate.now()).isBefore(ticket.ausfahrt))
				.mapToLong(ticket -> ticket.preis)
				.sum();
	}
	public long getResult() {
		return Tageseinnahmen;
	}
}
