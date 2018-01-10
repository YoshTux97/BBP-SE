import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BezahleinrichtungTest.class, gateControlTest.class, gateTest.class, ParkhausPersistierungTest.class,
		ParkhausTest.class, priceCalculatorTest.class, ViewTest.class })
public class AllTests {

}
