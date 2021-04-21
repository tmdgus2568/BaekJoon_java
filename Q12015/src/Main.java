import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> inputs = new ArrayList<>();
        inputs.add(0);

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(inputs.get(inputs.size()-1) < num){
                inputs.add(num);
            }
            else{
                int left = 0;
                int right = inputs.size()-1;
                int ans = 0;
                while(left <= right){
                    int mid = (left+right)/2;
                    if(inputs.get(mid) >= num){
                        right = mid-1;
                        ans = mid;

                    }
                    else{
                        left = mid+1;
                        ans = mid;


                    }
                }
                inputs.set(ans, num);

            }
        }
        System.out.println(inputs.size()-1);

    }
}
