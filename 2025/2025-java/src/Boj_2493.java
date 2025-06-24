import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Boj_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()&&stack.peek().height<height){
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }
            stack.push(new Top(i+1,height));
        }
        bw.write(sb.toString().trim());
        bw.close();
    }
}
