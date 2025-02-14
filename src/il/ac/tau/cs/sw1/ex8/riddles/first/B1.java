package il.ac.tau.cs.sw1.ex8.riddles.first;

public class B1 extends A1 {
    @Override
    public String foo() {
        C1 c = new C1();
        String strFromC = c.foo();
        return strFromC.substring(0, strFromC.length() - 1);
    }
}