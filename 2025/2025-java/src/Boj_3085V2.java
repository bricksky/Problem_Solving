import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_3085V2 {

    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    public static int findMaxRow(char[][] map) {
        int n = map.length;
        int maxRow = 0;
        for (int r = 0; r < n; r++) {
            int len = 1;
            for (int c = 1; c < n; c++) {
                if (map[r][c] == map[r][c - 1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }

    public static int findMaxColumn(char[][] map) {
        int n = map.length;
        int maxColumn = 0;
        for (int c = 0; c < n; c++) {
            int len = 1;
            for (int r = 1; r < n; r++) {
                if (map[r][c] == map[r - 1][c]) {
                    len++;
                } else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽
                if (j + 1 < n && map[i][j] != map[i][j+1]) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j + 1);
                }

                // 아래쪽
                if (i + 1 < n && map[i][j] != map[i + 1][j]) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        }
        System.out.println(ans);
    }
}