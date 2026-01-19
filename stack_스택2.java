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

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n ;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Integer num = Integer.parseInt(st2.nextToken());
            if(num == 1){
                Integer num2 = Integer.parseInt(st2.nextToken());
                stack.add(num2);
            } if(num == 2) {
                if(stack.empty()){
                    bw.write("-1\n");
                } else {
                    bw.write(stack.pop()+"\n");
                }
            }if(num == 3) {
                bw.write(stack.size()+"\n");
            }if(num == 4) {
                if(stack.empty()){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }if(num == 5) {
                if(stack.empty()){
                    bw.write("-1\n");
                } else {
                    bw.write(stack.peek()+"\n");
                }
            }
        }


        bw.flush();
        bw.close();
        return;
    }


}
