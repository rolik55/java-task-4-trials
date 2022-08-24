import beans.ExtraTrial;
import beans.LightTrial;
import beans.StrongTrial;
import beans.Trial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Trial[] array = new Trial[]{
                new Trial("Trial1", 35, 60),
                new Trial("Trial2", 53, 46),
                new Trial("Trial3", 27, 16),
                new LightTrial("LightTrial1", 84, 95),
                new LightTrial("LightTrial2", 76, 59),
                new StrongTrial("StrongTrial1", 83, 78),
                new StrongTrial("StrongTrial2", 64, 73),
                new ExtraTrial("ExtraTrial1", 53, 75, 69),
                new ExtraTrial("ExtraTrial2", 42, 36, 75)
        };
        List<Trial> trials = Arrays.asList(array);

        trials.stream().forEach(System.out::println);

        int passedCounter = (int) trials.stream().filter(Trial::isPassed).count();
        System.out.println(passedCounter);

        trials.sort(Comparator.comparingInt(Trial::getMarkSum));

        trials.stream().map(Trial::getMarkSum).forEach(System.out::println);

        List<Trial> failedTrials = trials.stream().filter(trial -> !trial.isPassed()).map(Trial::getCopy).peek(Trial::clearMarks).peek(System.out::println).toList();
        System.out.println("failedTrials collection - all failed: " + (trials.stream().filter(trial -> !trial.isPassed()).count() == failedTrials.size()));

        int[] sums = trials.stream().mapToInt(Trial::getMarkSum).toArray();
        System.out.println(Arrays.stream(sums).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
    }
}