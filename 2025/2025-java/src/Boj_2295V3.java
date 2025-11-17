import java.util.Arrays;
import java.util.Scanner;

public class Boj_2295V3 {
    static boolean isExist(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else if (arr[m] > target) {
                r = m - 1;
            } else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. A+B의 집합
        int[] sums = new int[n * (n + 1) / 2];
        int sumsIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums[sumsIndex++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sums);

        // 2. 모든 X-C에 대해 A+B가 존재하는지 확인
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = arr[i] - arr[j];

                if (isExist(sums, target)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        // 3. 최대값 출력
        System.out.println(ans);
    }
}
