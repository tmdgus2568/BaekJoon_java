import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // j == 0 : N번째 줄에 사자가 한마리도 없을 때
        // j == 1 : N번째 줄에 사자가 오른쪽에 한마리 있을 때
        // j == 2 : N번째 줄에 사자가 왼쪽에 한마리 있을 때
        int[][] dp = new int[N+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i=2;i<=N;i++){
            // 맨 밑줄에 아무것도 없을때는 상관없음
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
            // 맨 밑줄에 왼쪽에 있을때는 그 위에 왼쪽이 올 수 없음
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            // 맨 밑줄에 오른쪽에 있을때는 그 위에 오른쪽이 올 수 없음
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2])%9901);



    }
}
