import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_2573 {

    static int n, m;
    static int[][] earth;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Ice> iceList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        earth = new int[n][m];
        visited = new boolean[n][m];
        iceList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                earth[i][j] = sc.nextInt();
                if (earth[i][j] > 0) {
                    iceList.add(new Ice(i, j, earth[i][j]));
                }
                visited[i][j] = true;
            }
        }

        // 시간이 지날때마다 빙산 녹이기
        for (int year = 1; !iceList.isEmpty(); year++) {
            for (Ice ice : iceList) {
                for (int j = 0; j < 4; j++) {
                    int nr = ice.row + dr[j];
                    int nc = ice.col + dc[j];

                    if (earth[nr][nc] == 0) {
                        ice.height--;
                    }
                }
            }
            // 녹은 빙산의 높이를 한번에 갱신
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    earth[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size() - 1));
                    iceList.remove(iceList.size() - 1);
                    i--;
                    // 빙산이 남아있다면 연결되어있는지 탐색하도록
                } else {
                    visited[ice.row][ice.col] = false;
                }
            }
            if (iceList.size() > 0 && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }
        System.out.println(0);
    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (visited[nr][nc]) {
                continue;
            }
            count += dfs(nr, nc);
        }
        return count;
    }

    static class Ice {
        int row;
        int col;
        int height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
