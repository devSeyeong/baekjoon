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

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    int num = board[i][j];
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        dfs(0);

//        bw.write(count+"");
        bw.flush();
        bw.close();
    }


    static int[][] board = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static List<int[]> blanks = new ArrayList<>();


    static void dfs(int idx) {
        if (idx == blanks.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }


        int r = blanks.get(idx)[0];
        int c = blanks.get(idx)[1];
        int b = (r / 3) * 3 + (c / 3);

        for (int i = 1; i <= 9; i++) {
            if (!row[r][i] && !col[c][i] && !box[b][i]) {
                board[r][c] = i;
                row[r][i] =  col[c][i] = box[b][i] = true;

                dfs(idx + 1);

                board[r][c] = 0;
                row[r][i] =  col[c][i] = box[b][i] = false;
            }
        }
    }


}
