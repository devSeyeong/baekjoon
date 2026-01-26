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

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd){
                case 1:
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case 3:
                    bw.write((dq.isEmpty() ? -1 : dq.pollFirst()) + "\n");
                    break;

                case 4:
                    bw.write((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");
                    break;

                case 5:
                    bw.write(dq.size() + "\n");
                    break;

                case 6:
                    bw.write((dq.isEmpty() ? 1: 0) + "\n");
                    break;

                case 7:
                    bw.write((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
                    break;

                case 8:
                    bw.write((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
                    break;

            }
        }


        bw.flush();
        bw.close();

    }


}
