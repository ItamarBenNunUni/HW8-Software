package il.ac.tau.cs.sw1.ex8.riddles.second;

public class B2 extends A2 {

    private int num;

    public B2() {

    }

    public B2(int num) {
        this.num = num;
    }

    public A2 getA(int num) {
        return new B2(num);
    }

    @Override
    public String foo(String str) {
        return str.substring(0, str.length() / (num + 1));
    }
}
