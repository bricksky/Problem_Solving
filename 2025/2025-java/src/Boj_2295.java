import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > 0; j--) {
                int k = arr[j] - arr[i];
                if (sum.contains(k)) {
                    result = Math.max(arr[j], result);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
