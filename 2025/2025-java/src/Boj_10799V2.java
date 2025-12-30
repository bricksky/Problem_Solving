import java.io.IOException;
import java.util.Scanner;

public class Boj_10799V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        int openCount = 0;
        int ans = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                openCount++;
            } else if (input[i] == ')') {
                openCount--;
                if (input[i - 1] == '(') {
                    ans += openCount;
                } else {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
