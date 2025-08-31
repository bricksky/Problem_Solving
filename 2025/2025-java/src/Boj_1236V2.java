import java.util.Scanner;

public class Boj_1236V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = scanner.next().toCharArray();
        }

        // 1. 각 행에 경비원이 있는지 확인
        int existRowCount = 0;
        for (int r = 0; r < n; r++) {
            boolean exist = false;
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 'X') {
                    exist = true;
                    break;
                }
                if (exist)
                    existRowCount++;
            }
        }

        int existColCount = 0;
        for (int c = 0; c < m; c++) {
            boolean exist = false;
            for (int r = 0; r < n; r++) {
                if (map[r][c] == 'X') {
                    exist = true;
                    break;
                }
                if (exist)
                    existColCount++;
            }
        }

        // 2. 보호받지 못하는 행/열 개수 확인
        int needRowCount = n-existRowCount;
        int needColCount = m-existColCount;

        // 3. 둘 중 큰 값 출력
        System.out.println(Math.max(needRowCount, needColCount));
    }
}
