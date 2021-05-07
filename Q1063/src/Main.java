

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] R = {0,1};
    static int[] L = {0,-1};
    static int[] B = {-1,0};
    static int[] T = {1,0};
    static int k_x;
    static int k_y;
    static int d_x;
    static int d_y;
    static int[] king_p;
    static int[] doll_p;

    static void change(){
        if((k_x <= 8 && k_x >= 1 && k_y <= 8 && k_y >= 1)){
            if(k_x == doll_p[1] && k_y == doll_p[0]){
                if(!(d_x <= 8 && d_x >= 1 && d_y <= 8 && d_y >= 1)) return;

                doll_p[1] = d_x;
                doll_p[0] = d_y;
            }
            king_p[1] = k_x;
            king_p[0] = k_y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String doll = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        // 킹과 돌을 좌표화 (0번째 : y, 1번째 : x)
        king_p = new int[]{king.charAt(1) - 48,king.charAt(0) - 64};
        doll_p = new int[]{doll.charAt(1) - 48,doll.charAt(0) - 64};

        for(int i=0;i<n;i++){
            String input = br.readLine();
            k_x = 0;
            k_y = 0;
            d_x = 0;
            d_y = 0;
            switch (input){
                case "R":
                    k_x = king_p[1]+R[1];
                    k_y = king_p[0]+R[0];
                    d_x = doll_p[1]+R[1];
                    d_y = doll_p[0]+R[0];
                    break;
                case "L":
                    k_x = king_p[1]+L[1];
                    k_y = king_p[0]+L[0];
                    d_x = doll_p[1]+L[1];
                    d_y = doll_p[0]+L[0];
                    break;
                case "B":
                    k_x = king_p[1]+B[1];
                    k_y = king_p[0]+B[0];
                    d_x = doll_p[1]+B[1];
                    d_y = doll_p[0]+B[0];
                    change();
                    break;
                case "T":
                    k_x = king_p[1]+T[1];
                    k_y = king_p[0]+T[0];
                    d_x = doll_p[1]+T[1];
                    d_y = doll_p[0]+T[0];
                    break;
                case "RB":
                    k_x = king_p[1]+R[1]+B[1];
                    k_y = king_p[0]+R[0]+B[0];
                    d_x = doll_p[1]+R[1]+B[1];
                    d_y = doll_p[0]+R[0]+B[0];
                    break;
                case "RT":
                    k_x = king_p[1]+R[1]+T[1];
                    k_y = king_p[0]+R[0]+T[0];
                    d_x = doll_p[1]+R[1]+T[1];
                    d_y = doll_p[0]+R[0]+T[0];
                    break;
                case "LB":
                    k_x = king_p[1]+L[1]+B[1];
                    k_y = king_p[0]+L[0]+B[0];
                    d_x = doll_p[1]+L[1]+B[1];
                    d_y = doll_p[0]+L[0]+B[0];
                    break;
                case "LT":
                    k_x = king_p[1]+L[1]+T[1];
                    k_y = king_p[0]+L[0]+T[0];
                    d_x = doll_p[1]+L[1]+T[1];
                    d_y = doll_p[0]+L[0]+T[0];
                    break;
            }
            change();
        }
        king = String.valueOf((char)(king_p[1]+64))+String.valueOf((char)(king_p[0]+48));
        doll = String.valueOf((char)(doll_p[1]+64))+String.valueOf((char)(doll_p[0]+48));
        System.out.println(king);
        System.out.println(doll);

    }
}
