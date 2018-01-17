import java.time.LocalDate;

public class ViewWocheneinnahmen implements ViewManager {
	private ParkhausModell parkhausModell;
	private long wocheneinnahmen;
	
	public ViewWocheneinnahmen(ParkhausModell parkhausModell) {
		this.parkhausModell = parkhausModell;
		update();
	}
	
	@Override
	public void update() {
		long tmp = parkhausModell.getTicketsStream()
				.filter(ticket -> ticket.bezahlt)
				.filter(ticket -> ticket.ausfahrt != null && getCurrentWochenanfang().atStartOfDay().minusNanos(1).isBefore(ticket.ausfahrt))
				.mapToLong(ticket -> ticket.preis)
				.sum();
		if (tmp != wocheneinnahmen) {
			wocheneinnahmen = tmp;
			System.out.println("Wocheneinnahmen: " + wocheneinnahmen);
		}
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