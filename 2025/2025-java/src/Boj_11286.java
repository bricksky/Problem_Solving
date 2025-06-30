import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if(absA==absB){
                return Integer.compare(a,b);
            } else {
                return Integer.compare(absA, absB);
            }
        });

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(queue.isEmpty()){
                    sb.append("0").append("\n");
                } else {
                    sb.append((queue.poll())).append("\n");
                }
            } else {
                queue.add(x);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
