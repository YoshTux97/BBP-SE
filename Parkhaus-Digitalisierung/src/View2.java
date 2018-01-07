import java.time.Instant;
import java.time.LocalDate;

public class View2 implements ViewManager {
	private ParkhausModell parkhausModell;
	private long wocheneinnahmen;
	
	public View2(ParkhausModell parkhausModell) {
		this.parkhausModell = parkhausModell;
		update();
	}
	
	@Override
	public void update() {
		wocheneinnahmen = parkhausModell.getTicketsStream()
				.filter(ticket -> ticket.bezahlt)
				.filter(ticket -> ticket.ausfahrt != null && Instant.from(getCurrentWochenanfang()).isBefore(ticket.ausfahrt))
				.mapToLong(ticket -> ticket.preis)
				.sum();
	}
	
	@Override
	public long getResult() {
		return wocheneinnahmen;
	}
	
	private LocalDate getCurrentWochenanfang() {
		LocalDate temp = LocalDate.now();
		int value = temp.getDayOfWeek().getValue();
		return temp.minusDays(value - 1);
	}

}