import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1730V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String command = br.readLine();

        boolean[][] passVertical = new boolean[n][n];
        boolean[][] passHorizontal = new boolean[n][n];

        int curR = 0, curC = 0;

        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);

            if (cmd == 'D') {
                if (curR == n - 1) continue;
                passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
                curR++;
            } else if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
                curR--;
            } else if (cmd == 'L') {
                if (curC == 0) continue;
                passHorizontal[curR][curC] = passHorizontal[curR][curC - 1] = true;
                curC--;
            } else if (cmd == 'R') {
                if (curC == n - 1) continue;
                passHorizontal[curR][curC] = passHorizontal[curR][curC + 1] = true;
                curC++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (passVertical[i][j] && passHorizontal[i][j])
                    sb.append('+');
                else if (passVertical[i][j])
                    sb.append('|');
                else if (passHorizontal[i][j])
                    sb.append('-');
                else
                    sb.append('.');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
