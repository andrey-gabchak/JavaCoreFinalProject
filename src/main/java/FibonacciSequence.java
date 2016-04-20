import java.util.ArrayList;

public class FibonacciSequence {

    public void checkInteger(int enteredInteger) throws NegativeIntegerException {
        if (enteredInteger < 1) {
            throw new NegativeIntegerException(enteredInteger);
        }
    }

    public ArrayList<Integer> getFibSeq(int limit) {
        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(1);
        for (int i = 2; sequence.get(i - 1) + sequence.get(i - 2) < limit; i++) {
            sequence.add(i, sequence.get(i - 1) + sequence.get(i - 2));
        }
        return sequence;

    }
}
