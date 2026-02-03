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

        // 큐를 두개로 나누서, 작은큐 큰큐로 중앙값 찾기
        for (int i = 0 ; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer>  maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // 개수
            int count = (m+1)/2;
            if(i!=0){
                bw.write("\n");
            }
            bw.write( + count+ "\n");

                int printed = 0;

                for(int k = 0; k < m ; k ++ ){
                    if(k%10 == 0){
                        st = new StringTokenizer(br.readLine());
                    }
                    int x = Integer.parseInt(st.nextToken());

                    // 삽입
                    if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                        maxHeap.offer(x);
                    } else {
                        minHeap.offer(x);
                    }

                    // 균형 맞추기
                    if (maxHeap.size() > minHeap.size() + 1) {
                        minHeap.offer(maxHeap.poll());
                    } else if (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }


                    // 홀수 번째면 중앙값 출력
                    if ((k + 1) % 2 == 1) {
                        bw.write(maxHeap.peek()+ " ");
                        printed ++;
                        if(printed % 10 == 0){
                            bw.write("\n");
                        }
                    }
                }
            }

        bw.flush();
        bw.close();

    }

}
