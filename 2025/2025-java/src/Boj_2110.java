import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[n - 1] - arr[0];
        long result = 0;

        while (start <= end) {
            long distance = (start + end) / 2;

            if (check(distance, arr, c)) {
                result = distance;
                start = distance + 1;
            } else {
                end = distance - 1;
            }
        }

        System.out.println(result);
    }

    static boolean check(long distance, int[] arr, int c) {
        int count = 1;
        long lastInstalled = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - lastInstalled >= distance) {

                count++;
                lastInstalled = arr[i];
            }
        }
        return count >= c;
    }
}

