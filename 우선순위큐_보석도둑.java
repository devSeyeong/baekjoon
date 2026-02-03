import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int weight;
        int value;

        Jewel(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 1. 보석: 무게 오름차순
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);
        // 2. 가방: 용량 오름차순
        Arrays.sort(bags);

        // 3. 가격 기준 max-heap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0; // 보석 인덱스

        // 4. 가방 하나씩 처리
        for (int i = 0; i < K; i++) {
            int capacity = bags[i];

            // 현재 가방에 들어갈 수 있는 보석 전부 pq에 넣기
            while (idx < N && jewels[idx].weight <= capacity) {
                pq.offer(jewels[idx].value);
                idx++;
            }

            // 가장 비싼 보석 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
