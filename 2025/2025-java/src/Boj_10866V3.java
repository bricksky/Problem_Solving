import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_10866V3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;

        while (n-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                deque.offerFirst(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("push_back")) {
                deque.offerLast(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("pop_front")) {
                sb.append(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
            } else if (cmd[0].equals("pop_back")) {
                sb.append(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
            } else if (cmd[0].equals("size")) {
                sb.append(deque.size() + "\n");
            } else if (cmd[0].equals("empty")) {
                sb.append(deque.isEmpty() ? "1\n" : "0\n");
            } else if (cmd[0].equals("front")) {
                sb.append(deque.isEmpty() ? "-1\n" : deque.getFirst() + "\n");
            } else if (cmd[0].equals("back")) {
                sb.append(deque.isEmpty() ? "-1\n" : deque.getLast() + "\n");
            }
        }
        System.out.println(sb);
    }
}