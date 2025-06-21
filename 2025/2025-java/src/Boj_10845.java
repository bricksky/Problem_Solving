import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int last = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch (s) {
                case "push":
                    // last에 일단 저장하는 부분
                    last = Integer.parseInt(st.nextToken());
                    // last에 저장한걸 queue에 넣어주는 부분
                    queue.offer(last);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
            }
        }
        System.out.println(sb);
    }
}
