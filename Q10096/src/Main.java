import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result = "NOT POSSIBLE";

        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        // 문자열 T를 구한다.
        // 문자열 T는 2S + 임의의문자하나 로 구성되어있다.
        int check[] = new int[26];
        char[] S_arr = S.toCharArray();

        for(char c : S_arr){
            check[c-65] += 1;
        }

        // 요런식으로 알파벳 저장함
        // System.out.println(Arrays.toString(check));
        int search_c_idx = -1;
        if(S.length()%2 == 1){
            for(int i=0;i<26;i++){
                if(check[i]%2==1){ // 홀수이면
                    // 근데 홀수가 여러개면 갱신 못하게 -1 하고
                    if(search_c_idx != -1){
//                    System.out.println(search_c_idx);
                        search_c_idx = -1;

                        break;
                    }
                    search_c_idx = i;
                }
            }
        }
        int cnt = 0;

        if(search_c_idx == -1){
            result = "NOT POSSIBLE";
        }else {
            // 그담은 그 어저내가 말한거처럼 그 홀수문자 하나 저장하고
            char search_c = (char) (search_c_idx+65);
            for(int i=0;i<S_arr.length;i++){ // 그래서 ABXCABC에서 처음부터 char 포문 돌면서 문자하나하나 봄
                // X를 만났으면 그 X를 제거하고 반반 쪼갠다음에 똑같으면 cnt++
               if (S_arr[i] == search_c){
                   StringBuilder sb = new StringBuilder(S);
                   sb.deleteCharAt(i);
//                   System.out.println("S: "+S);
                   if(sb.substring(0,sb.length()/2).equals(sb.substring(sb.length()/2,sb.length()))){
                       if(cnt >= 1){
                           if(!result.equals(sb.substring(0,sb.length()/2))){
                               result = "NOT UNIQUE";
                               break;
                           }

                       }
                       cnt++;
                       result = sb.substring(0,sb.length()/2);
                   }

               }
            }
        }


        System.out.println(result);
    }

}
