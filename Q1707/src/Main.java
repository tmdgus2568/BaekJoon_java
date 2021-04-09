
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 이분 그래프 : 서로 인접하지 않는 두개의 그래프로 나눌 수 있을 때
*   -> 인접한 정점끼리 서로 다른 색으로 칠해서 모든 정점을 두가지 색으로만 칠할 수 있는 그래프
*
*  예를 들어, 빨간색과 파란색으로 노드를 칠할 수 있을 때
*  인접한 노드 끼리는 다른 색으로 칠할 수 있는 그래프를 말한다.
*
*  모든 노드를 확인해야 하므로 첫번째 노드부터 마지막 노드까지 전부 탐색한다.
*
*  ------------- 주의 -------------
*  for(int i=0;i<arr.size();i++) 는 매번 size를 계산하기 때문에 시간초과가 날 수 있으므로
*  for(int num:arr) (foreach문)을 이용하도록 하자 !!!!! */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<K;k++){

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] isVisited = new int[V+1];
            Queue<Integer> q = new LinkedList<>();
            LinkedList<Integer>[] inputs = new LinkedList[V+1];

            // LinkedList 배열로 이루어져 있으면
            // 배열의 모든 원소의 선언 필요
            for (int i=1;i<V+1;i++) {
                inputs[i] = new LinkedList<>();
            }
            for(int e=0;e<E;e++){
                st = new StringTokenizer(br.readLine());
                int v0 = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());

                inputs[v0].add(v1);
                inputs[v1].add(v0);

            }

            boolean success = true;
            for(int i=1;i<=V;i++){
                if(isVisited[i] == 0){
                    q.add(i);
                    isVisited[i] = 1;
                    while(!q.isEmpty() && success){
                        int curr = q.poll();

                        // 그 노드와 연결되어있는 모든 노드 탐색 (이미 했으면 건너뛰고..)
                        for(Integer checkV: inputs[curr]){
//                            int checkV = inputs[curr].get(j);
                            if(isVisited[checkV] == 0){
                                q.add(checkV);
                                isVisited[checkV] = isVisited[curr]*(-1);
                            }

                            // 같은 색으로 칠해져 있으면 false
                            else if(isVisited[checkV] == isVisited[curr]){
                                success = false;
                                break;
                            }
                        }
                    }
                }

            }
            if(success) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }
        System.out.print(sb);

    }
}
