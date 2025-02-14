package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in
	 * descending order by
	 * fire power, and then in descending order by commission year, and finally in
	 * ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
		return fleet.stream().sorted((x, y) -> {
			int res1 = Integer.compare(y.getFirePower(), x.getFirePower());
			int res2 = Integer.compare(y.getCommissionYear(), x.getCommissionYear());
			int res3 = x.getName().compareTo(y.getName());
			if (res1 != 0) {
				return res1;
			} else if (res2 != 0) {
				return res2;
			} else {
				return res3;
			}
		}).map(x -> x.toString()).toList();
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the
	 * number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, List<Spaceship>> helperMap = fleet.stream()
				.collect(Collectors.groupingBy(x -> x.getClass().getSimpleName()));
		Map<String, Integer> resMap = new HashMap<>();
		for (Map.Entry<String, List<Spaceship>> entry : helperMap.entrySet()) {
			resMap.put(entry.getKey(), entry.getValue().size());
		}
		return resMap;
	}

	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of
	 * maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
		return fleet.stream().mapToInt(x -> x.getAnnualMaintenanceCost()).sum();
	}

	/**
	 * Returns a set containing the names of all the fleet's weapons installed on
	 * any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> resSet = new TreeSet<>();
		for (Spaceship spaceship : fleet) {
			if (spaceship instanceof Fighter || spaceship instanceof Bomber) {
				for (Weapon weapon : ((myArmedShip) spaceship).getWeapon()) {
					resSet.add(weapon.getName());
				}
			}
		}
		return resSet;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given
	 * fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return fleet.stream().mapToInt(x -> x.getCrewMembers().size()).sum();
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's
	 * ships.
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalOfficers = fleet.stream()
				.mapToInt(x -> x.getCrewMembers().stream().filter(y -> y instanceof Officer).toList().size()).sum();
		return (fleet.stream()
				.mapToInt(x -> x.getCrewMembers().stream().filter(y -> y instanceof Officer).mapToInt(z -> z.getAge())
						.sum())
				.sum()) / totalOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to
	 * his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> resMap = new HashMap<>();
		for (Spaceship spaceship : fleet) {
			Officer highestRankingOfficer = null;
			for (CrewMember crewMember : spaceship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					highestRankingOfficer = (highestRankingOfficer == null
							|| ((Officer) crewMember).getRank().compareTo(highestRankingOfficer.getRank()) > 0)
									? (Officer) crewMember
									: highestRankingOfficer;
				}
			}
			if (highestRankingOfficer != null) {
				resMap.put(highestRankingOfficer, spaceship);
			}
		}
		return resMap;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of
	 * its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> instancesOfEachRank = new HashMap<>();
		for (Spaceship spaceship : fleet) {
			for (CrewMember crewMember : spaceship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					OfficerRank rank = ((Officer) crewMember).getRank();
					if (instancesOfEachRank.containsKey(rank)) {
						int count = instancesOfEachRank.get(rank);
						instancesOfEachRank.put(rank, count + 1);
					} else {
						instancesOfEachRank.put(rank, 1);
					}
				}
			}
		}
		return instancesOfEachRank.entrySet().stream().sorted((x, y) -> {
			int res1 = x.getValue().compareTo(y.getValue());
			int res2 = x.getKey().compareTo(y.getKey());
			if (res1 != 0) {
				return res1;
			} else {
				return res2;
			}
		}).toList();
	}
}
