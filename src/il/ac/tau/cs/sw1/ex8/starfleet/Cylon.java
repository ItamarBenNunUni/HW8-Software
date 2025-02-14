package il.ac.tau.cs.sw1.ex8.starfleet;

public class Cylon extends myAbstractCrewMember {

	private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}

	public int getModelNumber() {
		return modelNumber;
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
