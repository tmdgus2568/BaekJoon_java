import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n][n];
        inputs = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) dp[i][j] = -1;
        }
        for(int i=0;i<n;i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                search(i,j);
            }
        }
        System.out.println(dp[0][n-1]);

    }

    static int search(int a, int b){
        if(dp[a][b] != -1) return dp[a][b];
        if(a >= b){
            dp[a][b] = 0;
            return dp[a][b];
        }
        if(inputs[a] == inputs[b]){
            dp[a][b] = search(a+1,b-1);
            return dp[a][b];
        }
        dp[a][b] = Math.min(search(a+1,b), search(a,b-1)) + 1;
        return dp[a][b];

    }
}
