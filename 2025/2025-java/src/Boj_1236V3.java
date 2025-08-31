import java.util.Scanner;

public class Boj_1236V3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = scanner.next().toCharArray();
        }

        // 1. 각 행/열에 경비원이 있는지 확인
        boolean[] existRow = new boolean[n];
        boolean[] existCol = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    existRow[i] = true;
                    existCol[j] = true;
                }
            }
        }

        // 2. 보호받지 못하는 행/열 개수 확인
        int needRowCount = n;
        int needColCount = m;
        for (int i = 0; i < n; i++) {
            if (existRow[i])
                needRowCount--;
        }
        for (int i = 0; i < n; i++) {
            if (existCol[i])
                needColCount--;
        }

        // 3. 둘 중 큰 값 출력
        System.out.println(Math.max(needRowCount, needColCount));
    }
}
