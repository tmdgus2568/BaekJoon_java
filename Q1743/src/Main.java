import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int max = 0;
    static int sum = 0;
    static int[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        check = new int[n+1][m+1];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int py = Integer.parseInt(st.nextToken());
            int px = Integer.parseInt(st.nextToken());

            arr[py][px] = 1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i][j] == 1 && check[i][j] == 0){
                    sum = 1;
                    check[i][j] = 1;
                    search(j,i);
                    max = Math.max(max, sum);
                }
            }

        }
        System.out.println(max);

    }

    static void search(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int next_x = dx[i] + x;
            int next_y = dy[i] + y;
            if (next_x >= 1 && next_x <= m && next_y >= 1 && next_y <= n && check[next_y][next_x] == 0 && arr[next_y][next_x] == 1) {
                check[next_y][next_x] = 1;
                sum++;
                search(next_x, next_y);

            }
        }
    }
}
