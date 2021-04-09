import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 트리인지 아닌지 확인하려면
*  간선(edge)의 개수 == 정점(vertex)의 개수 - 1 인지 확인하면 된다.(루프있는지 없는지 확인 할 필요 없음)
*  노드 1개의 경우도 간선의 개수는 0, 정점의 개수는 1로 0 == 1-1 이므로 트리이다.
*  따라서 모든 노드를 확인 해야 한다. */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int case_cnt = 0;
        while(true){
            case_cnt++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<Integer>[] inputs = new LinkedList[n+1];
            for(int i=1;i<n+1;i++){
                inputs[i] = new LinkedList<>();
            }

            if(n==0 && m==0){
                System.out.print(sb);
                break;
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int v0 = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());
                inputs[v0].add(v1);
                inputs[v1].add(v0);
            }
            int trees = 0;
            int vertex = 0; // 정점 개수
            int edge = 0; // 간선 개수
            Queue<Integer> q = new LinkedList<>();
            int[] isVisited = new int[n+1];
            for(int i=1;i<=n;i++){
                if(isVisited[i] == 0){
                    isVisited[i] = 1;
                    q.add(i);
                    vertex++;
                    while (!q.isEmpty()){
                        int curr = q.poll();
                        for(Integer checkV:inputs[curr]){
                            edge++;
                            if(isVisited[checkV] == 0){
                                isVisited[checkV] = 1;
                                q.add(checkV);
                                vertex++;
                            }
                        }
                    }

                    if(vertex-1 == edge/2){
                        trees++;
                    }

                }
                vertex = 0;
                edge = 0;

            }
            if(trees == 1){
                System.out.printf("Case %d: There is one tree.\n",case_cnt);
            }
            else if(trees == 0){
                System.out.printf("Case %d: No trees.\n",case_cnt);
            }
            else {
                System.out.printf("Case %d: A forest of %d trees.\n",case_cnt,trees);

            }
            trees = 0;

        }
    }
}
