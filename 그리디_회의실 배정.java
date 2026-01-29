import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;


public class Main {
    static class Meeting {
        int start;
        int end;

        Meeting (int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Meeting[] meetings = new Meeting[N];

        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a.end == b.end){
                return a.start - b.start;
            } return a.end - b.end;
        });


        int count = 0;
        int lastEnd = 0;

        for(Meeting m : meetings){
            if(m.start >= lastEnd){
                count ++;
                lastEnd = m.end;
            }
        }
        bw.write(count+ " ");

        bw.flush();
        bw.close();

    }

}
