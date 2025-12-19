import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (true) {
            arr[n % 10]++;
            if (n / 10 == 0) {
                break;
            }
            n = n / 10;
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                count = Math.max(count, arr[i]);
            }
        }
        System.out.println(Math.max(count, (arr[6] + arr[9] + 1) / 2));
    }
}