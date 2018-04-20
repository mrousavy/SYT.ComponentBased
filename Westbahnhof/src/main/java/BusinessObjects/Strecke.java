package BusinessObjects;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"start_id", "ende_id"})
)
public class Strecke {
	@Id
	@GeneratedValue
	private Long ID;
	@ManyToOne
	private Bahnhof start;
	@ManyToOne
	private Bahnhof ende;
}
