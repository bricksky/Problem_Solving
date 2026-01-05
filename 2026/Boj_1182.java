import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {

    static int n;
    static int s;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        findSum(0, 0);

        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    public static void findSum(int index, int currentSum) {
        // base case
        if (index == n) {
            if (currentSum == s) {
                count++;
            }
            return;
        }

        // recursive case
        findSum(index + 1, currentSum + arr[index]);
        findSum(index + 1, currentSum);

    }
}
