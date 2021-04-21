import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 파라 메트릭 서치 알고리즘 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] inputs = new int[n];
        for(int i=0;i<n;i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputs);
        // 몇 간격을 기준으로 할 것인가
        int left = 1; // 최소 간격은 1
        int right = (inputs[n-1]-inputs[0]); // 최대 간격
        int mid;

        while(left <= right){
            mid = (left+right)/2;
            int start = inputs[0];
            int cnt = 1;
            for(int i=1;i<n;i++){
               if(mid <= inputs[i]-start){
                   cnt ++;
                   start = inputs[i];
               }
            }
            // 센 공유기의 개수가 정해진 공유기의 개수보다 작다면
            // 간격을 더 줄여서 개수를 늘려야 함
            if(cnt < c){
                right = mid-1;
            }

            // 센 공유기의 개수가 정해진 공유기의 개수보다 크면
            // 간격을 더 줄여서 개수를 줄여야함
            // 최대를 구하는 거니까 cnt==c인 경우도 아래와 같다
            else{
                left = mid+1;
            }
        }
        System.out.println(right);
    }
}
