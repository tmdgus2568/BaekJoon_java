import java.util.Scanner;

/* LIS(Longest Increasing Subsequence) : 최장 증가 수열
*   -> 가장 긴 증가하는 수열
*  */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[1001];
        int dp[] = new int[1001];
        for(int i=1;i<=N;i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=1;i<=N;i++) {
            // 우선 default 값을 넣고
            dp[i] = 1;
            // 지금 값보다 작고 이전에 더 큰값이 있었다면 그 중 가장 큰 값에
            // 1을 더한 값을 넣는다.
            for(int j=1;j<=i;j++) {
                if(arr[i]>arr[j] && dp[i]<=dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max_ans = 0;
        for(int i=1;i<=N;i++) {
            max_ans = Math.max(max_ans, dp[i]);
        }
        System.out.println(max_ans);
    }
}
