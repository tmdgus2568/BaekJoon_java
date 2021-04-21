import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/* HashMap을 사용하여 다시 탐색을 하지 않도록 한다  */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] inputs = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            inputs[i] = num;
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num)+1);
            }

        }
        int m = Integer.parseInt(br.readLine());
        int[] answers = new int[m];
        st = new StringTokenizer(br.readLine());
        Arrays.sort(inputs);

        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n-1;
            int mid;
            while(left <= right){
                mid = (left+right)/2;
                if(inputs[mid] < num){
                    left = mid+1;
                }
                else if(inputs[mid] > num){
                    right = mid-1;
                }
                else{

                    answers[i] = map.get(num);
                    break;

                }

            }
        }
        for(int i=0;i<m;i++){
            sb.append(answers[i]).append(' ');
        }
        System.out.print(sb);

    }
}
