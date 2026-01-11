import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629V2 {
    static int a, b, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(power(a, b));
    }

    static long power(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long half = power(a, b / 2);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return (((half * half) % c) * a) % c;
        }
    }
}
