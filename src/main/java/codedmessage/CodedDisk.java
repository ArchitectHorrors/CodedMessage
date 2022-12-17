package codedmessage;

import java.util.List;
import java.util.Scanner;

public class CodedDisk {
    private static final Scanner scanner = new Scanner(System.in);

    private CodedDisk() {
    }

    public static void printAnswers(TextType actualType, Pair<Integer, Integer> actualInts) {
        ResultBuilder resultBuilder = ResultBuilder.of(actualType, actualInts);

        final List<Pair<TextType, Pair<Integer, Integer>>> answers = resultBuilder.getAnswers();
        for (int i = 0, answersSize = answers.size(); i < answersSize; i++) {
            Pair<TextType, Pair<Integer, Integer>> answer = answers.get(i);
            System.out.printf("%2d. %8s - [%-3d | %3d]%n", (i + 1), answer.key.toString().substring(6, answer.key.toString().length() - 4).toUpperCase(), answer.value.key, answer.value.value);
        }

        final String sunMenu = "Choose answer:";

        int answer = resultBuilder.getActualIndex();
        System.out.println(sunMenu);
        int decision = 0;
        do {
            try {
                decision = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("WRONG KEY!");
            }

            if (decision != answer) {
                System.out.println("WRONG ANSWER!");
            }
        } while (decision != answer);
        System.out.println("* * * ACCESS GRANTED * * *");
        System.exit(0);
    }
}
