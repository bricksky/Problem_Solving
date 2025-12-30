import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 1;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.push(current);
                result *= 2;
            } else if (current == '[') {
                stack.push(current);
                result *= 3;
            } else {
                if (current == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    if (s.charAt(i - 1) == '(') {
                        answer += result;
                    }
                    stack.pop();
                    result /= 2;
                } else if (current == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    if (s.charAt(i - 1) == '[') {
                        answer += result;
                    }
                    stack.pop();
                    result /= 3;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
