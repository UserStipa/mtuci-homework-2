import org.example.substring.KMPAlgorithm;
import org.junit.jupiter.api.Test;

public class SubStringSearchTest {

    private final String string = "FDSj4029 vmf890e-ujf902j mrj4ijf90 testjs0pjfhjeknl12k 8ud8l;ajdps 9*dhj";
    private final String search = "*";

    @Test
    public void kmpTest() {
        long startTime = System.nanoTime();
        KMPAlgorithm.search(string, search);
        long endTime = System.nanoTime();
        System.out.println("Test: KMP search sub string: " + (endTime - startTime) + " nanoseconds");
    }

    @Test
    public void builtInTest() {
        long startTime = System.nanoTime();
        string.indexOf(search);
        long endTime = System.nanoTime();
        System.out.println("Test: Java search sub string: " + (endTime - startTime) + " nanoseconds");
    }
}
