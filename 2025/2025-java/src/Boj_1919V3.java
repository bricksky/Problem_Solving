import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1919V3 {

    // 함수처럼 아예 밖으로 빼서 공통되는 로직을 축약할 수 있음
    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);

        int result = 0;
        for (int i = 0; i < 26; i++) {
            // abs는 절댓값 계신 가능.
            result += Math.abs(countA[i] - countB[i]);
        }
        System.out.println(result);
    }
}
