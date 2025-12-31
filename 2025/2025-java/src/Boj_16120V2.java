import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_16120V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();
        char[] stack = new char[len];
        int top = 0;

        for (int i = 0; i < len; i++) {
            stack[top++] = input.charAt(i);

            if (top >= 4) {
                if (stack[top - 4] == 'P' &&
                        stack[top - 3] == 'P' &&
                        stack[top - 2] == 'A' &&
                        stack[top - 1] == 'P') {
                    top -= 3;
                }
            }
        }
        if (top == 1 && stack[0] == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
