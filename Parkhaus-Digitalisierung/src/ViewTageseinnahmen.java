import java.time.*;

public class ViewTageseinnahmen implements ViewManager {
	private ParkhausModell modell;
	private long Tageseinnahmen;
	
	public ViewTageseinnahmen(ParkhausModell modell) {
		this.modell = modell;
		update();
	}

	@Override
	public void update() {
		long tmp = modell.getTicketsStream()
				.filter(ticket -> ticket.bezahlt)
				.filter(ticket -> null != ticket.ausfahrt && LocalDate.now().atStartOfDay().isBefore(ticket.ausfahrt))
				.mapToLong(ticket -> ticket.preis)
				.sum();
		if (tmp != Tageseinnahmen) {
			Tageseinnahmen = tmp;
			System.out.println("Tageseinnahmen: " + Tageseinnahmen);
		}
	}
	public long getResult() {
		return Tageseinnahmen;
	}
}
