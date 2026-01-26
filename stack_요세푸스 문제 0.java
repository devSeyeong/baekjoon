import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        bw.write("<");
        int i = 1;
        while (q.size() > 0) {
            int num = q.poll();
            if(i % K == 0 ){
                bw.write(num+"");
               if(q.size()!=0){
                   bw.write(", ");
               }
            }else {
                q.add(num);
            }
            i++;
        }

        bw.write(">");

        bw.flush();
        bw.close();

    }


}
