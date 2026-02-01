import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1_000_000_007;
    static long[] fact;

    // 거듭제곱 (분할정복)
    static long pow(long base, long exp) {
        if (exp == 0) return 1;

        long half = pow(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 팩토리얼 미리 계산
        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // nCk = n! * (k! * (n-k)!)^(MOD-2) % MOD
        long denominator = fact[K] * fact[N - K] % MOD;
        long inverse = pow(denominator, MOD - 2);

        long answer = fact[N] * inverse % MOD;
        System.out.println(answer);
    }
}
