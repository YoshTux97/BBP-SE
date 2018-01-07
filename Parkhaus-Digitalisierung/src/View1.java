import java.time.Instant;
import java.time.LocalDate;

public class View1 implements ViewManager {
	private Controller cont;
	private ParkhausModell modell;
	public long Tageseinnahmen;
	
	public View1(Controller cont, ParkhausModell modell) {
		this.cont = cont;
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
}
