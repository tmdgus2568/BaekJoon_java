
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long D = Integer.parseInt(st.nextToken());
        ArrayList<int[]> inputs = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            inputs.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            min = Math.min(min, inputs.get(i)[0]);
            max = Math.max(max, inputs.get(i)[1]);
        }

        int left = min;
        int right = max;
        long sum = 0;
        int ans = 0;
        while (left <= right){

            sum = 0;
            int mid = (left+right)/2;
            for(int i=0;i<K;i++){
                int min_mid = Math.min(inputs.get(i)[1], mid);
                if(min_mid-inputs.get(i)[0] >= 0){
                    sum += 1+(min_mid-inputs.get(i)[0])/inputs.get(i)[2];
                }

            }
            if(sum < D){
                left = mid+1;

            }
            else{
                right = mid-1;
                ans = mid;

            }


        }
        System.out.println(ans);
    }
}
