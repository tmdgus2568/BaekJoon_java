import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        String result = "NOT POSSIBLE";

        StringBuilder sb = new StringBuilder();

        if(N % 2 == 1){
            int char_cnt = 0;
            int l_idx = 0;
            int r_idx = N/2;

            while (r_idx < N && l_idx < N/2){
                if(char_cnt == 2){
                    break;
                }
                if(S.charAt(l_idx) != S.charAt(r_idx)){
                    char_cnt++;
                    r_idx++;
                }
                else{
                    sb.append(S.charAt(l_idx));
                    l_idx++;
                    r_idx++;
                }
            }
            if(sb.length() == N/2){
                result = sb.toString();
//                System.out.println("result1: "+ result);
            }

            // 초기화
            sb = new StringBuilder();

            char_cnt = 0;
            l_idx = 0;
            r_idx = N/2+1;

            while (r_idx < N && l_idx < N/2+1){
                if(char_cnt == 2){
                    break;
                }
                if(S.charAt(l_idx) != S.charAt(r_idx)){
                    char_cnt++;
                    l_idx++;
                }
                else{
                    sb.append(S.charAt(l_idx));
                    l_idx++;
                    r_idx++;
                }
            }

            
            if(sb.length() == N/2){
                if(!result.equals(sb.toString()) && result.length()==N/2)
                    result = "NOT UNIQUE";
                else result = sb.toString();
//                System.out.println("result2: "+ result);


            }
        }
        System.out.println(result);

    }
}
