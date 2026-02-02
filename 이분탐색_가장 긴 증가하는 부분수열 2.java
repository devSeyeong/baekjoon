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
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0 ; i< N ; i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = max;

            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = num;

            if (left == max) {
                max++;
            }
        }

        bw.write(max+"");

        bw.flush();
        bw.close();

    }

}
