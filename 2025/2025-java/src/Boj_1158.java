import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        sb.append("<");
        while (!numbers.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) {
                    if (numbers.size() == 1) {
                        sb.append(numbers.remove());
                    } else {
                        sb.append(numbers.remove() + ", ");
                    }
                } else {
                    numbers.add(numbers.remove());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}