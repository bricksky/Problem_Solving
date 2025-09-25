import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String commands = br.readLine();

        // 판 초기화
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 시작 위치
        int x = 0, y = 0;

        // 입력 처리
        for (char cmd : commands.toCharArray()) {
            int nx = x, ny = y;
            boolean isVertical = false;

            switch (cmd) {
                case 'U':
                    nx = x - 1;
                    isVertical = true;
                    break;
                case 'D':
                    nx = x + 1;
                    isVertical = true;
                    break;
                case 'L':
                    ny = y - 1;
                    break;
                case 'R':
                    ny = y + 1;
                    break;
            }

            // 경계 체크
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (isVertical) {
                    // 세로 이동
                    if (board[x][y] == '-') board[x][y] = '+';
                    else if (board[x][y] != '+') board[x][y] = '|';

                    if (board[nx][ny] == '-') board[nx][ny] = '+';
                    else if (board[nx][ny] != '+') board[nx][ny] = '|';
                } else {
                    // 가로 이동
                    if (board[x][y] == '|') board[x][y] = '+';
                    else if (board[x][y] != '+') board[x][y] = '-';

                    if (board[nx][ny] == '|') board[nx][ny] = '+';
                    else if (board[nx][ny] != '+') board[nx][ny] = '-';
                }
                x = nx;
                y = ny;
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        br.close();
    }
}
