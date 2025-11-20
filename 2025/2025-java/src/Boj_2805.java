import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본적으로 입력받는 값
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] treesArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            treesArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treesArr);

        // 최솟값, 최댓값, 결과값
        int minHeight = 0;
        int maxHeight = treesArr[n - 1];
        int result = 0;

        while (minHeight <= maxHeight) {

            // 절단기 값(중간값 설정)
            int mid = (minHeight + maxHeight) / 2;

            // 잘린 나무의 합 계산
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (treesArr[i] > mid) {
                    sum += treesArr[i] - mid;
                }
            }
            if (sum < m) {
                maxHeight = mid - 1;
            } else {
                minHeight = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
