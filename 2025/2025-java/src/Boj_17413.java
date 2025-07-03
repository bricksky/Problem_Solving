import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean hasTag = false;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                hasTag = true;
                sb.append(ch);
            } else if (ch == '>') {
                hasTag = false;
                sb.append(ch);
            } else if (hasTag) {
                sb.append(ch);
            } else {
                // 뒤집는 부분
                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
