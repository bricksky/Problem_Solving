import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Boj_4949V2 {
    static boolean isMatched(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        }
        if (open == '[' && close == ']') {
            return false;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            char[] line = sc.nextLine().toCharArray();
            if (line.length == 1 && line[0] == '.') {
                break;
            }

            char[] opened = new char[line.length];
            int topIndex = -1;
            boolean isValid = true;

            for (char ch : line) {
                if (ch == '(' || ch == '[') {
                    opened[++topIndex] = ch;
                } else if (ch == ')' || ch == ']') {
                    if (topIndex < 0 || !isMatched(opened[topIndex--], ch)) {
                        isValid = false;
                        break;
                    }
                    topIndex--;
                }
            }
            if (topIndex >= 0) {
                isValid = false;
            }
            System.out.println(isValid ? "yes" : "no");
        }
    }
}
