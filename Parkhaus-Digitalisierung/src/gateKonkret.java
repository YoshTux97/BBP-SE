
public class gateKonkret implements gate {
	private boolean offen;
	
	public gateKonkret() {
		offen = true;
	}
	@Override
	public void open() {
		if (offen) {
			System.out.println("Schranke wird geöffnet.");
			offen = false;
		} else {
			System.out.println("Schranke ist bereits offen.");
		}
	}
	@Override
	public void close() {
		if (offen) {
			System.out.println("Schranke ist bereits geschlossen.");
		} else {
			System.out.println("Schranke wird geschlossen.");
			offen = true;
		}
	}

	@Override
	public boolean isClosed() {
		return offen;
	}
}
