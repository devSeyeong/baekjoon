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

        String s = br.readLine();

        int[][] prefix = new int[s.length() +1][26];


        for(int i=1; i< s.length() + 1; i++){
            int charNum = s.charAt(i -1)-'a';
            for(int j = 0 ; j<26 ;j++) {
                if (j == charNum) {
                    prefix[i][j] = prefix[i - 1][j] + 1;
                }else prefix[i][j] = prefix[i - 1][j];
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int charNum = st.nextToken().charAt(0)- 'a';
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            int answer = prefix[endIndex+1][charNum] - prefix[startIndex][charNum];
            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();

    }

}
