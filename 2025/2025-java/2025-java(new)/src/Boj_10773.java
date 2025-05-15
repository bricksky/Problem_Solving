import java.util.Scanner;
import java.util.Stack;

public class Boj_10773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.peek();
            stack.pop();
        }
        System.out.println(sum);
    }
}