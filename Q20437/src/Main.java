import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 3 : 어떤문자 시작, 끝이고 K개 들어있는 것 중 가장 짧은 것
        // 4 : 어떤문자 시작, 끝이고 K개 들어있는 것 중 가장 긴 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int W_len = W.length();

            // 최소 찾기
            int answer_3 = Integer.MAX_VALUE;
            // 최대 찾기
            int answer_4 = Integer.MIN_VALUE;

            ArrayList<Integer>[] alpha_save = new ArrayList[26];

            for (int j=0;j<26;j++){
                alpha_save[j] = new ArrayList<>();
            }

            for(int j=0;j<W_len;j++){
                // 알파벳의 index 저장
                alpha_save[W.charAt(j)-97].add(j);
            }

            for(int x=0;x<26;x++){
                int alpha_len = alpha_save[x].size();
                for(int y=0;y<=alpha_len-K;y++){
                    int size = alpha_save[x].get(y+K-1) - alpha_save[x].get(y) + 1;
                    answer_3 = Math.min(answer_3, size);
                    answer_4 = Math.max(answer_4, size);
                }
            }

            if(answer_3 != Integer.MAX_VALUE && answer_4 != Integer.MIN_VALUE){
                sb.append(answer_3).append(" ");
                sb.append(answer_4).append("\n");
            }
            else{
                sb.append("-1").append("\n");
            }

        }

        System.out.print(sb);

    }
}
