import org.example.sorts.QuickSort;
import org.example.sorts.ShellSort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortsTest {

    private static final int length = 1000000;
    private static final int[] array = new int[length];

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt();
        }
        System.out.println("Length of array: " + array.length);
    }


    @Test
    public void shellSort() {
        int[] arr = array.clone();
        long startTime = System.currentTimeMillis();
        ShellSort.run(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Test: Shell sort: " + (endTime - startTime) + " milliseconds");
    }

    @Test
    public void quickSort() {
        int[] arr = array.clone();
        long startTime = System.currentTimeMillis();
        QuickSort.run(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Test: Quick sort: " + (endTime - startTime) + " milliseconds");
    }

    @Test
    public void javaSort() {
        int[] arr = array.clone();
        long startTime = System.currentTimeMillis();
        Arrays.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Test: Arrays sort (Java): " + (endTime - startTime) + " milliseconds");
    }
}
