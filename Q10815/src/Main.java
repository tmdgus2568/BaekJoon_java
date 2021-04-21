import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.LinkPermission;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] inputs = new int[n];
        for(int i=0;i<n;i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(inputs);
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n-1;
            int mid ;

            boolean result = false;
            while(left <= right){
                mid = (left+right)/2;
                if(inputs[mid] < num){
                    left = mid+1;
                }
                else if(inputs[mid] > num){
                    right = mid-1;
                }
                else{
                    result = true;
                    break;

                }
            }
            if(result) sb.append("1 ");
            else sb.append("0 ");

        }
        System.out.println(sb);
    }
}
