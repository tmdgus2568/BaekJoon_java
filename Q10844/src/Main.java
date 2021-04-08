import java.util.Scanner;

/* k==1 : 9
*  k->k+1 :
*   i) 길이가 k인 계단 수의 마지막 자리수가 1일때만 0을 만들 수 있음
*   ii) 길이가 k인 계단 수의 마지막 자리수가 8일때만 9를 만들 수 있음
*   iii) 2는 1과 3으로,
*       3은 2와 4로,
*       4는 3과 5로 ... 만들 수 있으므로
*       2~7은 -1,+1 한 경우를 더해서 만들 수 있음 */


public class Main {
    final static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[][] = new long[N+1][10];

        // 길이가 1인 경우
        for(int i=1;i<10;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<=N;i++) {
            for(int j=0;j<10;j++) {
                // i)
                if(j==0) {
                    dp[i][0] = dp[i-1][1]%mod;
                }
                
                // ii)
                else if(j==9) {
                    dp[i][9] = dp[i-1][8]%mod;
                }

                // iii)
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
                }
            }
        }
        long ans = 0;
        for(int i=0;i<10;i++) {
            ans += dp[N][i];
        }
        System.out.println(ans%mod);
    }
}
