import java.time.Duration;
public class pricePerHour implements priceCalculator {
	private int centsPerHour;

	public pricePerHour(int cents) {
		this.centsPerHour = cents;
	}
	
	@Override
	public long getPrice(Ticket ticket) {
		Duration tmp = ticket.bestimmeParkzeit();
		long hours = tmp.toHours();//Eventuell aufzurunden, da angefangene Stunden zaehlen
		long minutes = tmp.toMinutes() % 60;
		if (minutes > 0)
			hours++;
		return hours * centsPerHour;
	}

	public void setPricePerHour(int cents) {
		if (cents >= 0)
			this.centsPerHour = cents;
	}

}
