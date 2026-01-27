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

        int[][] dp = new int[N][3];



        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int r =  Integer.parseInt(st.nextToken());
            int g =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            if(i==0) {
                dp[i][0] = r;
                dp[i][1] = g;
                dp[i][2] = b;
            } else {
                dp[i][0] = Math.min(dp[i-1][1] + r, dp[i-1][2] + r);
                dp[i][1] = Math.min(dp[i-1][0] + g, dp[i-1][2] + g);
                dp[i][2] = Math.min(dp[i-1][0] + b, dp[i-1][1] + b);
            }
        }

        bw.write(Math.min(Math.min(dp[N-1][0], dp[N-1][1]),dp[N-1][2])+"");



        bw.flush();
        bw.close();

    }

}
