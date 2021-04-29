import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 전체 탐색하여 모든 경우를 보려면
*  dfs 이용 !!  */

public class Main {
    static int[] operators;
    static int[] nums;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        dfs(operators[0],operators[1],operators[2],operators[3],1,nums[0] );
        System.out.println(max+"\n"+min);

    }
    static void dfs(int plus, int minus, int mult, int div, int cnt, int sum){
        //연산자를 모두 사용하였을 경우

        if(cnt == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }


        //모든 경우를 탐색

        if (plus > 0)
            dfs(plus-1, minus, mult, div, cnt+1, sum+nums[cnt]);

        if (minus > 0)
            dfs(plus, minus-1, mult, div, cnt+1, sum-nums[cnt]);

        if (mult > 0)
            dfs(plus, minus, mult-1, div, cnt+1, sum*nums[cnt]);

        if (div > 0)
            dfs(plus, minus, mult, div-1, cnt+1, sum/nums[cnt]);

    }
}
