import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_5397V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            char[] input = br.readLine().toCharArray();
            Deque<Character> beforeCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();

            for (char cmd : input) {
                if (cmd == '-') {
                    if (!beforeCursor.isEmpty()) {
                        beforeCursor.removeLast();
                    }
                } else if (cmd == '<') {
                    if (!beforeCursor.isEmpty()) {
                        afterCursor.addLast(beforeCursor.removeLast());
                    }
                } else if (cmd == '>') {
                    if (!afterCursor.isEmpty()) {
                        beforeCursor.addLast(afterCursor.removeLast());
                    }
                } else {
                    beforeCursor.addLast(cmd);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!beforeCursor.isEmpty()) {
                sb.append(beforeCursor.removeFirst());
            }
            while (!afterCursor.isEmpty()) {
                sb.append(afterCursor.removeLast());
            }
            System.out.println(sb);
        }
    }
}
