import java.util.Scanner;

/* LIS : 가장 긴 증가하는 수열
*  왼쪽에서의 LIS와 오른쪽에서의 LIS를 더한 값이
*  가장 크면 그 숫자를 기준으로 가장 긴 바이토닉수열이다
*    -> 오른쪽에서 가장 길고, 왼쪽에서도 가장 길다 */

public class Main {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dp[][] = new int[2][n+1];
        int[] cost = new int[n+1];


        for(int i=1;i<=n;i++) {
            cost[i] = sc.nextInt();
        }

        dp[1][n] = 1; // 오른쪽에서 시작하는 LIS -> LDS
        dp[0][1] = 1; // 왼쪽에서 시작하는 LIS

        for(int i=n-1;i>0;i--) { // 오른쪽에서 시작하는 LIS
            dp[1][i] =1;
            for(int j=n;j>i;j--) {
                if(cost[i]>cost[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[1][j]+1);
                }
            }
        }

        for(int i=2;i<=n;i++) { // 왼쪽에서 시작하는 LIS
            dp[0][i] =1;
            for(int j=1;j<i;j++) {
                if(cost[i]>cost[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j]+1);
                }
            }
        }
        int max = 0;
        // 왼쪽에서의 LIS와 오른쪽에서의 LIS를 더한 값이
        // 가장 크면 그 숫자를 기준으로 가장 긴 바이토닉수열이다
        for(int i=1;i<=n;i++) {
            dp[0][i] += dp[1][i];

        }

        // 더한 값의 최대값을 찾는다
        for(int i=1;i<=n;i++) {
            max = Math.max(dp[0][i],max);
        }

        System.out.println(max-1);




    }
}
