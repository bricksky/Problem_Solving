import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2661 {
    static int input;
    static String output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        dfs("");
    }

    static void dfs(String number) {
        if (number.length() == input) {
            System.out.println(number);
            System.exit(0);
            return;
        } else {
            for (int i = 1; i <= 3; i++) {
                String nextNumber = number + i;
                if (check(nextNumber)) {
                    dfs(nextNumber);
                }
            }
        }
    }

    static boolean check(String s) {
        int length = s.length();

        for (int i = 1; i <= length / 2; i++) {
            String back = s.substring(length - i, length);
            String front = s.substring(length - (i * 2), length - i);

            if (back.equals(front)) {
                return false;
            }
        }
        return true;
    }
}
