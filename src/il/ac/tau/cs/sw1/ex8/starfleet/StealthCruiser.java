package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private final int ENGINE_FACTOR = 50;
	private static int numOfStealthCruisers = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numOfStealthCruisers++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers) {
		super(name, commissionYear, maximalSpeed, crewMembers, List.of(new Weapon("Laser Cannons", 10, 100)));
		numOfStealthCruisers++;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + (ENGINE_FACTOR * numOfStealthCruisers);
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
