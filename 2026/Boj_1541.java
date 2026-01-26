import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputWords = input.split("-");

        int result = 0;

        for (int i = 0; i < inputWords.length; i++) {
            int temp = calculateSum(inputWords[i]);

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }

    private static int calculateSum(String group) {
        int sum = 0;
        String[] numbers = group.split("\\+");
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
