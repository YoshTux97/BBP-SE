import java.util.stream.*;
public abstract class EinnahmenTemplate {
	public long getEinnahmen(Parkhaus p) {
		return berechnen(p.getTicketsStream());
	}
	public long getEinnahmen(ParkhausModell pm) {
		return berechnen(pm.getTicketsStream());
	}
	long berechnen(Stream<Ticket> ticketStream) {
		return zeitFiltern(ticketStream.filter(ticket -> ticket.bezahlt))
				.mapToLong(ticket ->  ticket.preis)
				.sum();
	}
	abstract Stream<Ticket> zeitFiltern(Stream<Ticket> ticketStream);
}