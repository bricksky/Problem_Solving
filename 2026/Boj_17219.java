import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int savedSite = Integer.parseInt(st.nextToken());
        int findSite = Integer.parseInt(st.nextToken());

        HashMap<String, String> nameWithPwd = new HashMap<>();

        for (int i = 1; i <= savedSite; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            nameWithPwd.put(site, pwd);
        }

        for (int j = 1; j <= findSite; j++) {
            String targetSite = br.readLine();
            String targetPassword = nameWithPwd.get(targetSite);
            sb.append(targetPassword).append("\n");
        }
        System.out.println(sb);
    }
}
