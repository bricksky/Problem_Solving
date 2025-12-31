import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int nextNum = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int currentTarget = target[i];

            while (nextNum <= currentTarget) {
                stack.push(nextNum++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == currentTarget) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        if (possible) {
            System.out.println(sb);
        } else
            System.out.println("NO");
    }
}
