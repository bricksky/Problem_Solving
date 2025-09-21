import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트케이스 입력
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            // 층수, 호수 계산
            int roomFloor = n % h == 0 ? h : n % h;

            int roomNumber = n % h == 0 ? n / h : (n - 1) / h + 1;

            // 출력
            sb.append(roomFloor * 100 + roomNumber).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
