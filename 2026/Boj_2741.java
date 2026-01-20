import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_2741 {
    static int[] students = new int[25];
    static boolean[] visited;
    static List<Integer> pick = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'S') {
                    students[count] = 1; // 이다솜파
                } else {
                    students[count] = 0; // 임도연파
                }
                count++;
            }
        }

        // 조합 시작
        findSevenPrincesses(0);
        System.out.println(result);
    }

    // 25명 중 7명을 뽑는 조합
    static void findSevenPrincesses(int studentNum) {
        if (pick.size() == 7) {
            // 1. 이다솜파(1)가 4명 이상인지 확인
            int sCount = 0;
            for (int i = 0; i < 7; i++) {
                if (students[pick.get(i)] == 1) sCount++;
            }

            if (sCount >= 4) {
                // 2. 7명이 서로 연결되어 있는지 확인
                visited = new boolean[7]; // 매번 새로운 조합에 대해 초기화
                if (dfs(0) == 7) {
                    result++;
                }
            }
            return;
        }

        if (studentNum >= 25) return;

        // 현재 학생 포함하는 경우
        pick.add(studentNum);
        findSevenPrincesses(studentNum + 1);
        pick.remove(pick.size() - 1);

        // 현재 학생 포함하지 않는 경우
        findSevenPrincesses(studentNum + 1);
    }

    // 선택된 7명 사이의 연결성 확인
    static int dfs(int index) {
        visited[index] = true;
        int count = 1;

        for (int i = 0; i < 7; i++) {
            // 아직 방문하지 않았고, pick 리스트의 index번째 학생과 i번째 학생이 친구라면
            if (!visited[i] && isFriend(pick.get(index), pick.get(i))) {
                count += dfs(i);
            }
        }
        return count;
    }

    // 두 인덱스가 5x5 격자에서 상하좌우로 인접한지 확인
    static boolean isFriend(int a, int b) {
        int r1 = a / 5, c1 = a % 5;
        int r2 = b / 5, c2 = b % 5;

        // 행 차이와 열 차이의 합이 1이면 상하좌우 인접
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) == 1;
    }
}