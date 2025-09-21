import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_10250V2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int distance = (n - 1) / h + 1;
            int floor = (n - 1) % h + 1;
            System.out.printf("%d%02d\n", floor, distance);
        }
    }
}
