import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 이분탐색 : O(log n) = 6
*  안에 전체 탐색 : O(n) = 1,000,000 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inputs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);

        // 모든 나무의 길이가 같은 경우도 있으므로
        // left는 나무의 길이가 최소의 경우인 1로 (input[0] X)
        int left = 1;
        int right = inputs[n-1];
        int mid ;
        long sum ;

        while(left <= right){
            mid = (left+right)/2;
            sum = 0;
            for(int i=0;i<n;i++){
                if(inputs[i] > mid){
                    sum += inputs[i]-mid;
                }
            }
            if(sum >= m){

                left = mid+1;

            }
            else if(sum < m){
                right = mid-1;

            }


        }
        System.out.println(right);
    }
}
