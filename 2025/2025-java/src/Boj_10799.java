import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10799 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.push('(');
            } else {
                stack.pop();

                // 레이저인 경우
                if (s.charAt(i - 1) == '(') {
                    sum += stack.size();
                } else {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
