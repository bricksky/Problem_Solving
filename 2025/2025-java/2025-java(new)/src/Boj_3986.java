import java.util.Scanner;
import java.util.Stack;

public class Boj_3986 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int result = 0;

        while (n-- > 0) {
            Stack<Character> stack = new Stack<>();
            String word = scanner.next();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    if (stack.peek().equals(ch)) {
                        stack.pop();
                    } else
                        stack.push(ch);
                }
            }
            if (stack.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
