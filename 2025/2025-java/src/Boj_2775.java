import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // 각 호마다 사람 수 저장
            int[] arr = new int[n];

            // 0층 사람들
            for (int j = 0; j < n; j++) {
                arr[j] = j + 1;
            }

            // k층 사람들
            for (int j = 0; j < k; j++) {
                for (int p = 1; p < n; p++) {
                    arr[p] += arr[p - 1];
                }
            }
            System.out.println(arr[n - 1]);
        }
    }
}
