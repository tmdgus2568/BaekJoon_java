import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 트리의 지름 찾기 문제
*
* i) 가장 긴 길이를 갖고있는 정점을 구한다.
* ii) 가장 긴 길이의 정점을 기준으로 다시 거리를 측정한다.
* iii) 거리를 저장한 배열 중 최대값이 트리의 지름이다.
*
* 아무노드에서 시작해도 상관 없음 */

public class Main {
    static ArrayList<int[]>[] inputs;
    static int[] ischecked;
    static int max_sum = 0;
    static int max = 0;
    static int long_node = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        ischecked = new int[V+1];
        inputs = new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            inputs[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            while(true){
                int v2 = Integer.parseInt(st.nextToken());
                if(v2 == -1) break;
                int v_len = Integer.parseInt(st.nextToken());
                inputs[v1].add(new int[]{v2,v_len});
            }
        }
        dfs(1,0);
        max_sum = 0;
        ischecked = new int[V+1];
        dfs(long_node, 0);

        max = Math.max(max_sum, max);
        System.out.println(max);


    }
    public static void dfs(int idx, int sum){
        ArrayList<int[]> curr = (ArrayList<int[]>) inputs[idx];
        ischecked[idx] = 1;
        for(int[] next:curr){
            if(ischecked[next[0]] == 1){
                if(max_sum <= sum){
                    max_sum = sum;
                    long_node = idx;
                }
                continue;
            }
            dfs(next[0],sum+next[1]);
        }
    }
}
