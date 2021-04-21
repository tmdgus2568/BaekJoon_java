import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            inputs[i] = Integer.parseInt(st.nextToken());

        }
        int num = Integer.parseInt(br.readLine());
        Arrays.sort(inputs);

        int left = 0;
        int right = inputs[n-1];
        int mid;
        int sum;
        while(left <= right){
            mid = (left+right)/2;
            sum = 0;
            for(int i=0;i<n;i++){
                if(inputs[i] > mid) sum += mid;
                else sum += inputs[i];
            }
//            System.out.println(sum);
            if(num >= sum){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(right);

    }
}
