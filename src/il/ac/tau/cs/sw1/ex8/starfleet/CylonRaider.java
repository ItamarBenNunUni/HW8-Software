package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	private final int BASIC_MAINTENANCE = 3500;
	private final int CYLON_MAINTENANCE = 500;
	private final int SPEED_FACTOR = 1200;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return BASIC_MAINTENANCE + this.getWeapon().stream().mapToInt(Weapon::getAnnualMaintenanceCost).sum()
				+ (CYLON_MAINTENANCE * this.getCrewMembers().size())
				+ (int) Math
						.floor(SPEED_FACTOR * this.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return super.toString();
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
