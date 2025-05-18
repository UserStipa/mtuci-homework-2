import org.example.search.HashTable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HashSearchTest {

    private static final int elementsCount = 15000000;
    private static final int searches = 1500000;

    @Test
    public void simple() {
        HashTable myTable = new HashTable(elementsCount * 2);
        long start = System.nanoTime();
        for (int i = 0; i < elementsCount; i++) {
            myTable.put(i, "Value" + i);
        }
        long myPutTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < searches; i++) {
            myTable.get(i % elementsCount);
        }
        long mySearchTime = System.nanoTime() - start;

        System.out.printf("Простое рехэширование - добавление: %d мс\n", TimeUnit.NANOSECONDS.toMillis(myPutTime));
        System.out.printf("Простое рехэширование - поиск: %d мс\n", TimeUnit.NANOSECONDS.toMillis(mySearchTime));
    }

    @Test
    public void builtIn() {
        HashMap<Integer, String> javaMap = new HashMap<>(elementsCount * 2);
        long start = System.nanoTime();
        for (int i = 0; i < elementsCount; i++) {
            javaMap.put(i, "Value" + i);
        }
        long javaPutTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < searches; i++) {
            javaMap.get(i % elementsCount);
        }
        long javaSearchTime = System.nanoTime() - start;

        System.out.printf("HashMap - добавление: %d мс\n", TimeUnit.NANOSECONDS.toMillis(javaPutTime));
        System.out.printf("HashMap - поиск: %d мс\n", TimeUnit.NANOSECONDS.toMillis(javaSearchTime));
    }
}
