import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* stack, queue 사용 시 메모리를 많이 사용하게 될 것임
*  -> 재귀 이용  */

public class Main {
    static LinkedList<int[]>[] inputs = new LinkedList[10001];
    static int max = 0;


    public static int searchLong(int idx) {
        int max_1 = 0;
        int max_2 = 0;
        int size = inputs[idx].size();
        for (int i=0;i<size;i++) {
            int[] item = inputs[idx].get(i);
            int result = searchLong(item[0])+item[1];
            if(result > max_1){
                max_2 = max_1;
                max_1 = result;
            }else if( result > max_2){
                max_2 = result;
            }

        }
        max = Math.max((max_1+max_2), max);
        return max_1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;

        for(int i=1;i<n+1;i++){
            inputs[i] = new LinkedList<>();
        }
        int parent;
        int child;
        int weight;
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            inputs[parent].add(new int[]{child, weight});

        }
        searchLong(1);
        System.out.println(max);

    }
}
