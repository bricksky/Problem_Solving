import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = fibo(n);

        System.out.println(result);
    }

    static int[] cache = new int[50];

    static int fibo(int n) {
        // base
        if (n == 1 || n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        // recursive
        cache[n] =  fibo(n - 1) + fibo(n - 2);
        return cache[n];
    }
}