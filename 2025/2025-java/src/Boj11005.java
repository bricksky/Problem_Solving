import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int number = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        int current = number;

        while (current > 0) {
            if (current % b < 10) {
                sb.append(current % b);
            } else {
                sb.append((char) (current % b - 10 + 'A'));
            }
            current /= b;
        }
        System.out.println(sb.reverse());
    }
}
