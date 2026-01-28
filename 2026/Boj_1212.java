import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        String[] sample = {"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - '0';

            if (i == 0) {
                if (index == 0) {
                    sb.append("0");
                } else if (index == 1) {
                    sb.append("1");
                } else if (index == 2) {
                    sb.append("10");
                } else if (index == 3) {
                    sb.append("11");
                } else {
                    sb.append(sample[index]);
                }
            } else {
                sb.append(sample[index]);
            }
        }
        System.out.println(sb);
    }
}
