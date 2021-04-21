

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Node>[] inputs;
    static int[] ischecked;
    static Queue<Integer> q;
    static int n;
    static int next;

    /* 일단 bfs로 시작 노드와 끝 노드의 중량제한의 최소를 구한 뒤
    *  그들 중 최대를 구함  */

    static class Node {
        int node;
        int weight;
        Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getNode() {
            return node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b, c;


        inputs = new LinkedList[n+1];
        q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            inputs[i] = new LinkedList<>();
        }
        ischecked = new int[n+1];
        int max = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            // 입력 받으면서 weight의 최대를 찾자 !
            max = Math.max(max, c);

            inputs[a].add(new Node(b,c));
            inputs[b].add(new Node(a,c));


        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = max;
        int mid;
        int ans = 0;

        while(left <= right){
            mid = (left+right)/2;
            // A -> B로 가되, 중량의 최소가 mid값인 경로가 존재한다면
            // 최소중에 최대를 찾아야 하므로 left = mid+1로 갱신
            if(bfs(A, B, mid)){
                left = mid+1;
                ans = Math.max(ans, mid);
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(ans);



    }

    static boolean bfs(int A, int B, long w){

        q.clear();
        for(int i=1;i<=n;i++){
            ischecked[i] = 0;
        }


        q.add(A);
        while(!q.isEmpty()){
            int curr = q.poll();
//            ischecked[curr] = 1;
            if(curr == B){
                return true;
            }

            for(Node node:inputs[curr]){
                next = node.getNode();

                if(ischecked[next] == 0 && node.getWeight() >= w){
                    q.add(next);
                    ischecked[next] = 1;
                }
            }
        }
        return false;

    }
}
