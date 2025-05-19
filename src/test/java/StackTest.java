import org.example.stack.CustomStack;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackTest {

    @Test
    public void testCustomStack() {
        try {
            File file = new File("src/main/resources/input.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("");

            CustomStack digitsStack = new CustomStack(10);
            CustomStack lettersStack = new CustomStack(10);
            CustomStack othersStack = new CustomStack(10);

            while (scanner.hasNext()) {
                char c = scanner.next().charAt(0);

                if (Character.isDigit(c)) {
                    digitsStack.push(c);
                } else if (Character.isLetter(c)) {
                    lettersStack.push(c);
                } else {
                    othersStack.push(c);
                }
            }
            scanner.close();

            System.out.println("Цифры:");
            printInOriginalOrder(digitsStack);

            System.out.println("\nБуквы:");
            printInOriginalOrder(lettersStack);

            System.out.println("\nОстальные символы:");
            printInOriginalOrder(othersStack);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    private static void printInOriginalOrder(CustomStack stack) {
        CustomStack tempStack = new CustomStack(stack.size());

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop());
        }
    }
}
