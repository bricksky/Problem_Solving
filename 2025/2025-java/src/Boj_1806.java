import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1806 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (true) {
            // 원하는 값보다 큰 상태 -> 왼쪽 구간 줄이기
            if (sum >= s) {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start];
                start++;
            } else if (end == n) {
                break;
            } else {
                sum += arr[end];
                end++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(minLen);
        }
    }
}