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

        boolean[] isStack = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ;i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            isStack[i] = input == 1 ? true : false;
        }

        st = new StringTokenizer(br.readLine());

        // 큐보다 덱을 쓰는것이 효율이 좋다.
        Deque<Integer> queue = new ArrayDeque<>();

        // 스택이면 절대 나올일이 없어서 필요 없다. 큐에 들어있는 것들이 순서대로 나올 것.
        for (int i = 0 ;i < N; i++){
            int val = Integer.parseInt(st.nextToken());
            if (!isStack[i]) {
                queue.offerLast(val);
            }
        }

        int count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ;i < count; i++){
            int input = Integer.parseInt(st.nextToken());

            if (queue.isEmpty()) {
                // 큐가 없으면 그대로 출력
                bw.write(input + " ");
            } else {
                // 큐가 있으면 정상 동작
                int result = queue.pollFirst();
                bw.write(result + " ");
                queue.offerLast(input);
            }
        }

        bw.flush();
        bw.close();

    }


}
