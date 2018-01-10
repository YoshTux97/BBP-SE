
public class View3 implements View {
	int TicketID;
	private long aktPreis;
	private ParkhausModell modell;
	
	public View3(ParkhausModell modell, int TicketID) {
		this.modell = modell;
		this.TicketID = TicketID;
		update();
	}
	@Override
	public void update() {
		long before = aktPreis;
		Ticket meinTicket = modell.getTicket(TicketID);
		if (!meinTicket.bezahlt)
			aktPreis = modell.getPrice(meinTicket);
		else
			aktPreis = meinTicket.preis;
		if(before != aktPreis)
			System.out.println("Das Ticket mit der Nummer " + TicketID + " kostet nun " + aktPreis + ".");
	}
	public long getResult() {
		update();
		return aktPreis;
	}
}
