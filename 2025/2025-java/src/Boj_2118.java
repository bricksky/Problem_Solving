import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n * 2];
        int totalSum = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            totalSum += arr[i];
        }

        int start = 0;
        int end = 0;
        int result = 0;

        while (start < n && end < 2 * n) {
            int current = Math.min(currentSum, totalSum - currentSum);
            result = Math.max(result, current);

            // 절반보다 작은 경우 -> 마지막 인덱스를 전진
            if (currentSum <= totalSum / 2) {
                currentSum += arr[end % n];
                end++;
            } else {
                // 절반보다 큰 경우 -> 시작 인덱스를 전진
                currentSum -= arr[start % n];
                start++;
            }
        }
        System.out.println(result);
    }
}
