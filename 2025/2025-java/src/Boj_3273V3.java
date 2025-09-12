import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_3273V3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();

        // 배열 생성
        boolean[] exist = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            exist[a[i]] = true;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int pairValue = x - a[i];
            if (0 <= pairValue && pairValue <= 1000000)
                answer += exist[pairValue] ? 1 : 0;
        }
        System.out.println(answer/2);
    }
}
