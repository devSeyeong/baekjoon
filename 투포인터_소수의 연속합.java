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

        // 소수 찾기
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime,true);

        for(int i= 2; i * i <=N; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= N; j += i){
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        for(int i  =2; i<=N; i++){
            if(isPrime[i]) primes.add(i);
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (true){
            if (sum >= N){
                if (sum == N) count ++;
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) break;;
                sum += primes.get(right++);
            }
        }

        bw.write(count+"");


        bw.flush();
        bw.close();

    }

}
