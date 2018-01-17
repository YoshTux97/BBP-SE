import java.time.Duration;

public class pricePerSecond implements priceCalculator {
	private int centsPerSecond;

	public pricePerSecond(int cents) {
		this.centsPerSecond = cents;
	}
	
	public void setPricePerSecond(int cents) {
		if (cents >= 0)
			this.centsPerSecond = cents;
	}

	@Override
	public long getPrice(Ticket ticket) {
		Duration tmp = ticket.bestimmeParkzeit();
		long seconds = tmp.getSeconds();
		return seconds * centsPerSecond;
	}
}
