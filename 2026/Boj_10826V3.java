import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10826V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            if (sb.length() >= 4) {
                int length = sb.length();

                if (sb.charAt(length - 4) == 'P' &&
                        sb.charAt(length - 3) == 'P' &&
                        sb.charAt(length - 2) == 'A' &&
                        sb.charAt(length - 1) == 'P') {

                    // StringBuilder의 길이를 현재 길이에서 4글자 만큼 뺸 지점까지 남기고,
                    // StringBuilder에 'P'를 추가하는 로직
                    sb.setLength(length - 4);
                    sb.append('P');
                }
            }
        }
        if (sb.toString().equals("P")) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
