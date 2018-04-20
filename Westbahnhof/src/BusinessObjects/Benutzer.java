package BusinessObjects;

import javax.persistence.Column;

public class Benutzer {

	private Long ID;

	private String vorName;

	private String nachName;
	@Column(unique = true)
	private String eMail;

	private String passwort;

	private String smsNummer;

	private Long verbuchtePraemienMeilen;

	private Ticket tickets;

	private Reservierung[] reservierungen;

}
