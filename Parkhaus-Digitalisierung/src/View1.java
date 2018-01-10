import java.time.*;

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
				.filter(ticket -> null != ticket.ausfahrt && LocalDate.now().atStartOfDay().isBefore(ticket.ausfahrt))
				.mapToLong(ticket -> ticket.preis)
				.sum();
		System.out.println("Tageseinnahmen: " + Tageseinnahmen);
	}
	public long getResult() {
		return Tageseinnahmen;
	}
}
