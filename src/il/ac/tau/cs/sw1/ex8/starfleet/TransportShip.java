package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship {

	private final int BASIC_MAINTENANCE = 3000;
	private final int CARGO_FACTOR = 5;
	private final int PASSENGER_FACTOR = 3;
	private int cargoCapacity;
	private int passengerCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers,
			int cargoCapacity, int passengerCapacity) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return BASIC_MAINTENANCE + (CARGO_FACTOR * cargoCapacity) + (PASSENGER_FACTOR * passengerCapacity);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()).append("\n");
		sb.append("\tCargoCapacity=").append(cargoCapacity).append("\n");
		sb.append("\tPassengerCapacity=").append(passengerCapacity);
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
