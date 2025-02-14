package il.ac.tau.cs.sw1.ex8.riddles.fourth;

import java.util.Iterator;

public class B4 implements Iterator<String> {

    private String[] strings;
    private String[] newString;
    private int currInd;

    public B4(String[] strings, Integer k) {
        this.strings = strings;
        this.currInd = 0;
        newString = new String[this.strings.length * (k - 1) + (k - 1)];
        for (int i = 0; i < newString.length; i++) {
            newString[i] = strings[i % strings.length];
        }
    }

    @Override
    public boolean hasNext() {
        return currInd < newString.length;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return newString[currInd++];
    }
}
