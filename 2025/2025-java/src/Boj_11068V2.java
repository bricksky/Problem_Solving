import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_11068V2 {

    public static int[] convertBase(int x, int b) {
        int length = 0, copyX = x;
        while (copyX > 0) {
            copyX /= b;
            length++;
        }
        int[] digit = new int[length];
        length = 0;
        while (x > 0) {
            digit[length++] = x % b;
            x = x / b;
        }
        return digit;
    }

    public static boolean isPalindrom(int[] digit) {
        for (int i = 0; i < digit.length / 2; i++) {
            if (digit[i] != digit[digit.length - i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int x = scanner.nextInt();

            boolean ans = false;

            for (int i = 2; i <= 64; i++) {
                int[] digit = convertBase(x, i);
                if (isPalindrom(digit)) {
                    ans = true;
                }
            }
            System.out.println(ans ? "1:" : "0");
        }
    }
}