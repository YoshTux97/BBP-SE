import static org.junit.Assert.*;

import java.util.*;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class SortPaidTicketsTest {
	SortStrategy s1;
	SortStrategy s2;
	SortStrategy s3;
	List<Ticket> payedTicketList;//Erhaltbar durch p.getPaidTickets, wobei Parkhaus p
	Ticket t1;
	Ticket t2;
	Ticket t3;
	Ticket t4;
	Ticket t5;
	Ticket t6;

	@Before
	public void setUp() throws Exception {
		s1 = new MergeSort(new Comparator<Ticket>() {//Nach preis
			public int compare(Ticket o1, Ticket o2) {
				return Long.compare(o1.preis, o2.preis);
			}
		});
		s2 = new QuickSort(new Comparator<Ticket>() {//Nach Parkdauer
			public int compare(Ticket o1, Ticket o2) {
				return o1.bestimmeParkzeit().compareTo(o2.bestimmeParkzeit());
			}
		});
		s3 = new BubbleSort(new Comparator<Ticket>() {//Nach Ausfahrt
			public int compare(Ticket o1, Ticket o2) {
				return o1.ausfahrt.compareTo(o2.ausfahrt);
			}
		});
		payedTicketList = new ArrayList<Ticket>();
		t1 = new Ticket(LocalDateTime.of(2000, 3, 20, 3, 49), LocalDateTime.of(2000, 3, 21, 3, 49), true, 6);//1 Tag
		t2 = new Ticket(LocalDateTime.of(2001, 2, 19, 4, 30), LocalDateTime.of(2001, 4, 1, 6, 0), true, 3);//1 Monat + 13 Tage
		t3 = new Ticket(LocalDateTime.of(2001, 6, 5, 3, 0), LocalDateTime.of(2001, 6, 5, 3, 49), true, 2);//1 Stunde
		t4 = new Ticket(LocalDateTime.of(2000, 8, 1, 16, 59), LocalDateTime.of(2000, 8, 17, 3, 49), true, 5);//18 Tage
		t5 = new Ticket(LocalDateTime.of(2000, 6, 19, 14, 37), LocalDateTime.of(2000, 6, 24, 13, 19), true, 1);//5 Tage
		t6 = new Ticket(LocalDateTime.of(2001, 9, 12, 14, 27), LocalDateTime.of(2001, 11, 21, 3, 49), true, 4);//2 Monate + 9 Tage
		payedTicketList.add(t1);
		payedTicketList.add(t2);
		payedTicketList.add(t3);
		payedTicketList.add(t4);
		payedTicketList.add(t5);
		payedTicketList.add(t6);
	}

	@Test
	public final void test() {
		Ticket[] result = payedTicketList.toArray(new Ticket[0]);
		s1.sort(result);
		Ticket[] expectedResult = {t5, t3, t2, t6, t4, t1};
		assertArrayEquals(expectedResult, result);
		result = payedTicketList.toArray(new Ticket[0]);
		s2.sort(result);
		expectedResult = new Ticket[]{t3, t1, t5, t4, t2, t6};
		assertArrayEquals(expectedResult, result);
		result = payedTicketList.toArray(new Ticket[0]);
		s3.sort(result);
		expectedResult = new Ticket[] {t1, t5, t4, t2, t3, t6};
		assertArrayEquals(expectedResult, result);
	}

}
