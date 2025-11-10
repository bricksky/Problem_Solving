import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_18310 {
    public static int middle(List<Integer> place){
        place.sort(Comparator.naturalOrder());
        int size = place.size();
        int meddleIndex = (size-1)/2;
        return place.get(meddleIndex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> place = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            place.add(Integer.parseInt(st.nextToken()));
        }
        int result = middle(place);
        System.out.println(result);
    }
}
