package BusinessObjects;

import javax.persistence.Column;
import java.io.Serializable;

public class Preisstaffelung implements Serializable {
	private static long serialVersionUID = 10001L;

	private float grossGepaeck = 1.02f;

	private float fahrrad = 1.05f;

	private int zeitkarteWoche = 8;

	private int zeitkarteMonat = 25;

	private int zeitkarteJahr = 250;

	private static Preisstaffelung instance = new Preisstaffelung();
	public static Preisstaffelung getInstance() {
		return instance;
	}

	private Preisstaffelung() {

	}
}
