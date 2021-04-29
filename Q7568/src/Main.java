import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] inputs = new int[50][2];
        int[] size = new int[50];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(inputs[i][0] < inputs[j][0] && inputs[i][1] < inputs[j][1]){
                    size[i]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            sb.append(size[i]+1).append(" ");
        }
        System.out.println(sb);

    }
}
