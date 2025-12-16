import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            int result = check(0, arr[i].length() - 1, arr[i], 0);
            System.out.println(result);
        }
    }

    private static int check(int start, int end, String s, int check) {
        while (start < end) {
            // 회문인 경우
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } // 회문이 아닌 경우
            else {
                if (check >= 1) {

                    return 2;
                }
                return Math.min(
                        check(start + 1, end, s, check + 1),
                        check(start, end - 1, s, check + 1));
            }
        }
        return check;
    }
}
