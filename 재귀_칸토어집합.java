import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args)  throws IOException{



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String s = br.readLine();
//        StringTokenizer st = new StringTokenizer(s);
//        int n = Integer.parseInt(st.nextToken());
//
//        for(int i=0 ; i<n ;i++){
//            s = br.readLine();
//            st = new StringTokenizer(s);
//            int num1 = Integer.parseInt(st.nextToken());
//            int num2 = Integer.parseInt(st.nextToken());
//            bw.write(combination(num2, num1) + "\n");
//        }

        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            int size = (int) Math.pow(3, N);

            arr = new char[size];
            for (int i = 0; i < size; i++) {
                arr[i] = '-';
            }

            cantor(0, size);

            System.out.println(new String(arr));
        }

        bw.flush();
        bw.close();
    }


    static char[] arr;
    public static void cantor (int start, int length){
        if (length == 1) return;

        int third = length / 3;

        for (int i = start + third ; i< start + 2 * third; i++){
            arr[i] = ' ';
        }

        cantor(start, third);
        cantor(start + 2 * third, third);
    }


}
