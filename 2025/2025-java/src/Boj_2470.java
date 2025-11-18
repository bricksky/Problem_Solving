import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 투포인터 변수
        int left = 0;
        int right = arr.length - 1;
        long minSum = 2_000_000_001L;

        // 결과 변수
        int leftResult = 0;
        int rightResult = 0;

        while (left < right) {
            long currentSum = (long) arr[left] + (long) arr[right];

            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                leftResult = arr[left];
                rightResult = arr[right];
            }

            if (currentSum == 0) {
                break;
            } else if (currentSum < 0) {
                left++;

            } else if (currentSum > 0) {
                right--;
            }
        }

        System.out.println(leftResult + " " + rightResult);
    }
}
