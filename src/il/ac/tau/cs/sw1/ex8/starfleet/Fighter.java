package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myArmedShip {

	private final int BASIC_MAINTENANCE = 2500;
	private final int SPEED_FACTOR = 1000;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return BASIC_MAINTENANCE + this.getWeapon().stream().mapToInt(Weapon::getAnnualMaintenanceCost).sum()
				+ (int) Math.floor(SPEED_FACTOR * this.getMaximalSpeed());
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
