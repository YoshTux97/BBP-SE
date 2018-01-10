import static org.junit.Assert.*;

import java.time.LocalDateTime;

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
		assertEquals(300, pC1.getPrice(new Ticket(LocalDateTime.of(2000, 1, 1, 0, 0, 0), 
				LocalDateTime.of(2000, 1, 1, 0, 0, 0).plusHours(3).minusSeconds(10), false, -1)));
	}
	
	@Test
	public void getPrice_70Seconds_100() throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();
		Ticket t1 = new Ticket();
		Thread.sleep(1000);//1 Second
		assertEquals(50, pC2.getPrice(t1));
		t1.ausfahrt = now.plusSeconds(70);
		assertEquals(100, pC2.getPrice(t1));
	}
}
