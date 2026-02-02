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
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int max = 0;

        for (int i = 0 ; i< K ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right){
            long mid =  ((long)left + right) / 2;
            long count = 0;

            for (long l : arr){
                count += l / mid;
            }
            // 만들 수 있으면 길이를 늘려본다.
            if(count >= N){
                answer = mid;
                left = mid + 1;
            } else {
                // 없으면 줄여 본다.
                right = mid -1;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();

    }

}
