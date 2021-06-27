import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] inputs;
    static int n,k;
    static int max = Integer.MIN_VALUE;
    static int[][] dp;

    // 이러면 에러 시간초과 !!
    static void dfs(int bp, int w, int v){
        // bp가 n-1일때(다음 확인할게 없을 떄) 멈춤
        if(bp == n){
            if(w+inputs[bp][0] <= k) max = Math.max(max, v+inputs[bp][1]);
            else max = Math.max(max, v);

            return;
        }
        // k를 넘어간다면 더이상 볼 필요가 없음(k를 넘어가지 않는 경우만 확인하자)
        if(w+inputs[bp][0] <= k){
            // bp번째 배낭을 포함하는 경우
            dfs(bp+1, w+inputs[bp][0], v+inputs[bp][1]);
        }

        // bp번째 배낭을 포함하지 않는 경우
        dfs(bp+1, w, v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        inputs = new int[n+1][2];
        dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){

            for(int j=1;j<=k;j++){
                // 어떤 무게일 때, 최대 가치를 넣어줌.
                // i-1 번째 아이템의 경우 최대였던 가치값을 우선 넣어줌.
                dp[i][j] = dp[i-1][j];

                // 만약에 새로 추가할 아이템의 무게가 가방의 버틸 수 있는 무게를 넘지 않을 경우
                // (새로 추가할 아이템이 가방에 들어갈 수 있는 무게인 경우)
                // (i-1)번째 아이템까지 봤을 떄, 가방이 버틸 수 있는 무게가 (j-inputs[i][0]) 일때의 최대값(dp에 저장되어 있음)
                // 에 현재 넣을 아이템의 가치를 더한 것과
                // 아이템을 새로 넣지 않았을 때의 가치의 최대를 구함
                if(j >= inputs[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-inputs[i][0]]+inputs[i][1]);
                }

            }
        }
        System.out.println(dp[n][k]);

    }
}
