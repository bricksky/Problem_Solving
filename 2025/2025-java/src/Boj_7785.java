import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> member = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String check = st.nextToken();

            if (check.equals("enter")) {
                member.put(name, check);
            } else if (check.equals("leave")) {
                member.remove(name);
            }
        }
        List<String> currentMembers = new ArrayList<>(member.keySet());
        currentMembers.sort(Comparator.reverseOrder());

        for (String name : currentMembers) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
