
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

  /* Q3584 '가장 가까운 공통조상' 문제와 비슷
  *  공통된 조상을 찾은 뒤, 그 중 가장 가까운 노드를 찾는다.  */

public class Main {

    // 각 자식들에 부모를 저장한다 (한 자식노드의 부모는 무조건 한개 )
    static int[] c_to_p = new int[101];
    static int node1;
    static int node2;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        node1 = Integer.parseInt(st.nextToken());
        node2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int child;
        int parent;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());


            c_to_p[child] = parent;

        }


        LinkedList<int[]> parents1 = new LinkedList<>();
        LinkedList<int[]> parents2 = new LinkedList<>();

        int p = node1;
        int cnt1 = 0;
        parents1.add(new int[]{node1,0});

        // 주어진 node1의 부모, 그 부모의 부모... 를 모두 저장한다.
        while(c_to_p[p] != 0){
            cnt1++;
            parents1.add(new int[]{c_to_p[p],cnt1});
            p = c_to_p[p];
        }

        p = node2;
        int cnt2 = 0;
        parents2.add(new int[]{node2,0});

        // 주어진 node2의 부모, 그 부모의 부모... 를 모두 저장한다.
        while(c_to_p[p] != 0){
            cnt2++;
            parents2.add(new int[]{c_to_p[p],cnt2});
            p = c_to_p[p];
        }

        int same_p = 0;
        int min_len = Integer.MAX_VALUE;
        int size1 = parents1.size();
        int size2 = parents2.size();
        int p1;
        int p2;
        int p1_len = 0;
        int p2_len = 0;

        // 두 노드의 부모들을 모아놓은 배열을 탐색하면서
        // 가장 가까운 부모노드를 찾는다. (부모와 자식 사이의 길이는 함께 저장되어 있음)
        for(int i=0;i<size1;i++){
            for(int j=0;j<size2;j++){
                p1 = parents1.get(i)[0];
                p2 = parents2.get(j)[0];
                if(p1 == p2){
                    if(min_len > Math.abs(i-j)){
                        min_len = Math.abs(i-j);
                        same_p = p1;
                        p1_len = parents1.get(i)[1];
                        p2_len = parents2.get(j)[1];
                    }
                }
            }
        }
        if(same_p == 0){
            System.out.println("-1");
        }
        else{
            System.out.println(p1_len+p2_len);
        }



    }
}
