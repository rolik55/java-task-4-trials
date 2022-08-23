import beans.ExtraTrial;
import beans.LightTrial;
import beans.StrongTrial;
import beans.Trial;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = new ArrayList<>(List.of(
                new Trial("Trial1", 35, 60),
                new Trial("Trial2", 53, 46),
                new Trial("Trial3", 27, 16),
                new LightTrial("LightTrial1", 84, 95),
                new LightTrial("LightTrial2", 76, 59),
                new StrongTrial("StrongTrial1", 83, 78),
                new StrongTrial("StrongTrial2", 64, 73),
                new ExtraTrial("ExtraTrial1", 53, 75, 69),
                new ExtraTrial("ExtraTrial2", 42, 36, 75)));
        List<Trial> failedTrials = new ArrayList<>();

        for (Trial trial : trials) {
            System.out.println(trial);
        }

        int passedCounter = 0;
        for (Trial trial : trials) {
            if (trial.isPassed()) {
                passedCounter++;
            } else {
                failedTrials.add(trial);
            }
        }
        System.out.println(passedCounter);

        trials.sort((o1, o2) -> (o1.getMark1() + o1.getMark2()) - (o2.getMark1() + o2.getMark2()));

        for (Trial trial : trials) {
            System.out.println(trial.getMark1() + trial.getMark2());
        }

        for (Trial trial : failedTrials) {
            trial.clearMarks();
            System.out.println(trial);
        }
        System.out.println("All trials failed: " + allTrialsFailed(trials));

        int[] sums = new int[trials.size()];
        int i = 0;
        for(Trial trial : trials) {
            sums[i] = trial.getMark1() + trial.getMark2();
            i++;
        }
        System.out.println(Arrays.toString(sums));
    }

    private static boolean allTrialsFailed(List<Trial> trials) {
        int failedCounter = 0;
        for (Trial trial : trials) {
            if (!trial.isPassed()) {
                failedCounter++;
            }
        }
        return failedCounter == trials.size();
    }
}