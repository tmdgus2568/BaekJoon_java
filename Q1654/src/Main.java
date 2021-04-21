import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] inputs = new int[k];

        for(int i=0;i<k;i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs);

        long sum;
        long left = 1;
        long right = inputs[k-1];
        long mid;

        while(left <= right){
            sum = 0;
            // 더하는 과정에서 int의 범위를 넘으므로 잘못된 결과가 나올 수 있음
            mid = (left+right)/2;
//            System.out.println(mid);

            for(int i=0;i<k;i++){
                sum += inputs[i]/mid;
            }

            if(sum >= n){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(right);

    }
}
