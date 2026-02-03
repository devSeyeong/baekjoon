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
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        // 최대 N개 까지만 넣어서 유지
        for (int i = 0 ; i< N ; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));

                if (pq.size() > N) {
                    pq.poll(); // 가장 작은 값 제거
                }
            }
        }

        bw.write(pq.peek()+"");

        bw.flush();
        bw.close();

    }

}
