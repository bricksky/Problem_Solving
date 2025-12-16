import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_17609V2 {

    static boolean isPalindrome(char[] s, int l, int r) {
        while (l <= r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            char[] s = scanner.next().toCharArray();

            int l = 0;
            int r = s.length - 1;
            int ans = 0;

            while (l <= r) {
                if (s[l] == s[r]) {
                    l++;
                    r--;
                } else {
                    if (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)) {
                        ans = 1;
                    } else {
                        ans = 2;
                    }
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}