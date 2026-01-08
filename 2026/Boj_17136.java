import java.util.Scanner;

public class Boj_17136 {
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int[][] board = new int[10][10];
    static int result = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        solve(0, 0, 0);

        if (result == 26) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    static void solve(int row, int col, int count) {
        // 현재까지의 색종이 개수가 이미 최솟값보다 크다면 더 볼 필요 없음
        if (result <= count) {
            return;
        }

        // 1. 붙일 위치(1인 곳) 찾기
        findNext(row, col);

        // 더 이상 붙일 곳(1)이 없다면 결과 갱신 후 종료
        if (nextRow == -1 && nextCol == -1) {
            result = Math.min(result, count);
            return;
        }

        int r = nextRow;
        int c = nextCol;

        // 2. 색종이 붙이기 시도 (큰 색종이부터 붙이는 것이 가지치기에 유리함)
        for (int size = 5; size >= 1; size--) {
            if (paper[size] > 0 && isValid(r, c, size)) {
                paper[size]--;          // 색종이 사용
                fill(r, c, size, 0);    // 보드에서 1 지우기 (0으로 덮음)

                solve(r, c, count + 1); // 다음 단계 진행

                fill(r, c, size, 1);    // 백트래킹: 보드 원복 (1로 되돌림)
                paper[size]++;          // 색종이 개수 원복
            }
        }
    }

    // 유효성 검사
    static boolean isValid(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) {
            return false;
        }
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[row + r][col + c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 색종이 덮기/치우기
    static void fill(int row, int col, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][col + j] = color;
            }
        }
    }

    static int nextRow = 0;
    static int nextCol = 0;

    // 다음 1의 위치 찾기
    static void findNext(int row, int col) {
        // row 행부터 탐색하되, 탐색 효율을 위해 단순히 전체를 훑는 방식으로 처리해도 무방
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (board[r][c] == 1) {
                    nextRow = r;
                    nextCol = c;
                    return;
                }
            }
        }
        nextRow = -1;
        nextCol = -1;
    }
}