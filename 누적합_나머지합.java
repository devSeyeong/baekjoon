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
        int M = Integer.parseInt(st.nextToken());

        int[] mod = new int[M];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            int modNum = (int) (sum % M);
            mod[modNum] ++;
        }

        // 처음부터 i 까지의 합은 무조건 된다.
        long answer = mod[0];

        // 나머지는 어디부터 어디까지로 빼기가 들어간다. 그래서 2개를 골라야함.
        for(int i=0; i< M; i++){
            if (mod[i] >= 2) {
                // 캐스팅 중요
                answer += (long) mod[i] * (mod[i] - 1) / 2;
            }
        }

        bw.write(answer+ " ");

        bw.flush();
        bw.close();

    }

}
