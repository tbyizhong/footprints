package footprints.disruptor;

public class DisruptorTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println((i+1) +":" + (i>>>6));
        }
    }
}