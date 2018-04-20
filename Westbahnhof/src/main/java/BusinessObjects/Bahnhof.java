package BusinessObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bahnhof {
	@Id
	@GeneratedValue
	private long ID;

	@Column(unique = true)
	private String name;

	private int absPreisEntfernung;

	private int absKmEntfernung;

	private int absZeitEntfernung;

	private boolean kopfBahnhof;
}
