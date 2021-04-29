import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = 0;
        for(int i=1;i<=n;i++){
            String str_i = String.valueOf(i);
            int i_len = str_i.length();
            int sum = i;
            for(int j=0;j<i_len;j++){
                sum += Integer.parseInt(String.valueOf(str_i.charAt(j)));
            }
            if(sum == n){
                if(min == 0){
                    min = i;
                }
                else{
                    min = Math.min(min, i);
                }

            }
        }
        System.out.println(min);

    }
}
