import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1931 {
    public static class Conference {
        int startTime;
        int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Conference> conferences = new ArrayList<>();

        // n번 만큼 반복하며 회의 받아오기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            conferences.add(new Conference(startTime, endTime));
        }

        conferences.sort((c1, c2) -> {
            // 1차 기준
            int result = c1.endTime - c2.endTime;
            if (result != 0) {
                return result;
            }
            // 2차 기준
            return c1.startTime - c2.startTime;
        });

        // 탐욕 알고리즘
        int count = 0;
        int lastEndTime = 0;

        for (Conference c : conferences) {
            // 시작 시간이 졸료시작 이후라면,
            if (c.startTime >= lastEndTime) {
                count++;
                lastEndTime = c.endTime;
            }
        }
        System.out.println(count);
    }
}
