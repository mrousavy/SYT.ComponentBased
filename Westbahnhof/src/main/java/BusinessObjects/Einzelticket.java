package BusinessObjects;

import javax.persistence.Entity;

@Entity
public class Einzelticket extends Ticket {
	private TicketOption ticketOption;
}
