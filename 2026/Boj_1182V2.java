import java.io.IOException;
import java.util.Scanner;

public class Boj_1182V2 {

    static int s;
    static int[] numbers;
    static int answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        solve(0, 0);
        System.out.println(answer);
    }

    public static void solve(int index, int sum) {
        // base
        if (index == numbers.length) {
            return;
        }
        if (sum + numbers[index] == s) {
            answer++;
        }

        // recursive
        solve(index + 1, sum + numbers[index]);
        solve(index + 1, sum);
    }
}
