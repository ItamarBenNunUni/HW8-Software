package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myArmedShip extends myAbstractSpaceship {

    private List<Weapon> weapons;

    public myArmedShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers,
            List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
        this.updateFirePower(weapons.stream().mapToInt(x -> x.getFirePower()).sum());
    }

    public List<Weapon> getWeapon() {
        return weapons;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString()).append("\n");
        sb.append("\tWeaponArray=").append(weapons);
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
