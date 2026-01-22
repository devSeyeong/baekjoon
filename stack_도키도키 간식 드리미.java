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
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        boolean isSuccess = true;
        int cur = 0;
        for(int i=0 ; i<n ;i++){
            // 일단 stack 에서 넣을 것 다 넣기
            while(!stack.empty() && stack.peek() == cur + 1){
                cur = stack.pop();
            }

            Integer num = Integer.parseInt(st2.nextToken());
            if(num == cur + 1){
                cur = num; // cur 증가
            }else {
                if(!stack.empty() && stack.peek() < num){
                    isSuccess = false;
                    break;
                }
                stack.push(num);
            }

        }

        // 마지막 비우기
        while(!stack.empty() && stack.peek() == cur + 1){
            cur = stack.pop();
        }


        if(!stack.empty()) isSuccess = false;

        if(isSuccess){
            bw.write("Nice");
        }else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        return;
    }


}
