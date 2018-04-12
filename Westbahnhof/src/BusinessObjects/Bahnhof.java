package BusinessObjects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bahnhof {
	@Id
	private Long ID;

	private String name;

	private int absPreisEntfernung;

	private int absKmEntfernung;

	private int absZeitEntfernung;

	private boolean kopfBahnhof;

}
