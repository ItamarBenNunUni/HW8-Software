package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship {

    private String name;
    private int commissionYear;
    private float maximalSpeed;
    private int firePower;
    private Set<? extends CrewMember> crewMembers;

    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed,
            Set<? extends CrewMember> crewMembers) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.firePower = 10;
        this.crewMembers = crewMembers;
    }

    public void updateFirePower(int update) {
        firePower += update;
    }

    public String getName() {
        return name;
    }

    public int getCommissionYear() {
        return commissionYear;
    }

    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    public int getFirePower() {
        return firePower;
    }

    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public abstract int getAnnualMaintenanceCost();

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getSimpleName()).append("\n");
        sb.append("\tname=").append(name).append("\n");
        sb.append("\tCommissionYear=").append(commissionYear).append("\n");
        sb.append("\tMaximalSpeed=").append(maximalSpeed).append("\n");
        sb.append("\tFirePower=").append(firePower).append("\n");
        sb.append("\tCrewMembers=").append(crewMembers.size()).append("\n");
        sb.append("\tAnnualMaintenanceCost=").append(getAnnualMaintenanceCost());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return name.equals(((myAbstractSpaceship) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
