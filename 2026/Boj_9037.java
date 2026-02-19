import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int[] arr;

        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            plus(arr);

            int count = 0;

            while (!isSame(arr)) {
                count++;
                rotate(arr);
                plus(arr);
            }
            System.out.println(count);
        }
    }

    // 홀수인 경우, 짝수로 맞춰주기
    static void plus(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
            }
        }
    }

    // 같은 숫자인자 비교
    static boolean isSame(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[0]) {
                return false;
            }
        }
        return true;
    }

    // 사탕 넘겨주기
    static void rotate(int[] arr) {
        int[] give = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            give[i] = arr[i] / 2;
            arr[i] = arr[i] / 2;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[(i + 1) % arr.length] += give[i];
        }
    }
}
