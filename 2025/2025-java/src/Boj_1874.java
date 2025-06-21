import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Boj_1874 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();

        int count = 1;
        int n = scanner.nextInt();

        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();

            while (count <= k) {
                stack.push(count);
                count += 1;
                result.add('+');
            }
            if (!stack.isEmpty() && stack.peek() == k) {
                stack.pop();
                result.add('-');
            } else {
                System.out.println("NO");
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            for (char c : result) {
                System.out.println(c);
            }
        }
    }
}
