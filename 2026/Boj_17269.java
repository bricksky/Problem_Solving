import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17269 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String nameA = st.nextToken();
        String nameB = st.nextToken();

        ArrayList<Integer> list = new ArrayList<>();

        int minLength = Math.min(a, b);
        for (int i = 0; i < minLength; i++) {
            list.add(alphabet[nameA.charAt(i) - 'A']);
            list.add(alphabet[nameB.charAt(i) - 'A']);
        }
        if (a > b) {
            for (int i = minLength; i < a; i++) {
                list.add(alphabet[nameA.charAt(i) - 'A']);
            }
        }
        if (b > a) {
            for (int i = minLength; i < b; i++) {
                list.add(alphabet[nameB.charAt(i) - 'A']);
            }
        }

        while (list.size() > 2) {
            ArrayList<Integer> nextList = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = (list.get(i) + list.get(i + 1)) % 10;
                nextList.add(sum);
            }
            list = nextList;
        }
        int result = list.get(0) * 10 + list.get(1);
        System.out.println(result + "%");
    }
}
