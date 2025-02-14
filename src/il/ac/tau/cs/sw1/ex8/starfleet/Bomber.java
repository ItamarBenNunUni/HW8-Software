package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myArmedShip {

	private final int BASIC_MAINTENANCE = 5000;
	private final double WORKER_DISCOUNT = 0.1;
	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			List<Weapon> weapons, int numberOfTechnicians) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int) (BASIC_MAINTENANCE
				+ this.getWeapon().stream().mapToInt(Weapon::getAnnualMaintenanceCost).sum()
						* (1 - (WORKER_DISCOUNT * numberOfTechnicians)));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()).append("\n");
		sb.append("\tNumberOfTechnicians=").append(numberOfTechnicians);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
