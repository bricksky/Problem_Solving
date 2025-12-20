import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            int[] aArr = new int[aSize];
            int[] bArr = new int[bSize];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aSize; i++) {
                aArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bSize; i++) {
                bArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(bArr);
            int totalCount = 0;

            for (int target : aArr) {
                totalCount += countSmaller(bArr, target);
            }
            System.out.println(totalCount);
        }
    }

    private static int countSmaller(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
