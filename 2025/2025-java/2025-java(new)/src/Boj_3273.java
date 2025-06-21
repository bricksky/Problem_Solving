import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int x = Integer.parseInt(br.readLine());

       for(int i=0; i<n; i++){
            if(set.contains(x-arr[i])){
                count++;
            }
            set.add(arr[i]);
       }
        System.out.println(count);
    }
}

