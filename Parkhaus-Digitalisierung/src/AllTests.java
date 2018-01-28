import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BezahleinrichtungTest.class, FahrzeugtypTest.class, gateControlTest.class, gateTest.class,
		ParkhausPersistierungTest.class, ParkhausTest.class, priceCalculatorTest.class, SortPaidTicketsTest.class,
		ViewTest.class })

public class AllTests {

}
