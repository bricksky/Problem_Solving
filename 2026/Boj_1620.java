import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2개의 처리 방법
        HashMap<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        for (int j = 1; j <= m; j++) {
            String monster = br.readLine();

            if (isNum(monster)) {
                int num = Integer.parseInt(monster);
                sb.append(numToName[num]).append("\n");
            } else {
                sb.append(nameToNum.get(monster)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isNum(String monster) {
        char firstWord = monster.charAt(0);
        return firstWord >= '0' && firstWord <= '9';
    }
}
