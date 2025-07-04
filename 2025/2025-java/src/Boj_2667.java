import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2667 {
    final static int max = 25;
    static boolean[][] graph;
    static boolean[][] visited;
    static int countGroup;
    static int dirY[] = {1, -1, 0, 0};
    static int dirX[] = {0, 0, 1, -1};

    // 방문한 경우 확인 -> 순회 과정
    static void dfs(int y, int x) {
        visited[y][x] = true;
        countGroup++;

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (newY >= 0 && newY < max && newX >= 0 && newX < max) {
                if (!visited[newY][newX] && graph[newY][newX]) {
                    dfs(newY, newX);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new boolean[max][max];
        visited = new boolean[max][max];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) == '1';
            }
        }

        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    countGroup = 0;
                    dfs(i, j);
                    countList.add(countGroup);
                }
            }
        }
        System.out.println(countList.size());
        Collections.sort(countList);
        for (int k = 0; k < countList.size(); k++) {
            System.out.println(countList.get(k));
        }
        br.close();
    }
}
