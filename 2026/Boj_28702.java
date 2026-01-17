import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_28702 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetNum = 0;

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            char firstChar = input.charAt(0);
            if (firstChar != 'F' && firstChar != 'B') {
                int n = Integer.parseInt(input);
                targetNum = n + (3 - i);
            }
        }
        if (targetNum % 3 == 0 && targetNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (targetNum % 3 == 0 && targetNum % 5 != 0) {
            System.out.println("Fizz");
        } else if (targetNum % 3 != 0 && targetNum % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(targetNum);
        }
    }
}
