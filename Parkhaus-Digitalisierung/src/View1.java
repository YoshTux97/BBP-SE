
public class View1 implements ViewManager {
	private Controller cont;
	private ParkhausModell modell;
	
	public View1(Controller cont, ParkhausModell modell) {
		this.cont = cont;
		this.modell = modell;
	}

	@Override
	public void update() {
		System.out.println(modell.getTicketsStream()
				.filter(ticket -> ticket.bezahlt));
	}
}
