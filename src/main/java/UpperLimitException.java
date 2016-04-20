public class UpperLimitException extends Exception {
    private int value;

    public UpperLimitException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}