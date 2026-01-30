import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[9][9];

        int max = -1;   // 입력이 0일수도 있으니까
        int targetRow = 0;
        int targetCol = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            for (int j = 0; j < 9; j++) {
                int val = Integer.parseInt(st.nextToken());

                // 최댓값 업데이트 로직
                if (val > max) {
                    max = val;

                    targetRow = i + 1;
                    targetCol = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(targetRow + " " + targetCol);
    }
}
