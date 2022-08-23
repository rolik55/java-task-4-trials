package beans;

public class LightTrial extends Trial {
    private static final int REQUIRED_MARK_1 = 30;
    private static final int REQUIRED_MARK_2 = 40;

    public LightTrial(String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= REQUIRED_MARK_1 && getMark2() >= REQUIRED_MARK_2;
    }
}
