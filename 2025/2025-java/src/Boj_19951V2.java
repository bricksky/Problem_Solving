import java.io.IOException;
import java.util.Scanner;

public class Boj_19951V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] origin = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            origin[i] = sc.nextInt();
        }

        int[] delta = new int[n + 2];

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            delta[a] += k;
            delta[b + 1] -= k;
        }

        int[] accDelta = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(origin[i] + accDelta[i] + " ");
        }
        System.out.println();
    }
}
