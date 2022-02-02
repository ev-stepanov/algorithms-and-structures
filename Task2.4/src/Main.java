import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Deque<Integer> deque = new ArrayDeque<>();
            Deque<Integer> dequeWithMax = new ArrayDeque<>();

            int n = Integer.parseInt(scanner.nextLine());

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String row = scanner.nextLine();
                if (row.startsWith("push")) {
                    int e = Integer.parseInt(row.split(" ")[1]);
                    deque.push(e);
                    dequeWithMax.push(Math.max(dequeWithMax.isEmpty() ? 0 : dequeWithMax.getFirst(), e));
                } else if (row.startsWith("pop")) {
                    deque.removeFirst();
                    dequeWithMax.removeFirst();
                } else {
                    builder.append(dequeWithMax.getFirst()).append(" ");
                }
            }
            System.out.println(builder.toString());
        }
    }
}
