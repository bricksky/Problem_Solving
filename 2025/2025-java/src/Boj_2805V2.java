import java.io.IOException;
import java.util.Scanner;

public class Boj_2805V2 {
    static boolean isPossible(int[] height, int cutHeight, int thresholdHeight) {
        long sum = 0;
        for (int h : height) {
            if (h > cutHeight) {
                sum += h - cutHeight;
            }
        }
        return sum >= thresholdHeight;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int left = 0;
        int right = 1000000000;
        int ans = -1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (isPossible(height, middle, m)) {
                ans = middle;
                left = middle + 1;
            } else
                right = middle - 1;
        }
        System.out.println(ans);
    }
}
