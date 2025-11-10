import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_1431 {

    public static int getSumOfDigits(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static void sortSerials(List<String> serial) {
        serial.sort(((o1, o2) -> {
            // 1순위 정렬 기준
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }

            // 2순위 정렬 기준
            int sum1 = getSumOfDigits(o1);
            int sum2 = getSumOfDigits(o2);

            if (sum1 != sum2) {
                return sum1 - sum2;
            }

            // 3순위 정렬 기준
            return (o1.compareTo(o2));
        }));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> serial = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            serial.add(br.readLine());
        }

        sortSerials(serial);

        StringBuilder sb = new StringBuilder();
        for (String s : serial) {
            sb.append(s).append('\n');
        }
        System.out.print(sb.toString());
    }
}
