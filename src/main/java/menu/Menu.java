package menu;

import codedmessage.CodedDisk;
import codedmessage.CodedMessage;
import codedmessage.CodedText;
import codedmessage.TextType;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final int[][] array;

    public Menu(int[][] array) {
        this.array = array;
    }

    public void menu() {
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(TextType.OUTPUT.toString())).getFile();
        String menu = """
                  CENTRAL INTELLIGENCE AGENCY
                  ===========================
                  1. View the encrypted code.
                  2. View the encrypted message.
                  3. View the encrypted disc. 
                'q'. Quit
                    """;
        System.out.println(menu);
        String decision;
        do {
            decision = scanner.next();
            switch (decision) {
                case "1" -> {
                    CodedMessage.fillArray(array);
                    CodedMessage.writeFile(path, array);
                    System.out.println("The code has been sent. Check the target package.");
                }
                case "2" -> {
                    CodedText.printText();
                }
                case "3" -> {
                    try {
                        CodedDisk.printAnswers(CodedText.getActualType(), CodedMessage.getAnswers());
                    } catch (Exception e) {
                        System.out.println("CHYBA CIĘ POJJEBAŁO!!!!");
                    }
                }
            }
        } while (!decision.equalsIgnoreCase("q"));
    }

}
