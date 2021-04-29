import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        int min_diff = Integer.MAX_VALUE;
        int min = 0;
        for(int a=0;a<n;a++){
            for(int b=0;b<n;b++){
                for(int c=0;c<n;c++){
                    if(a != b && b!=c && a!= c){
                        int sum = (inputs[a] + inputs[b] + inputs[c]);
                        int diff =  m-sum;
                        if(diff >= 0 && diff < min_diff){
                            min_diff = diff;
                            min = sum;
                        }
                    }

                }
            }
        }
        System.out.println(min);

    }
}
