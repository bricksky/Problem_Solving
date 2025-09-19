import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3085 {

    static int getMaxCandies(char[][] board, int n) {
        int maxCandies = 1;

        // 행 체크
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                    maxCandies = Math.max(maxCandies, count);
                } else {
                    count = 1;
                }
            }
        }

        // 열 체크
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                    maxCandies = Math.max(maxCandies, count);
                } else {
                    count = 1;
                }
            }
        }
        return maxCandies;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2차원 배열 생성
        char[][] board = new char[n][n];

        // 보드에 4개의 색상 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxCandies = getMaxCandies(board, n);

        // 보드에서 2개씩 값 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 교환
                if (j < n - 1) {
                    // (i,j)와 (i,j+1)교환
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    // 함수 호출
                    maxCandies = Math.max(maxCandies, getMaxCandies(board, n));

                    // 복구
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
                // 아래쪽 교환
                if (i < n - 1) {
                    // (i,j)와 (i+1,j)교환
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    // 함수 호출
                    maxCandies = Math.max(maxCandies, getMaxCandies(board, n));

                    // 복구
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }
        System.out.println(maxCandies);
    }
}