package codedmessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class CodedMessage {
    private static final Random random = new SecureRandom();
    static Pair<Integer, Integer> questionMarks;

    private CodedMessage() {}

    public static void createAndPrintFile(String path, int[][] array) {
        fillArray(array);
        writeFile(path, array);
        printFile();
    }

    public static void fillArray(int[][] array) {
        makeIt(array, 0, array[0].length - 1);
        makeIt(array, 1, array[0].length);
    }

    public static void writeFile(String path, int[][] array) {
        final File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 0, tabLength = array.length; i < tabLength; i++) {
                int[] ints = array[i];
                int questionMark = random.nextInt(4) + 4;
                if (i == 1) {
                    for (int j = 0, intsLength = ints.length; j < intsLength; j++) {
                        if (j == questionMark || j == questionMark + 1) {
                            questionMarks = Pair.of(ints[j - 1], ints[j]);
                            writer.write(String.format("|%3c ", '?'));
                        } else {
                            writer.write(String.format("|%3d ", ints[j]));
                        }
                    }
                } else {
                    for (int anInt : ints) {
                        writer.write(String.format("|%3c ", randomChar()));
                    }
                }
                writer.write("|\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile() {
        byte[] text = TextLoader.load(TextType.OUTPUT);
        for (byte b : text) {
            System.out.print((char) b);
        }
    }

    private static void makeIt(int[][] array, int startIndex, int endIndex) {
        int additionFactor = random.nextInt(5) + 2;
        int startingNumber = random.nextInt(91) - additionFactor;

        for (int j = startIndex; j < endIndex; j += 2) {
            startingNumber += additionFactor;
            array[1][j] = startingNumber;
        }
    }

    private static char randomChar() {
        int c = random.nextInt(256);
        if (!isViewableCharacter(c)) {
            return ' ';
        } else {
            return (char) c;
        }
    }

    private static boolean isViewableCharacter(int c) {
        if (c == 127 || (c > 128 && c < 161) || c == 173) {
            return false;
        }
        return c > 32;
    }

    public static Pair<Integer, Integer> getAnswers() {
        return questionMarks;
    }
}
