import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 최악의 경우를 고려해야 하는 이분탐색 문제이다.
*  (일일이 탐색하기엔 N이 최대 10만이기 때문에 시간초과 예상)  */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inputs = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }
        long left = max;
        long right = 1000000000;
        int sum;

        // 최악의 경우 10000원이 10만개 있을 때 이므로
        // 최대 right는 10억이기 때문에 long
        while(left <= right){
            long mid = (left+right)/2;
            long cash = 0;
            sum = 0;
            for(int i=0;i<N;i++){
                while(inputs[i] > cash){
                    cash = mid;
                    sum ++;
                }
                cash -= inputs[i];

            }
            if(sum > M){
                left = mid+1;

            }

            // 최소를 찾아야 하므로 같다면 더 작은 값이 있는지 확인해야 함.
            else if(sum <= M){
                right = mid-1;

            }

        }
        System.out.println(left);

    }
}
