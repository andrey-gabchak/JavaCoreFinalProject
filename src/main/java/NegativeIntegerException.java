public class NegativeIntegerException extends Exception {
    int value;

    public NegativeIntegerException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}