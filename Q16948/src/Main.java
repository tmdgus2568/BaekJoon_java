import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-2,-2,0,0,2,2};
    static int[] dc = {-1,1,-2,2,-1,1};
    static int n;
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int[][] map;
    static int min_d = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1,c1,0});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int now_r = now[0];
            int now_c = now[1];
            int now_d = now[2];


            if(now_r==r2 && now_c==c2){
                min_d = Math.min(min_d, now_d);
                continue;
            }

            for(int i=0;i<6;i++){
                if(now_r+dr[i] >= 0 && now_r+dr[i] < n
                        && now_c+dc[i] >= 0 && now_c+dc[i] < n
                        && map[now_r+dr[i]][now_c+dc[i]] == 0){
                    map[now_r+dr[i]][now_c+dc[i]] = 1;
                    q.add(new int[]{now_r+dr[i], now_c+dc[i], now_d+1});
                }
            }
        }

        if (min_d == Integer.MAX_VALUE) min_d = -1;
        System.out.println(min_d);

    }

}
