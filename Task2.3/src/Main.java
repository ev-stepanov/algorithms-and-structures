import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int bufferSize = scanner.nextInt();
            int n = scanner.nextInt();
            Deque<Integer> buffer = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                int arrival = scanner.nextInt();
                int duration = scanner.nextInt();

                while (!buffer.isEmpty() && arrival >= buffer.getFirst()) {
                    buffer.poll();
                }

                if (buffer.size() == bufferSize) {
                    System.out.println("-1");
                } else if (buffer.isEmpty()) {
                    buffer.addLast(arrival + duration);
                    System.out.println(arrival);
                } else {
                    System.out.println(buffer.getLast());
                    buffer.addLast(buffer.getLast() + duration);
                }
            }
        }
    }
}
