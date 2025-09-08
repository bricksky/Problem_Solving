import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_10989V2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] count = new int[10001];

        for (int i = 0; i < n; i++) {
            count[scanner.nextInt()]++;
        }

        for (int i = 1; i <= 1000; i++) {
            while (count[i]-- > 0) {
                System.out.println(i);
            }
        }
    }
}