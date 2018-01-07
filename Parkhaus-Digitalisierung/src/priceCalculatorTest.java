import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

public class priceCalculatorTest {
	priceCalculator pC1;
	priceCalculator pC2;

	@Before
	public void setUp() throws Exception {
		pC1 = new pricePerHour(100);
		pC2 = new pricePerMinute(50);
	}
	
	@Test
	public void getPrice_threeHours_500() {
		assertEquals(300, pC1.getPrice(new Ticket(Instant.ofEpochSecond(0), Instant.ofEpochSecond(60*60*3 - 10), false, -1)));
	}
	
	@Test
	public void getPrice_110Seconds_100() throws InterruptedException {
		Ticket t1 = new Ticket();
		Thread.sleep(10000);
		t1.ausfahrt = Instant.now().plusSeconds(60);
		assertEquals(100, pC2.getPrice(t1));
	}
}
