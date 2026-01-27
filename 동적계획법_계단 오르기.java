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

        // 밟는 경우와 밟지 않는 경우
        int[][] dp = new int[N][2];



        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int value =  Integer.parseInt(st.nextToken());

            if (i==0) {
                // 비연속
                dp[i][0] = value;
                // 연속
                dp[i][1] = 0;
            } else if(i==1) {
                dp[i][0] = value;
                dp[i][1] = value + dp[i-1][0];
            } else {
                dp[i][0] = Math.max(dp[i-2][1], dp[i-2][0] ) + value;
                dp[i][1] = dp[i-1][0] + value;
            }
        }

        bw.write(Math.max(dp[N-1][0], dp[N-1][1])+"");



        bw.flush();
        bw.close();

    }

}
