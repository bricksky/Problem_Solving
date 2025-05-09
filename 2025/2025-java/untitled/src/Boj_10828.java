import java.util.Scanner;
import java.util.Stack;

public class Boj_10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String input = scanner.next();

            switch (input) {
                case "push":
                    int num = scanner.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;

            }
        }
    }
}
