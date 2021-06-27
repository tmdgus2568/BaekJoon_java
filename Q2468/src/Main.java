import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] inputs;
    static int[][] ischecked;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int sum = 0;
    static int n;
    static void search(int num, int x, int y){
        ischecked[x][y] = 1;
        for(int i=0;i<4;i++){
            int next_x = x+dx[i];
            int next_y = y+dy[i];
            if(next_x >= 0 && next_y >= 0 && next_x <= n-1 && next_y <= n-1){
                if(inputs[next_x][next_y] > num && ischecked[next_x][next_y] == 0){
                    search(num, next_x, next_y);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inputs = new int[n][n];
        ischecked = new int[n][n];
        StringTokenizer st;

        int max_h = 0;
        int max_area = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){

                int num = Integer.parseInt(st.nextToken());
                max_h = Math.max(max_h, num);
                inputs[i][j] = num;
            }
        }
       
        for(int h=0;h<=max_h;h++){
            int area = 0;
            ischecked = new int[n][n];
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(inputs[x][y] > h && ischecked[x][y] == 0){
                        search(h,x,y);
                        area++;

                    }

                }
            }
            max_area = Math.max(max_area, area);
        }
        System.out.println(max_area);

    }
}
