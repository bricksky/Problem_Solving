import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_10597 {

    static String input;
    static List<Integer> result = new ArrayList<>();
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        int length = input.length();

        n = 0;
        if (length <= 9) {
            n = length;
        } else {
            n = 9 + (length - 9) / 2;
        }

        check = new boolean[n + 1];
        dfs(0);

        System.out.println(result);
    }

    static void dfs(int index) {
        if (index == input.length()) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.exit(0);
            return;
        } else {
            for (int i = 1; i <= 2; i++) {
                // 현재 위치 + 끊으려는 길이가 전체길이보다 크면 끊을 수 없음
                if (index + i > input.length()) {
                    continue;
                }
                // 문자열 자르기
                String sub = input.substring(index, index + i);
                int num = Integer.parseInt(sub);

                if (num > n || num == 0 || check[num]) {
                    continue;
                }

                check[num] = true;
                result.add(num);

                dfs(index + i);

                result.remove(result.size() - 1);
                check[num] = false;
            }
        }
    }
}
