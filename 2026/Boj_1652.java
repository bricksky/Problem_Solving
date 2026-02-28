import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int horizontalResult = 0;
        int verticalResult = 0;

        // 가로 방향 체크
        for (int i = 0; i < n; i++) {

            int checkWidth = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    checkWidth++;
                } else if (map[i][j] == 'X') {
                    if (checkWidth >= 2) {
                        horizontalResult++;
                    }
                    checkWidth = 0;
                }
            }
            if (checkWidth >= 2) {
                horizontalResult++;
            }
        }

        // 세로 방향 체크
        for (int i = 0; i < n; i++) {

            int checkHeight = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == '.') {
                    checkHeight++;
                } else if (map[j][i] == 'X') {
                    if (checkHeight >= 2) {
                        verticalResult++;
                    }
                    checkHeight = 0;
                }
            }
            if (checkHeight >= 2) {
                verticalResult++;
            }
        }

        System.out.println(horizontalResult + " " + verticalResult);
    }
}
