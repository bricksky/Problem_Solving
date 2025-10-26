import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();

        final long Mod = 1234567891;
        long hash = 0;
        long powerOfR = 1;

        for (int i = 0; i < L; i++) {
            long val = S.charAt(i) - 'a' + 1;
            long term = (val * powerOfR) % Mod;

            hash = (hash + term) % Mod;
            powerOfR = (powerOfR * 31) % Mod;
        }
        System.out.println(hash);
    }
}
