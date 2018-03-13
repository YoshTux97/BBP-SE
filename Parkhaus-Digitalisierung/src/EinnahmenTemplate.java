import java.util.stream.*;
public abstract class EinnahmenTemplate {
	public long getEinnahmen(Parkhaus p) {
		return berechnen(p.getTicketsStream());
	}
	public long getEinnahmen(ParkhausModell pm) {
		return berechnen(pm.getTicketsStream());
	}
	long berechnen(Stream<Ticket> ticketStream) {
		return ticketStream.filter(this::filtern)
				.mapToLong(this::preisBerechnen)
				.sum();
	}
	abstract long preisBerechnen(Ticket t);
	abstract boolean filtern(Ticket t);
}