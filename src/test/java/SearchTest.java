import org.example.search.BinarySearchTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SearchTest {

    private static final int length = 5000000;
    private static final int[] array = new int[length];
    private static final BinarySearchTree tree = new BinarySearchTree();
    private static int toSearch;

    @BeforeAll
    public static void setUp() {
        int[] values = generateUniqueValues();

        //Заполнение дерева
        for (int i = 0; i < length; i++) {
            tree.insert(values[i]);
        }

        //Заполнение массива
        Arrays.sort(values);
        System.arraycopy(values, 0, array, 0, length);

        toSearch = values[new Random().nextInt(length)];
        System.out.println("Length of data: " + length);
        System.out.println("Value to search: " + toSearch);
    }


    @Test
    public void binarySearchTreeTest() {
        long startTime = System.nanoTime();
        assert tree.search(toSearch) : "Error";
        long endTime = System.nanoTime();
        System.out.println("Test: Binary Tree search: " + (endTime - startTime) + " nanoseconds");
    }

    @Test
    public void binarySearchTest() {
        long startTime = System.nanoTime();
        int result = Arrays.binarySearch(array, toSearch);
        long endTime = System.nanoTime();
        System.out.println("Test: Binary search: " + (endTime - startTime) + " nanoseconds. Find " + toSearch + " at position: " + result);
    }

    //Бинарный поиск требует массив уникальных отсортированных значений
    //BTree требует массив уникальных значений
    private static int[] generateUniqueValues() {
        int[] result = new int[SearchTest.length];
        Set<Integer> usedValues = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < SearchTest.length; i++) {
            int value;
            do {
                value = random.nextInt();
            } while (usedValues.contains(value));

            usedValues.add(value);
            result[i] = value;
        }

        return result;
    }
}
