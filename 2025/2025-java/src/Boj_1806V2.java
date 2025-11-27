import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1806V2 {
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

        int ansLength = Integer.MAX_VALUE;
        int rightIndex = 0;
        int currentSum = 0;

        // i는 start 포인트 역할을 합니다.
        for (int i = 0; i < n; i++) {

            // 1. 합이 부족하고, right가 범위 안이라면 -> 계속 더하기
            while (currentSum < s && rightIndex < n) {
                currentSum += arr[rightIndex];
                rightIndex++; // 더하고 나서 이동
            }

            // 2. while문을 탈출했다면: 합이 S 이상이거나, 끝까지 간 경우
            if (currentSum >= s) {
                // 길이 계산: rightIndex는 이미 1 증가된 상태이므로 (rightIndex - i)가 길이
                ansLength = Math.min(ansLength, rightIndex - i);
            }

            // 3. 다음 for문(i+1)로 넘어가기 전에, 현재 맨 앞(arr[i])을 버림
            currentSum -= arr[i];
        }

        // 결과 출력 처리
        if (ansLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ansLength);
        }
    }
}