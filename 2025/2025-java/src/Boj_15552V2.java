import java.io.*;
import java.util.StringTokenizer;

public class Boj_15552V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nums = br.readLine().split(" ");

            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            bw.write(a + b + '\n');
        }
        bw.flush();
    }
}