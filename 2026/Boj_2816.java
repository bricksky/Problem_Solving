import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int index1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("KBS1")) {
                index1 = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        // kbs1을 위로 올리는 과정
        for (int i = 0; i < index1; i++) {
            sb.append("1");
        }
        for (int i = 0; i < index1; i++) {
            sb.append("4");
        }

        int index2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("KBS2")) {
                index2 = i;
                break;
            }
        }

        if (index1 > index2) {
            index2++;
        }
        for (int i = 0; i < index2; i++) {
            sb.append("1");
        }
        for (int i = 0; i < index2 - 1; i++) {
            sb.append("4");
        }
        System.out.println(sb);
    }
}
