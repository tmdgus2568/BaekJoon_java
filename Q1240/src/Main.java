import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 다익스트라 알고리즘
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] tree = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 0번째에는 연결된 노드, 1번째에는 길이 저장
            tree[node1].add(new int[]{node2,d});
            tree[node2].add(new int[]{node1,d});

        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] isChecked = new int[N+1];
            int[] dist = new int[N+1];
            LinkedList<Integer> q = new LinkedList<>();
            q.add(start);
            for(int j=1;j<=N;j++){
                dist[j] = Integer.MIN_VALUE;
            }
            boolean isEnd = false;

            while(!q.isEmpty()){

                int curr = q.pollFirst();
                int curr_size = tree[curr].size();

                isChecked[curr] = 1;
                if(dist[curr] == Integer.MIN_VALUE){
                    dist[curr] = 0;
                }


                for(int j=0;j<curr_size;j++){
                    int next = tree[curr].get(j)[0];
                    int next_d = tree[curr].get(j)[1];
                    if(isChecked[next] == 0){
                        dist[next] = dist[curr] + next_d;
                        q.add(next);
                    }
                    if(next == end){
                        isEnd = true;
                        break;
                    }


                }
                if(isEnd){
                    sb.append(dist[end]).append('\n');
                    break;
                }
            }

        }
        System.out.print(sb.toString());

    }


}
