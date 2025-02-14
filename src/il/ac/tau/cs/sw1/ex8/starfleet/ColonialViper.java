package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

	private final int BASIC_MAINTENANCE = 4000;
	private final int CREW_MAINTENANCE = 500;
	private final int SPEED_FACTOR = 500;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return BASIC_MAINTENANCE + this.getWeapon().stream().mapToInt(Weapon::getAnnualMaintenanceCost).sum()
				+ (CREW_MAINTENANCE * this.getCrewMembers().size())
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
