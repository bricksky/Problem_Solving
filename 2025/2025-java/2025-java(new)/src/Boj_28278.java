import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        while (n-- > 0) {
            String[] parts = bufferedReader.readLine().split(" ");
            int m = Integer.parseInt(parts[0]);

            switch (m) {
                case 1:
                    int x = Integer.parseInt(parts[1]);
                    stack.push(x);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        stringBuilder.append(-1).append('\n');
                    } else {
                        stringBuilder.append(stack.pop()).append('\n');
                    }
                    break;
                case 3:
                    stringBuilder.append(stack.size()).append('\n');
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        stringBuilder.append(1).append('\n');
                    } else {
                        stringBuilder.append(0).append('\n');
                    }
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        stringBuilder.append(-1).append('\n');
                    } else {
                        stringBuilder.append(stack.peek()).append('\n');
                    }
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}
