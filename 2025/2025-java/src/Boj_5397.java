import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t --> 0){
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> listIterator = list.listIterator();

            for(char c : input.toCharArray()){
                switch (c){
                    case '<':
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        } break;
                    case '>':
                        if(listIterator.hasNext()){
                            listIterator.next();
                        } break;
                    case '-':
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                            listIterator.remove();
                        }
                        break;
                    default:
                        listIterator.add(c);
                        break;
                }
            }
            for(char ch : list){
                bw.write(ch);
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
