import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_17232 {
    static int[][] getPrefixSum(char[][] map) {
        int n = map.length - 1;
        int m = map[0].length - 1;
        int[][] acc = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int alive = (map[i][j] == '*' ? 1 : 0);
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + alive;
            }
        }
        return acc;
    }

    static int getRangeSum(int[][] acc, int r, int c, int K) {
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1);
        return acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String roMap = sc.next();
            for (int j = 1; j <= m; j++) {
                map[i][j] = roMap.charAt(j - 1);
            }
        }

        while (t-- > 0) {
            int[][] acc = getPrefixSum(map);
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++) {
                    int nearAlive = getRangeSum(acc, i, j, k);
                    if (map[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < a || b < nearAlive)
                            map[i][j] = '.';
                    } else if (a < nearAlive && nearAlive <= b)
                        map[i][j] = '*';
                }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}