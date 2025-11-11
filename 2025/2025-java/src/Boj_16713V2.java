import java.io.IOException;
import java.util.Scanner;

public class Boj_16713V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // 누적 XOR
        int[] acc = new int[n + 1];
        for (int i = 1; i < n; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }

        // q번의 질문 [s:e]의 질문
        int ans = 0;
        while (q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            ans ^= acc[e] ^ acc[s - 1];
        }
        System.out.println(ans);
    }
}
