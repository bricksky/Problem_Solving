import java.io.IOException;
import java.util.Scanner;

public class Boj_3273V4 {
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
        for (int i = 1; i <= (x - 1) / 2; i++) {
            if (i <= 100000 && x - i < 100000) {
                answer += exist[i] && exist[x - i] ? 1 : 0;
            }
        }
        System.out.println(answer);
    }
}
