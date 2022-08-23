package beans;

public class ExtraTrial extends Trial {
    private static final int REQUIRED_MARK_3 = 50;
    private int mark3;

    public ExtraTrial(String account, int mark1, int mark2, int mark3) {
        super(account, mark1, mark2);
        this.mark3 = mark3;
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() && mark3 >= REQUIRED_MARK_3;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + Integer.toString(mark3);
    }
}
