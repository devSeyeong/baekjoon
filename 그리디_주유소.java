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
        int N = Integer.parseInt(st.nextToken()) -1;

        int[] distances = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 초기화
        long totalPrice = 0;
        int lowestPrice = Integer.parseInt(st.nextToken());
        int distance = 0;

        for(int i=0; i< N; i++){
            int price = Integer.parseInt(st.nextToken());
            distance += distances[i];
            if(price < lowestPrice || i == N-1){
                // 캐스팅 주의
                totalPrice += (long) lowestPrice * distance;
                lowestPrice = price;
                distance = 0;
            }
        }

        bw.write(totalPrice+ " ");

        bw.flush();
        bw.close();

    }

}
