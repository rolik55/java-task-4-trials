package beans;

public class Trial {
    protected static final int REQUIRED_MARK_TO_PASS = 50;
    private final String account;
    private int mark1;
    private int mark2;

    public Trial(String account, int mark1, int mark2) {
        this.account = account;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    @Override
    public String toString() {
        return account + ";" + Integer.toString(mark1) + ";" + Integer.toString(mark2);
    }

    public boolean isPassed() {
        return mark1 + mark2 >= REQUIRED_MARK_TO_PASS;
    }

    public String getAccount() {
        return account;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void clearMarks() {
        mark1 = 0;
        mark2 = 0;
    }
}
