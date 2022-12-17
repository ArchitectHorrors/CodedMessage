package codedmessage;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultBuilder {
    private static final Random random = new SecureRandom();
    private static final TextType[] types = TextType.values();
    private static final List<Pair<TextType, Pair<Integer, Integer>>> answers = new ArrayList<>();
    private static int actualIndex;

    private ResultBuilder(TextType actualType, Pair<Integer, Integer> actualInts) {
        makeAnswers(actualType, actualInts);
    }

    public static ResultBuilder of(TextType actualType, Pair<Integer, Integer> actualInts) {
        return new ResultBuilder(actualType, actualInts);
    }

    public List<Pair<TextType, Pair<Integer, Integer>>> getAnswers() {
        return answers;
    }

    private static void makeAnswers(TextType actualType, Pair<Integer, Integer> actualInts) {
        int index = random.nextInt(4) + 12;
        for (int i = 0; i < index; i++) {
            answers.add(Pair.of(types[random.nextInt(4) + 1], Pair.of(random.nextInt(100), random.nextInt(100))));
        }
        answers.removeIf(fake -> fake.key.equals(actualType) && fake.value.equals(actualInts));
        actualIndex = random.nextInt(index);
        answers.add(actualIndex, Pair.of(actualType, actualInts));
    }

    public int getActualIndex() {
        return actualIndex + 1;
    }
}
