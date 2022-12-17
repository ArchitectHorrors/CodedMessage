package codedmessage;

import java.security.SecureRandom;
import java.util.Random;

public class CodedText {
    private static final Random random = new SecureRandom();
    private static int type = 1;

    private CodedText() {
    }

    public static void printText() {
        byte[] text = getRandomText();
        for (byte b : text) {
            char c = (char) b;
            if (c == ' ') {
                sleep(150);
            }
            System.out.printf("%c", c);
            sleep(50);
        }
        System.out.println();
    }

    private static byte[] getRandomText() {
        type = random.nextInt(4) + 1;
        return TextLoader.load(TextType.values()[type]);
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static TextType getActualType() {
        return TextType.values()[type];
    }
}
