package BusinessObjects;

import javax.persistence.*;
import java.util.List;

@Entity
public class Benutzer {
	@Id
    @GeneratedValue
	private Long ID;

	private String vorName;

	private String nachName;
	@Column(unique = true)
	private String eMail;

	private String passwort;

	private String smsNummer;

	private long verbuchtePraemienMeilen;

	@OneToMany
	private List<Ticket> tickets;

	@OneToMany
	private List<Reservierung> reservierungen;
}
