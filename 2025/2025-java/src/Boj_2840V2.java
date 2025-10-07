import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_2840V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] wheel = new char[n];
        Arrays.fill(wheel, '?');
        int curIndex = 0;

        while (k-- > 0) {
            int step = sc.nextInt();
            char nextAlphabet = sc.next().charAt(0);
            int nextIndex = ((curIndex - step) % n + n) % n;

            if (wheel[nextIndex] == '?') wheel[nextIndex] = nextAlphabet;
            else if (wheel[nextIndex] != nextAlphabet) {
                System.out.println('!');
                return;
            }
            curIndex = nextIndex;
        }
        boolean[] isUsed = new boolean[26];

        for (int i = 0; i < n; i++) {
            if (wheel[i] == '?') continue;
            if (isUsed[wheel[i] - 'A']) {
                System.out.println('!');
                return;
            }
            isUsed[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(wheel[curIndex + i] % n);
            System.out.println();
        }
    }
}
