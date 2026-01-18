import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();
        int sum = 0;
        int totalWeight = 0;

        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);

            int weight = (i % 2 == 0) ? 1 : 3;

            if (c == '*') {
                totalWeight = weight;
            } else {
                sum += (c - '0') * weight;
            }
        }

        for (int i = 0; i <= 9; i++) {
            if ((sum + i * totalWeight) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
