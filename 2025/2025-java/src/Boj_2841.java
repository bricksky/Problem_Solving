import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer>[] guitar = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            guitar[i] = new Stack<>();
        }

        int move = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!guitar[line].isEmpty() && guitar[line].peek() > fret) {
                guitar[line].pop();
                move++;
            }
            if (!guitar[line].isEmpty() && guitar[line].peek() == fret) {
                continue;
            }
            guitar[line].push(fret);
            move++;
        }
        System.out.println(move);
    }
}
