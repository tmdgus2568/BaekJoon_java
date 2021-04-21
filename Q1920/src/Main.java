import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 자바의 sort 시간복잡도 : O(nlog n) =  500,000
*  이분탐색 시간복잡도 : O(log n) = 5 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        boolean result = false;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            int left = 1;
            int right = n;
            int num = Integer.parseInt(st.nextToken());
            while(left <= right){
                int mid = (left+right)/2;


                if(num < A[mid]){
                    right = mid-1;
                }
                else if(num > A[mid]){
                    left = mid+1;
                }
                else{

                    result = true;
                    break;
                }

            }
            if(result) sb.append("1").append('\n');
            else sb.append("0").append('\n');
            result = false;
        }
        System.out.print(sb);
    }
}
