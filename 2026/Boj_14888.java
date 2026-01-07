import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MUL = 2;
    static final int DIV = 3;

    static int n;
    static int[] numbers;
    static int[] operators = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int sum) {
        // base
        if (index == n) {
            if (sum > max) max = sum;
            if (sum < min) min = sum;
            return;
        }

        // recursive
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case PLUS -> solve(index + 1, sum + numbers[index]);
                    case MINUS -> solve(index + 1, sum - numbers[index]);
                    case MUL -> solve(index + 1, sum * numbers[index]);
                    case DIV -> solve(index + 1, sum / numbers[index]);
                }
                operators[i]++;
            }
        }
    }
}
