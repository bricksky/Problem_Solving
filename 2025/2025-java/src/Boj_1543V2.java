import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1543V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String word = br.readLine();

        int startIndex = 0;
        int count = 0;

        while(true){
            int findIndex = doc.indexOf(word, startIndex);
            if(findIndex<0){
                break;
            }
            startIndex = findIndex + word.length();
            count++;
        }
        System.out.println(count);
    }
}