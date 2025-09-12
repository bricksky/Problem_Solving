import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 n 입력받기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 순회하며 k의 값과 같은 배열의 요소가 나오면 count++
        int k = Integer.parseInt(br.readLine());

        // 배열 정렬
        Arrays.sort(arr);

        // 투 포인터 설정
        int left = 0;
        int right = n - 1;

        // 투 포인터로 순회하며 쌍 찾기
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
