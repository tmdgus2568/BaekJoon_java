import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 상 하 좌 우 중
    static int[] go_y = {-1, 1, 0, 0};
    static int[] go_x = {0, 0, -1, 1};
    static char[][] before_map;
    static int r;
    static int c;
    static int t;

    static int max_result = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int start_y = -1;
        int start_x = -1;

        before_map = new char[r][c];

        for(int i=0;i<r;i++){
            String s = br.readLine();
            for(int j=0;j<c;j++){
                before_map[i][j] = s.charAt(j);
                if(s.charAt(j) == 'G'){
                    start_y = i;
                    start_x = j;
                }
            }
        }
        checkFunc(before_map, start_y, start_x, 0, 0);

        System.out.println(max_result);



    }

    static void checkFunc(char[][] map, int start_y, int start_x, int result, int t_cnt){

        if(t_cnt > t-1) {
            max_result = Math.max(result, max_result);
            return;
        }

        // 가능한지 확인후 가능하면 감?
        for(int i=0;i<4;i++){
            if((start_y+go_y[i] >= 0 && start_y+go_y[i] <= r-1
                    && start_x+go_x[i] >= 0 && start_x+go_x[i] <= c-1)
                    && map[start_y+go_y[i]][start_x+go_x[i]] != '#'){


                // 고구마라면 +1
                if(map[start_y+go_y[i]][start_x+go_x[i]] == 'S') {
                    char[][] map_clone = new char[r][c];
                    for (int j=0;j<r;j++){
                        for(int k=0;k<c;k++){
                            map_clone[j][k] = map[j][k];
                        }
                    }
//                    System.out.println((start_y+go_y[i]) + ", " + (start_x+go_x[i]) + ", " + map[start_y+go_y[i]][start_x+go_x[i]]);
//                    System.out.println("result: "+(result+1));
                    map_clone[start_y+go_y[i]][start_x+go_x[i]] = '.';
                    checkFunc(map_clone, start_y+go_y[i], start_x+go_x[i], result+1, t_cnt+1);
                }
                else checkFunc(map, start_y+go_y[i], start_x+go_x[i], result, t_cnt+1);


            }
        }
    }

}
