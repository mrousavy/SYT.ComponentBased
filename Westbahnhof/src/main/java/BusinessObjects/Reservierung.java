package BusinessObjects;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservierung {
    @Id
    @GeneratedValue
	private Long ID;

	private Date datum;

	private int praemienMeilenBonus = 15;

	private int preis = 150;

	private StatusInfo status;

	@OneToOne
	private Zug zug;

    @OneToOne
	private Strecke strecke;

    @OneToOne
	private Benutzer benutzer;

    @Transient
	private Zahlung zahlung;
}
