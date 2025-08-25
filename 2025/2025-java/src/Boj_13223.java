import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String currentTime = new String(br.readLine());
        String dropTime =  new String(br.readLine());

        String[] currentTimeUnit = currentTime.split(":");
        int currentHour = Integer.parseInt(currentTimeUnit[0]);
        int currentMinute = Integer.parseInt(currentTimeUnit[1]);
        int currentSecond = Integer.parseInt(currentTimeUnit[2]);
        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;

        String[] dropTimeUnit = dropTime.split(":");
        int dropHour = Integer.parseInt(dropTimeUnit[0]);
        int dropMinute = Integer.parseInt(dropTimeUnit[1]);
        int dropSecond = Integer.parseInt(dropTimeUnit[2]);
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

        int needSecondAmount = dropSecondAmount - currentSecondAmount;
        if (needSecondAmount <= 0) {
            needSecondAmount += 24 * 3600;
        }

        int needHour = needSecondAmount / 3600;
        int needMinute = (needSecondAmount % 3600) / 60;
        int needSecond = (needSecondAmount % 60) % 60;

        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);
    }
}
