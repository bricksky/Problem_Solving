import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결과 값
        int result = 0;

        // 가장 처음에 입력받을 학생 수와 방의 최대 인원 수
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 힉년, 성별 배열 생성
        int[][] arr = new int[2][6];
        int s, y = 0;

        // 배열에 각각의 수 넣어주기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            // 해당 성별과 학년의 카운트를 계산
            arr[s][y-1]++;
        }

        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                result += (int) Math.ceil((double)arr[i][j] / (double)k);
            }
        }
        System.out.println(result);
    }
}
