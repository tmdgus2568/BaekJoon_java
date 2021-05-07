import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final char[][] white = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static final char[][] black = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };
    public static void main(String[] args) throws IOException {
        int black_sum = 0;
        int white_sum = 0;
        int min = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] inputs = new char[n+1][m+1];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                inputs[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            if(i+7 >= n) continue;
            for(int j=0;j<m;j++){
                if(j+7 >= m) continue;
                for(int a=0;a<8;a++){
                    for(int b=0;b<8;b++){
                        if(black[a][b] != inputs[i+a][j+b]){
                            black_sum++;
                        }
                        if(white[a][b] != inputs[i+a][j+b]){
                            white_sum++;
                        }
                    }
                }
                if(black_sum <= white_sum){
                    min = Math.min(min,black_sum);
                }
                else{
                    min = Math.min(min,white_sum);
                }
                black_sum = 0;
                white_sum = 0;
            }
        }
        System.out.println(min);

    }
}
