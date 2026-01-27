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

        // 0번째는 포함 시키는 경우, 1번째는 포함시키지 않는 경우
        int[][] dp = new int[N][2];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            int input =  Integer.parseInt(st.nextToken());
            if(i==0) {
                dp[i][0] = input;
                dp[i][1] = input;
            }else {
                dp[i][0] = Math.max(dp[i-1][0] + input, input);
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
            }
        }

        bw.write(Math.max(dp[N-1][0], dp[N-1][1])+"");



        bw.flush();
        bw.close();

    }

}
