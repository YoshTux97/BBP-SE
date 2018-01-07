
public class View3 implements View {
	int TicketID;
	public long aktPreis;
	private ParkhausModell modell;
	
	public View3(ParkhausModell modell, int TicketID) {
		this.modell = modell;
		this.TicketID = TicketID;
		update();
	}
	@Override
	public void update() {
		Ticket meinTicket = modell.getTicket(TicketID);
		aktPreis = modell.getPrice(meinTicket);
	}
	public long getResult() {
		update();
		return aktPreis;
	}
}
