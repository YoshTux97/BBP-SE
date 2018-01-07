
public interface Bezahleinrichtung {
	public boolean paying(int id);
	void setPriceCalculator(priceCalculator pC);
}
