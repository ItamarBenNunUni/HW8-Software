package il.ac.tau.cs.sw1.ex8.starfleet;

public abstract class myAbstractCrewMember implements CrewMember {

    private String name;
    private int age;
    private int yearsInService;

    public myAbstractCrewMember(int age, int yearsInService, String name) {
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearsInService() {
        return yearsInService;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return name.equals(((myAbstractCrewMember) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
