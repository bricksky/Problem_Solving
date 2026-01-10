import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663 {
    static int n;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        nQueen(0);
        System.out.println(count);
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    static void nQueen(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[row] = i;

            if (isPossible(row)) {
                nQueen(row + 1);
            } else {
                continue;
            }
        }
    }
}
