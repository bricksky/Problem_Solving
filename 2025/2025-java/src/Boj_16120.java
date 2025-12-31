import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            stack.push(current);

            if (stack.size() >= 4) {
                int size = stack.size();

                if (stack.get(size - 4) == 'P' &&
                        stack.get(size - 3) == 'P' &&
                        stack.get(size - 2) == 'A' &&
                        stack.get(size - 1) == 'P') {

                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    stack.push('P');
                }
            }
        }
        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
