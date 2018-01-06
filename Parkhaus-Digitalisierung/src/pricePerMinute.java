import java.time.Duration;

public class pricePerMinute implements priceCalculator {
	private int centsPerMinute;

	public pricePerMinute(int cents) {
		this.centsPerMinute = cents;
	}
	
	public void setPricePerHour(int cents) {
		if (cents >= 0)
			this.centsPerMinute = cents;
	}

	@Override
	public long getPrice(Ticket ticket) {
		Duration tmp = ticket.bestimmeParkzeit();
		long minutes = tmp.toMinutes();//Eventuell aufzurunden, da angefangene Minuten zaehlen
		long seconds = tmp.getSeconds() % 60;
		if (seconds > 0)
			minutes++;
		return minutes * centsPerMinute;
	}
}
